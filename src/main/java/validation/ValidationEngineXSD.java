/**
 * 
 */
package validation;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;

/**
 * 
 */
class ValidationEngineXSD extends ValidationEngineAbstract {
	private File XSDFile;

	ValidationEngineXSD(File resourceFile, ValidationType type, String name) {
		super(type, name);
		XSDFile = resourceFile;
	}

	@Override
	void validate(File in, MessageHandler mHandler) throws ValidationException {
		try {
	        XMLReaderJDOMFactory schemaFactory = new XMLReaderXSDFactory(XSDFile);
	        SAXBuilder builder = new SAXBuilder(schemaFactory);
	        builder.setErrorHandler(new XSDErrorHandler(this.type, this.name, mHandler));        
			builder.build(in);
		} catch (JDOMException | IOException ex) {
			throw new ValidationException(ex);
		}
	}

}
