/**
 * 
 */
package validation;

/**
 * 
 *
 */
public class Validator {
	private MessageHandler mHandler;
	
	public void setMessageHandler(MessageHandler mHandler){
		this.mHandler = mHandler;
	}
		
	/**
	 * 
	 * @param resourceURL If it is null then it will use the default source.
	 * @param type
	 * @param name
	 */
	public void addValidation(java.net.URL resourceURL, ValidationType type, String name){
		//TODO
	}

	public void addValidation(java.io.File resourceFile, ValidationType type, String name){
		//TODO
	}
	
	public void validate(java.net.URL in){
		//TODO
	}
	
	public void validate(java.io.File in){
		//TODO
	}
	
}
