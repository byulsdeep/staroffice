package com.tps.web.staroffice.entity;


public class MessageEntity {

    private String messageSender;
    private String messageReceiver;
    private String messageSent;
    private String messageBody;
    private Boolean messageRead;

	public String getMessageSender() {
		return messageSender;
	}
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}
	public String getMessageReceiver() {
		return messageReceiver;
	}
	public void setMessageReceiver(String messageReceiver) {
		this.messageReceiver = messageReceiver;
	}
	public String getMessageSent() {
		return messageSent;
	}
	public void setMessageSent(String messageSent) {
		this.messageSent = messageSent;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public Boolean getMessageRead() {
		return messageRead;
	}
	public void setMessageRead(Boolean messageRead) {
		this.messageRead = messageRead;
	}
	@Override
	public String toString() {
		return "MessageEntity [messageSender=" + messageSender
				+ ", messageReceiver=" + messageReceiver + ", messageSent="
				+ messageSent + ", messageBody=" + messageBody
				+ ", messageRead=" + messageRead + "]";
	}
}
