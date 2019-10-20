package quick.flash.blog.app.service;

import java.util.List;

import quick.flash.blog.api.vo.ArticleVO;
import quick.flash.blog.api.vo.TitleVO;

/**
 * @author lihao
 * @date 2019-09-10 23:07
 */
public interface ArticleService {
    ArticleVO getArticle(Long articleId);
    List<TitleVO> listTitles();
}
