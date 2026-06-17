package james_app;

public class IllegalOverdraftLimitException extends Exception {
    public IllegalOverdraftLimitException(String message) {
        super(message);
    }
}
