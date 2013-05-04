package validation;

/**
 * Set of message types.
 */
public enum MessageType {
	/**
	 * Recoverable error.
	 */
	error,
	
	/**
	 * Non-recoverable error.
	 */
	fatalError,
	
	/**
	 * Warning.
	 */
	warning,
	
	/**
	 * Note.
	 */
	note,
	
	/**
	 * Tip. It can be a tip for bug fix.
	 */
	tip;
}
