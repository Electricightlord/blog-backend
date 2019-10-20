package quick.flash.blog.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.RepositoryFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import quick.flash.blog.api.vo.hook.HookCommitsVO;
import quick.flash.blog.api.vo.hook.HookRootVO;
import quick.flash.blog.app.dto.ArticleDTO;
import quick.flash.blog.app.enums.OperateEnum;
import quick.flash.blog.app.exception.CommonException;
import quick.flash.blog.app.exception.GitlabApiException;
import quick.flash.blog.app.mapper.ArticleMapper;
import quick.flash.blog.app.service.HookService;
import quick.flash.blog.app.tools.GitlabClient;
import quick.flash.blog.app.tools.MarkDown2HtmlWrapper;
import quick.flash.blog.app.tools.entity.MarkDownEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import static quick.flash.blog.app.enums.OperateEnum.REMOVE;

/**
 * @author lihao
 * @date 2019-09-14 01:43
 */
@Service
public class HookServiceImpl implements HookService {
    private static final Logger log = LoggerFactory.getLogger(HookServiceImpl.class);

    private static final String REF = "refs/heads/master";
    private static final String IMAGE_PREFIX = "image/";

    @Autowired
    GitlabClient gitlabClient;

    @Autowired
    ArticleMapper articleMapper;


    @Override
    public void pushEvent(String body) {
        HookRootVO hookRootVO = JSONObject.parseObject(body, HookRootVO.class);
        GitLabApi gitLabApi = gitlabClient.getGitLabApi();
        String ref = hookRootVO.getRef();
        if (REF.equals(ref)) {
            processCommit(hookRootVO, hookRootVO.getCommits().get(0), gitLabApi);
        }
    }

    private void processCommit(HookRootVO hookRootVO, HookCommitsVO hookCommitsVO, GitLabApi gitLabApi) {
        List<String> add = hookCommitsVO.getAdded();
        List<String> modifiy = hookCommitsVO.getModified();
        List<String> removed = hookCommitsVO.getRemoved();
        if (!add.isEmpty()) {
            add.forEach(a -> getContentAndOperate(hookRootVO, gitLabApi, a, "add"));
        }
        if (!modifiy.isEmpty()) {
            modifiy.forEach(m -> getContentAndOperate(hookRootVO, gitLabApi, m, "modify"));
        }
        if (!removed.isEmpty()) {
            removed.forEach(r -> getContentAndOperate(hookRootVO, gitLabApi, r, "remove"));
        }
    }

    private void getContentAndOperate(HookRootVO hookRootVO, GitLabApi gitLabApi, String filePath, String type) {
        String content;
        FileOutputStream outputStream = null;
        OperateEnum operateEnum = OperateEnum.valueOf(type.toUpperCase());
        try {
            // 如果路径是 image/开头的则是图片，对图片进行处理
            if (filePath.startsWith(IMAGE_PREFIX)) {
                if (operateEnum.equals(REMOVE)) {
                    File file = new File(filePath);
                    file.deleteOnExit();
                } else {
                    RepositoryFile repositoryFileApi = gitLabApi.getRepositoryFileApi().getFile(hookRootVO.getProjectId().intValue(), filePath, hookRootVO.getRef());
                    outputStream = new FileOutputStream(new File(repositoryFileApi.getFilePath()));
                    outputStream.write(repositoryFileApi.getDecodedContentAsBytes());
                    outputStream.close();
                }
            } else {
                ArticleDTO articleDTO = new ArticleDTO();
                ArticleDTO oldArticleDTO;
                if (operateEnum.equals(REMOVE)) {
                    articleDTO.setTitle(getTitle(filePath));
                    oldArticleDTO = articleMapper.selectOne(articleDTO);
                } else {
                    content = new String(Base64.getDecoder().decode(gitLabApi.getRepositoryFileApi().getFile(hookRootVO.getProjectId().intValue(), filePath, hookRootVO.getRef()).getContent()));
                    MarkDownEntity markDownEntity = MarkDown2HtmlWrapper.ofContent(content);
                    articleDTO.setTitle(getTitle(filePath));
                    oldArticleDTO = articleMapper.selectOne(articleDTO);

                    articleDTO.setOriginalContent(content);
                    articleDTO.setContent(markDownEntity.toString());
                    articleDTO.setStatus("using");
                    articleMapper.insert(articleDTO);
                }
                if (oldArticleDTO != null) {
                    oldArticleDTO.setTitle(oldArticleDTO.getTitle() + "    deleted at:" + new Date());
                    oldArticleDTO.setStatus("deleted");
                    articleMapper.updateByPrimaryKeySelective(oldArticleDTO);
                }
            }
        } catch (GitLabApiException e) {
            throw new GitlabApiException(e.getMessage());
        } catch (IOException e) {
            throw new CommonException(e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                log.info(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private String getTitle(String filePath) {
        int lastSeparatorIndex = filePath.lastIndexOf('/');
        int lastDotIndex = filePath.lastIndexOf('.');
        lastDotIndex = lastDotIndex == -1 ? filePath.length() : lastDotIndex;
        return filePath.subSequence(lastSeparatorIndex + 1, lastDotIndex).toString();
    }
}
