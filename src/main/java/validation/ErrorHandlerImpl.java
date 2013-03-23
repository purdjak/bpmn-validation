/**
 * 
 */
package validation;

import org.xml.sax.SAXParseException;

/**
 * @author JP
 *
 */
public class ErrorHandlerImpl implements ErrorHandler {

	public void error(ValidationParseException exception) throws ValidationException {
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public void error(SAXParseException exception) throws ValidationException {
		error( (ValidationParseException) exception );
	}
	
	public void fatalError(ValidationParseException exception) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatalError(SAXParseException exception) throws ValidationException {
		fatalError( (ValidationParseException) exception );
	}

	public void warning(ValidationParseException exception) throws ValidationException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void warning(SAXParseException exception) throws ValidationException {
		warning((ValidationParseException) exception);
	}

}
