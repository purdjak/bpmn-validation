/**
 * 
 */
package validation;

/**
 * Message handler implementation for standard output.
 */
public class MessageHandlerOut implements MessageHandler{

	@Override
	public void error(ValidationType type, String validationName, String content) {
		System.out.println("Error:\t\t\t"+content);
		System.out.println("Validation name:\t"+validationName);
		System.out.println("Validation type:\t"+type);
	}

	@Override
	public void fatalError(ValidationType type, String validationName, String content) {
		System.out.println("Fatal error:\t\t\t"+content);
		System.out.println("Validation name:\t"+validationName);
		System.out.println("Validation type:\t"+type);
	}

	@Override
	public void warning(ValidationType type, String validationName, String content) {
		System.out.println("Warning:\t\t"+content);
		System.out.println("Validation name:\t"+validationName);
		System.out.println("Validation type:\t"+type);
	}

	@Override
	public void note(ValidationType type, String validationName, String content) {
		System.out.println("Note:\t\t\t"+content);
		System.out.println("Validation name:\t"+validationName);
		System.out.println("Validation type:\t"+type);
	}

	@Override
	public void tip(ValidationType type, String validationName, String content) {
		System.out.println("Tip:\t\t\t"+content);
		System.out.println("Validation name:\t"+validationName);
		System.out.println("Validation type:\t"+type);
	}
	

}
