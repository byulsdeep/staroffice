package com.tps.web.staroffice.dto;

import java.util.List;

public class ConversationDto {

	private List<MessageDto> messages;
	private String date;

	public List<MessageDto> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageDto> messages) {
		this.messages = messages;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ConversationDto [messages=" + messages + ", date=" + date + "]";
	}
}