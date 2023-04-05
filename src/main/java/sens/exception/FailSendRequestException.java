package sens.exception;

public class FailSendRequestException extends RuntimeException {

    public FailSendRequestException() {
        super();
    }

    public FailSendRequestException(String message) {
        super(message);
    }

    public FailSendRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailSendRequestException(Throwable cause) {
        super(cause);
    }

    protected FailSendRequestException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
