package sens.exception;

public class FailCreateRequestException extends RuntimeException {

    public FailCreateRequestException() {
        super();
    }

    public FailCreateRequestException(String message) {
        super(message);
    }

    public FailCreateRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailCreateRequestException(Throwable cause) {
        super(cause);
    }

    protected FailCreateRequestException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
