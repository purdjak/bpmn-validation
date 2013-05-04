package validation;

/**
 * Format of validation rules
 */
public enum ValidationType {
	/**
	 * Validation by XML schema
	 */
	XSD,
	
	/**
	 * Validation by rules in Drools Rule Language
	 */
	DRL;
}
