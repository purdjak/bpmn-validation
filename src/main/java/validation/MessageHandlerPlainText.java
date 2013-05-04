package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Message handler implementation for plain text output.
 */
public class MessageHandlerPlainText implements MessageHandler {
private List <Message> messages;
	
	/**
	 * Constructs a new message handler.
	 */
	public MessageHandlerPlainText(){
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
	public String outputString(Set <ValidationType> validationTypes, Set <MessageType> messageTypes, Set <String> validationNames){
		String result = "";
 
		for(Message m : this.messages){
			if( ( validationTypes == null || validationTypes.contains(m.getValidationType()) ) &&
				( messageTypes == null    || messageTypes.contains(m.getMessageType())    ) &&
				( validationNames == null || validationNames.contains(m.getValidationName()) ) ) 
			{				
				result += m.getMessageType() + ": " + m.getContent();
				result += "Validation name: " + m.getValidationName();
				result += "Validation type: " + m.getValidationType();
			}
		}
		
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
