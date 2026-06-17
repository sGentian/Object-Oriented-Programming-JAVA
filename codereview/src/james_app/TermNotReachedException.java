package james_app;

public class TermNotReachedException extends RuntimeException {
    public TermNotReachedException(String message) {
        super(message);
    }
}
