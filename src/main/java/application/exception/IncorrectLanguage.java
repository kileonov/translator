package application.exception;

public class IncorrectLanguage extends Exception {
    private String message;

    public IncorrectLanguage(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
