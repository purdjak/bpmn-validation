package validation;

/**
 * This class provides a skeletal implementation of the validation engine. 
 */
abstract class ValidationEngineAbstract {
	protected ValidationType type;
	protected String name;
	
	/**
	 * Constructs a new ValidationEngineAbstract.
	 * @param type Sets a type of validation.
	 * @param name Sets name of validation.
	 */
	ValidationEngineAbstract(ValidationType type, String name){
		this.type = type;
		this.name = name;
	}
	
	/**
	 * Validates the specified BPMN input.
	 * @param in Input BPMN model.
	 * @param mHandler Sets the MessageHandler to receive messages encountered during the validate method invocation.
	 * @throws ValidationException
	 */
	abstract void validate(java.io.File in, MessageHandler mHandler) throws ValidationException;
}
