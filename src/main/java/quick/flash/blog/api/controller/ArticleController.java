package quick.flash.blog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.flash.blog.api.vo.ArticleVO;
import quick.flash.blog.api.vo.TitleVO;
import quick.flash.blog.app.service.ArticleService;

/**
 * @author lihao
 * @date 2019-09-10 22:40
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/{article_id}")
    public ResponseEntity<ArticleVO> getArticle(@PathVariable(value = "article_id") Long articleId) {
        return Optional.ofNullable(articleService.getArticle(articleId))
                .map(target -> new ResponseEntity<>(target, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/list_title")
    public ResponseEntity<List<TitleVO>> listTitles() {
        return Optional.ofNullable(articleService.listTitles())
                .map(target -> new ResponseEntity<>(target, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
