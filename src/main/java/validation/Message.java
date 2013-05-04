package validation;

/**
 * Representation of validation output message. It's used by some message handlers.
 */
class Message {
	private ValidationType vType;
	private MessageType mType;
	private String validationName; 
	private String content;
	
	/**
	 * Constructs a new message. 
	 * @param vType Type of validation. 
	 * @param mType Type of message.
	 * @param validationName 
	 * @param content
	 */
	protected Message(ValidationType vType, MessageType mType, String validationName, String content){
		this.vType = vType;
		this.mType = mType;
		this.validationName = validationName; 
		this.content = content;
	}
	
	/**
	 * Returns value of validation type.
	 * @return
	 */
	public ValidationType getValidationType() {
		return vType;
	}
	
	/**
	 * Returns value of message type.
	 * @return
	 */
	public MessageType getMessageType() {
		return mType;
	}
	
	/**
	 * Returns validation name.
	 * @return
	 */
	public String getValidationName() {
		return validationName;
	}
	
	/**
	 * Returns message content.
	 * @return
	 */
	public String getContent() {
		return content;
	}
	
	
}
