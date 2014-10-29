package semanticprocessing;

/**
 *
 * @author Hussam
 */
public class InvalidFileException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCacheFileException</code> without
     * detail message.
     */
    public InvalidFileException() {
    }


    /**
     * Constructs an instance of <code>InvalidCacheFileException</code> with
     * the specified detail message.
     * @param msg the detail message.
     */
    public InvalidFileException(String msg) {
        super(msg);
    }
}
