package quick.flash.blog.api.vo;

/**
 * @author lihao
 * @date 2019-09-10 22:51
 */
public class TitleVO extends BaseVO{
    private Long id;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}