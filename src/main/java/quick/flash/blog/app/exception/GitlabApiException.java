package quick.flash.blog.app.exception;

/**
 * @author lihao
 * @date 2019-09-13 17:49
 */
public class GitlabApiException extends RuntimeException {
    private String code;
    private Object[] params;

    public GitlabApiException() {
        super();
    }

    public GitlabApiException(String message) {
        super(message);
    }

    public GitlabApiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public GitlabApiException(String message, String code, Object[] params) {
        super(message);
        this.code = code;
        this.params = params;
    }

    public GitlabApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, Object[] params) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.params = params;
    }
}
