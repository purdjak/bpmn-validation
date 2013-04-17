/**
 * 
 */
package validation;

/**
 * 
 */
abstract class ValidationEngineAbstract {
	protected ValidationType type;
	protected String name;
	

	ValidationEngineAbstract(ValidationType type, String name){
		this.type = type;
		this.name = name;
	}
		
	abstract void validate(java.io.File in, MessageHandler mHandler) throws ValidationException;
}
