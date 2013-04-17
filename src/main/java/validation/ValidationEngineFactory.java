package validation;

class ValidationEngineFactory {
	
	static ValidationEngineAbstract newValidationEngine(java.io.File resourceFile, ValidationType type, String name) throws ValidationException{
		ValidationEngineAbstract newVE = null;
		
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
