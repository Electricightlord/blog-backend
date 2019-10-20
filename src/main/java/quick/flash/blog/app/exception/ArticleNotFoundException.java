package quick.flash.blog.app.exception;

/**
 * @author lihao
 * @date 2019-09-13 17:48
 */
public class ArticleNotFoundException extends RuntimeException {
    private String code;
    private Object[] params;

    public ArticleNotFoundException() {
        super();
    }

    public ArticleNotFoundException(String message) {
        super(message);
    }

    public ArticleNotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ArticleNotFoundException(String message, String code, Object[] params) {
        super(message);
        this.code = code;
        this.params = params;
    }

    public ArticleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, Object[] params) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.params = params;
    }
}
