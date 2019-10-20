package quick.flash.blog.app.mapper;

import org.apache.ibatis.annotations.Param;
import quick.flash.blog.app.dto.ArticleDTO;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author lihao
 * @date 2019-09-10 23:04
 */
@org.apache.ibatis.annotations.Mapper
public interface ArticleMapper extends Mapper<ArticleDTO> {
    void deleteOld(@Param("articleDTO") ArticleDTO articleDTO);
}
