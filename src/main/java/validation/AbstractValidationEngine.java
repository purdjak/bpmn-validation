package validation;

/**
 * This class provides a skeletal implementation of the validation engine. 
 */
abstract class AbstractValidationEngine {
	protected ValidationType type;
	protected String name;
	
	/**
	 * Constructs a new AbstractValidationEngine.
	 * @param type Sets a type of validation.
	 * @param name Sets name of validation.
	 */
	AbstractValidationEngine(ValidationType type, String name){
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
