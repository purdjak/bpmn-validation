/**
 * 
 */
package validation;

import org.xml.sax.Locator;

/**
 * @author JP
 *
 */
public class ValidationParseException extends org.xml.sax.SAXParseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationParseException(String message, Locator locator) {
		super(message, locator);
		// TODO Auto-generated constructor stub
	}

	public ValidationParseException(String message, Locator locator, Exception e) {
		super(message, locator, e);
		// TODO Auto-generated constructor stub
	}

	public ValidationParseException(String message, String publicId,
			String systemId, int lineNumber, int columnNumber) {
		super(message, publicId, systemId, lineNumber, columnNumber);
		// TODO Auto-generated constructor stub
	}

	public ValidationParseException(String message, String publicId,
			String systemId, int lineNumber, int columnNumber, Exception e) {
		super(message, publicId, systemId, lineNumber, columnNumber, e);
		// TODO Auto-generated constructor stub
	}

	

}
