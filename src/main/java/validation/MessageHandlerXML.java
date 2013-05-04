package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Message handler implementation for XML output. 
 */
public class MessageHandlerXML implements MessageHandler{
	private List <Message> messages;
	
	/**
	 * Constructs a new message handler.
	 */
	public MessageHandlerXML(){
		messages = new ArrayList<>();
	}

	@Override
	public void error(ValidationType type, String validationName, String content) {
		messages.add( new Message(type, MessageType.error, validationName, content) );
	}

	@Override
	public void fatalError(ValidationType type, String validationName, String content) {
		messages.add( new Message(type, MessageType.fatalError, validationName, content) );
	}

	@Override
	public void warning(ValidationType type, String validationName, String content) {
		messages.add( new Message(type, MessageType.warning, validationName, content) );
	}

	@Override
	public void note(ValidationType type, String validationName, String content) {
		messages.add( new Message(type, MessageType.note, validationName, content) );		
	}

	@Override
	public void tip(ValidationType type, String validationName, String content) {
		messages.add( new Message(type, MessageType.tip, validationName, content) );
	}
	
	/**
	 * Returns a validator output. Parameters will be used for filtering of output. 
	 * @param validationTypes If it's null then will be used all of values.
	 * @param messageTypes If it's null then will be used all of values.
	 * @param validationNames If it's null then will be used all of values.
	 * @return
	 */
	public Document outputDocument(Set <ValidationType> validationTypes, Set <MessageType> messageTypes, Set <String> validationNames){
		Element root = new Element("log");
		Document result = new Document();
		result.setRootElement(root);
 
		for(Message m : this.messages){
			if( ( validationTypes == null || validationTypes.contains(m.getValidationType()) ) &&
				( messageTypes == null    || messageTypes.contains(m.getMessageType())    ) &&
				( validationNames == null || validationNames.contains(m.getValidationName()) ) ) 
			{
				Element messageElement = new Element("message");
				messageElement.setAttribute("validationType", m.getMessageType().toString());
				messageElement.setAttribute("validationName", m.getValidationName());
				messageElement.setAttribute("messageType", m.getMessageType().toString());
				messageElement.setText(m.getContent());
		 
				result.getRootElement().addContent(messageElement);
			}
		}
		
		return result;
	}
	
	/**
	 * Returns a validator output. It's like call of method outputDocument(null, null, null).
	 * @return
	 */
	public Document outputDocument(){
		return outputDocument(null, null, null);
	}
	
	/**
	 * Returns a validator output. Parameters will be used for filtering of output. 
	 * @param validationTypes If it's null then will be used all of values.
	 * @param messageTypes If it's null then will be used all of values.
	 * @param validationNames If it's null then will be used all of values.
	 * @return
	 */
	public String outputString(Set <ValidationType> validationTypes, Set <MessageType> messageTypes, Set <String> validationNames){
		Document doc = outputDocument(validationTypes, messageTypes, validationNames);
		String result;
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		
		result = xmlOutput.outputString(doc) ;
		
		return result;
	}
	
	/**
	 * Returns a validator output. It's like call of method outputString(null, null, null).
	 * @return
	 */
	public String outputString(){
		return outputString(null, null, null);
	}

}
