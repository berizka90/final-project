package exception;

public class DataBaseConnectionException extends Exception {

    public DataBaseConnectionException() {
        super("Unable to connect to database");
    }

    /**
     * Constructs a new exception with the specified detail message.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public DataBaseConnectionException(String message) {
        super(message);
    }
}
