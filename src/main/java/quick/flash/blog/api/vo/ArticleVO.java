package quick.flash.blog.api.vo;

import java.util.Date;

/**
 * @author lihao
 * @date 2019-09-10 23:18
 */
public class ArticleVO extends BaseVO {
    private String title;
    private String originalContent;
    private String content;
    private Date createDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
