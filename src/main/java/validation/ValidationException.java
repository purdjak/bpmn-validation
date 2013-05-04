package validation;

/**
 * Exception thrown when appear validation error.
 * @author JP
 *
 */
public class ValidationException extends Exception {

	/**
	 * Constructs a new ValidationException.
	 * @param cause
	 */
	public ValidationException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructs a new ValidationException.
	 * @param message
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Constructs a new ValidationException.
	 * @param message
	 * @param cause
	 */
	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 1L;
	
	

}
