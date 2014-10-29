package semanticprocessing;

/**
 *
 * @author Hussam
 */
public class InvalidCacheFileException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCacheFileException</code> without
     * detail message.
     */
    public InvalidCacheFileException() {
    }


    /**
     * Constructs an instance of <code>InvalidCacheFileException</code> with
     * the specified detail message.
     * @param msg the detail message.
     */
    public InvalidCacheFileException(String msg) {
        super(msg);
    }
}
