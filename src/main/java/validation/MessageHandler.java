/**
 * 
 */
package validation;

/**
 * Basic interface for message handlers.
 */
public interface MessageHandler{
	/**
	 * Receive notification of a recoverable error.
	 * @param type Format of validation rules.
	 * @param validationName Name of the validation.
	 * @param content Content of notification. 
	 */
	public void error(ValidationType type, String validationName, String content);
	
	/**
	 * Receive notification of a non-recoverable error.
	 * @param type Format of validation rules.
	 * @param validationName Name of the validation.
	 * @param content Content of notification. 
	 */
	public void fatalError(ValidationType type, String validationName, String content);

	/**
	 * Receive notification of a warning.
	 * @param type Format of validation rules.
	 * @param validationName Name of the validation.
	 * @param content Content of notification. 
	 */
	public void warning(ValidationType type, String validationName, String content);
	
	/**
	 * Receive notification of a note.
	 * @param type Format of validation rules.
	 * @param validationName Name of the validation.
	 * @param content Content of notification. 
	 */
	public void note(ValidationType type, String validationName, String content);
	
	/**
	 * Receive notification of a tip. It can be a tip for bug fix. 
	 * @param type Format of validation rules.
	 * @param validationName Name of the validation.
	 * @param content Content of notification. 
	 */
	public void tip(ValidationType type, String validationName, String content);
}
