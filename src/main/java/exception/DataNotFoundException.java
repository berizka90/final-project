package exception;

public class DataNotFoundException extends Exception {

    public DataNotFoundException() {
        super("Data not found in DB by specified key");
    }

    /**
     * Constructs a new exception with the specified detail message.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}
