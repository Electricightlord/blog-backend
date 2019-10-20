package quick.flash.blog.app.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.flash.blog.api.vo.ArticleVO;
import quick.flash.blog.api.vo.TitleVO;
import quick.flash.blog.app.dto.ArticleDTO;
import quick.flash.blog.app.mapper.ArticleMapper;
import quick.flash.blog.app.service.ArticleService;
import quick.flash.blog.app.tools.ConvertUtils;

/**
 * @author lihao
 * @date 2019-09-10 23:07
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleVO getArticle(Long articleId) {
        ArticleVO articleVO = null;
        try {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(articleId);
            articleDTO.setStatus("using");
            articleVO = ConvertUtils.convertObject(articleMapper.selectOne(articleDTO), ArticleVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleVO;
    }

    @Override
    public List<TitleVO> listTitles() {
        List<TitleVO> titleVOList = new ArrayList<>();
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setStatus("using");
        articleMapper.select(articleDTO)
                .stream()
                .sorted(Comparator.comparing(ArticleDTO::getId).reversed())
                .forEach(i -> {
                    try {
                        TitleVO titleVO = ConvertUtils.convertObject(i, TitleVO.class);
                        titleVOList.add(titleVO);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return titleVOList;
    }
}
