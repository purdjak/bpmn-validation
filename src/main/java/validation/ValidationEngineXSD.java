package validation;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;

/**
 * This is a implementation of validation engine. It uses XSD for define validation rules.
 */
class ValidationEngineXSD extends ValidationEngineAbstract {
	private File XSDFile;

	/**
	 * Constructs a new ValidationEngineXSD.
	 * @param resourceFile Input of validation rules.
	 * @param type Sets a type of validation.
	 * @param name Sets name of validation.
	 */
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
