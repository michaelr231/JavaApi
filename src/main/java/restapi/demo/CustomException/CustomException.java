// Exception handling
package restapi.demo.CustomException;

public class CustomException extends Exception {
    private static final long serialVersionUID = 1L;

    private final String status;
    private final String message;

    public CustomException(String status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}