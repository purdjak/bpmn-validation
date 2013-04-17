package validation;

public class ValidationException extends Exception {

	public ValidationException(Throwable cause) {
		super(cause);
	}
	
	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
