/**
 * 
 */
package validation;

/**
 * 
 *
 */
public interface MessageHandler{
	public void error(ValidationType type, String name, String content);
	
	public void fatalError(ValidationType type, String name, String content);

	public void warning(ValidationType type, String name, String content);
	
	public void note(ValidationType type, String name, String content);
	
	public void tip(ValidationType type, String name, String content);
}
