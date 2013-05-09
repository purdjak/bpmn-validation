package validation;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * A processor that checks BPMN model against validation rules.
 */
public class Validator {
	private List <AbstractValidationEngine> validatorEngines;
	private MessageHandler mHandler;
	
	/**
	 * Constructor will create a validator with empty validation list. 
	 */
	public Validator(){
		this.validatorEngines = new ArrayList<>();
		this.mHandler = null;
	}
	
	/**
	 * Sets the MessageHandler to receive messages encountered during the validate method invocation. 
	 * @param mHandler
	 */
	public void setMessageHandler(MessageHandler mHandler){
		this.mHandler = mHandler;
	}
		
	/**
	 * Appends the specified validation to the end of validation list.
	 * @param resourceURL Set of validation rules.
	 * @param type Format of validation rules.
	 * @param name Name of the validation. Name will be used in MessageHandler.
	 * @throws ValidationException 
	 */
	public void addValidation(java.net.URL resourceURL, ValidationType type, String name) throws ValidationException{
		try {
			addValidation(new File(resourceURL.toURI()), type, name);
		} catch (URISyntaxException ex) {
			throw new ValidationException(ex);
		}
	}

	/**
	 * Appends the specified validation to the end of validation list.
	 * @param resourceFile Set of validation rules.
	 * @param type Format of validation rules.
	 * @param name Name of the validation. Name will be used in MessageHandler.
	 * @throws ValidationException 
	 */
	public void addValidation(java.io.File resourceFile, ValidationType type, String name) throws ValidationException{
		validatorEngines.add( ValidationEngineFactory.newValidationEngine(resourceFile, type, name) );
	}
	
	/**
	 * Calls method addValidation for set of default validations.
	 * @throws ValidationException
	 */
	public void addDefaultValidations() throws ValidationException{
		this.addValidation(new java.io.File("src//main//rules//xsd//BPMN20.xsd"), ValidationType.XSD, "BPMN 2.0");
		this.addValidation(new java.io.File("src//main//rules//drl//AttributesValidation.drl"), ValidationType.DRL, "jBPM 5 validation of attributes");
		this.addValidation(new java.io.File("src//main//rules//drl//ElementValidation.drl"), ValidationType.DRL, "jBPM 5 validation of elements");
	}
	
	/**
	 * Validates the specified BPMN input. Validator will use a specified validation list.
	 * @param in BPMN to be validated. BPMN input must be XML document. 
	 * @throws ValidationException 
	 */
	public void validate(java.net.URL in) throws ValidationException {
		try {
			validate(new File(in.toURI()));
		} catch (URISyntaxException ex) {
			throw new ValidationException(ex);
		}
	}
	
	/**
	 * Validates the specified BPMN input. Validator will use a specified validation list.
	 * @param in BPMN to be validated. BPMN input must be XML document. 
	 * @throws ValidationException
	 */
	public void validate(java.io.File in) throws ValidationException {
		for(AbstractValidationEngine va : validatorEngines){			
				va.validate(in, mHandler);			
		}
	}
	
}
