/**
 * 
 */
package validation;

/**
 * @author JP
 *
 */
public class Validator {
	private ErrorHandler eHandler;
	
	public void setErrorHandler(ErrorHandler eHandler){
		this.eHandler = eHandler;
	}
		
	/**
	 * 
	 * @param resourceURL If it is null then it will use the default source.
	 * @param type
	 * @param name
	 */
	public void addValidation(java.net.URL resourceURL, ResourceType type, String name){
		//TODO
	}

	public void addValidation(java.io.File resourceURL, ResourceType type, String name){
		//TODO
	}
	
	public void validation(java.net.URL in){
		//TODO
	}
	
	public void validation(java.io.File in){
		//TODO
	}
	
}
