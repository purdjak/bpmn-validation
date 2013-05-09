package validation;

/**
 * Factory object that can create a new validation engine.
 */
class ValidationEngineFactory {
	
	/**
	 * Returns a object that implements the specified parameters.
	 * @param resourceFile Set of validation rules.
	 * @param type Format of validation rules.
	 * @param name Name of the validation. Name will be used in MessageHandler.
	 * @return Object of validation engine by type.
	 * @throws ValidationException
	 */
	static AbstractValidationEngine newValidationEngine(java.io.File resourceFile, ValidationType type, String name) throws ValidationException{
		AbstractValidationEngine newVE = null;
		
		switch(type){
		case XSD :
			newVE = new ValidationEngineXSD(resourceFile, type, name);
			break;
		case DRL:
			newVE = new ValidationEngineDRL(resourceFile, type, name); 
			break;
		default:
			newVE = null;
			break;
		}
		return newVE;
	}
}
