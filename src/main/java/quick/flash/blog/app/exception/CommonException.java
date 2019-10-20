package quick.flash.blog.app.exception;

public class CommonException extends RuntimeException {
    private String code;
    private Object[] params;

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CommonException(String message, String code, Object[] params) {
        super(message);
        this.code = code;
        this.params = params;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, Object[] params) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.params = params;
    }
}
