package validation;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * This is a implementation of validation engine. It uses DRL for define validation rules.
 */
class ValidationEngineDRL extends AbstractValidationEngine {
	private File DRLFile;
	
	/**
	 * Constructs a new ValidationEngineDRL.
	 * @param resourceFile Input of validation rules.
	 * @param type Sets a type of validation.
	 * @param name Sets name of validation.
	 * @throws ValidationException
	 */
	ValidationEngineDRL(java.io.File resourceFile, ValidationType type, String name) throws ValidationException {
		super(type, name);
		this.DRLFile = resourceFile;
	}

	@Override
	void validate(File in, MessageHandler mHandler) throws ValidationException {
		StatefulKnowledgeSession knowledgeSession = createKnowledgeSession(DRLFile);		
		Document doc = createXMLDocument(in); 
		
		knowledgeSession.setGlobal("gMessageHandler", mHandler);
		knowledgeSession.setGlobal("gType", this.type);
		knowledgeSession.setGlobal("gName", this.name);
		
        
        for(Element el : doc.getRootElement().getChildren()){
        	knowledgeSession.insert( el );
        }        
        
        knowledgeSession.fireAllRules();
	}
	
	/**
	 * Creates knowledge session for validation.
	 * @param DRLFile Input of validation rules.
	 * @return
	 * @throws ValidationException
	 */
	private StatefulKnowledgeSession createKnowledgeSession(java.io.File DRLFile) throws ValidationException{
        //compile the drl
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newFileResource(DRLFile), ResourceType.DRL);     
        
        //compilation errors
        if (kbuilder.hasErrors()) {
        	String message = "";
        	Iterator<KnowledgeBuilderError> errors = kbuilder.getErrors().iterator();
            while (errors.hasNext()) {
            	message += errors.next().getMessage();
            }
            throw new ValidationException("DRL rules compilation error", new Throwable(message));
        }

        //build kbase
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        //build and return ksession
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        return ksession;
	}
	
	/**
	 * Parses a input BPMN model.
	 * @param in BPMN to be validated.
	 * @return 
	 * @throws ValidationException
	 */
	private Document createXMLDocument(File in) throws ValidationException {		 
		Document result = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			result = builder.build(in);			
		} catch (JDOMException | IOException ex) {
			throw new ValidationException(ex);
		}
		return result;
    }

}
