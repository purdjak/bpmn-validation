/**
 * 
 */
package validation.output;

/**
 * @author JP
 *
 */
public class Outputer {
	private static final Outputer INSTANCE = new Outputer();
	
	private Outputer(){ };
	
	public static Outputer getInstance(){
		return INSTANCE;
	}
	
	public void message(String level, String validatorName, String value){
		//TODO 
	}
	
	public void outputXML(java.io.OutputStream out){
		//TODO
	}
	
	public void outputXML(java.io.OutputStream out, java.util.List<String> levels, java.util.List<String> validatorNames){
		//TODO
	}
	
	public void outputPlainText(java.io.OutputStream out){
		//TODO
	}
	
	public void outputPlainText(java.io.OutputStream out, java.util.List<String> levels, java.util.List<String> validatorNames){
		//TODO
	}
	
	public String outputString(){
		//TODO
		return null;
	}
	
	public String outputString(java.util.List<String> levels, java.util.List<String> validatorNames){
		//TODO
		return null;
	}
}
