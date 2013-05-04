package validation;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Error handler implementation of SAX error handler.
 */
class XSDErrorHandler implements ErrorHandler {
	private ValidationType type;
	private String name;
	private MessageHandler mHandler;
	
	/**
	 * Constructs a new XSDErrorHandler.
	 * @param type
	 * @param name
	 * @param mHandler
	 */
	protected XSDErrorHandler(ValidationType type, String name, MessageHandler mHandler) {
		this.type = type;
		this.name = name;
		this.mHandler = mHandler;
	}

	@Override
	public
	void error(SAXParseException ex) throws SAXException {
		mHandler.error(type, name,"Line: " + ex.getLineNumber() + " Column: " + ex.getColumnNumber() + " Message: " + ex.getMessage());
	}

	@Override
	public void fatalError(SAXParseException ex) throws SAXException {
		mHandler.fatalError(type, name,"Line: " + ex.getLineNumber() + " Column: " + ex.getColumnNumber() + " Message: " + ex.getMessage());
	}

	@Override
	public void warning(SAXParseException ex) throws SAXException {
		mHandler.warning(type, name,"Line: " + ex.getLineNumber() + " Column: " + ex.getColumnNumber() + " Message: " + ex.getMessage());
	}

}
