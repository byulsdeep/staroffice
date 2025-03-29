	package com.tps.web.staroffice.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.ConversationDto;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.dto.MessageDto;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.dto.PartnerDto;
import com.tps.web.staroffice.service.MessengerService;
import com.tps.web.staroffice.service.NotificationService;
import com.tps.web.staroffice.service.UserService;

@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "messenger", location = "11_messenger.jsp"),
	@Result(name = "chat", location = "12_chat.jsp"),
	@Result(name = "save_success", location = "view_doc_init", params = {
			"doc.documentDepartmentCode", "${saveInfo.savedDocumentDepartmentCode}",
			"doc.documentNumber", "${saveInfo.savedDocumentNumber}",
			"message", "${message}"
	}, type = "redirect"),
	@Result(name = "insert_success", location = "chat_init", params = {
			"chatInfo.messageReceiver", "${chatInfo.messageSender}",
			"chatInfo.messageSender", "${chatInfo.messageReceiver}",
			"message", "${message}"
	}, type = "redirect")
})
public class MessengerAction extends ActionSupport implements SessionAware {

	@Resource
	private MessengerService service;

	@Resource
	private UserService userService;

	@Resource
	private NotificationService nService;

	private Map<String, Object> session;
	private String message;

	private List<PartnerDto> partnersInfo;
	private MessageDto chatInfo;
	private PartnerDto partnerInfo;
	private List<ConversationDto> conversations;
	private String partnerId;

	@Action(value = "/messenger_init")
	public String messenger() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		this.partnersInfo = this.service.getAllPartnersInfo(accessInfo.getEmployeeId());

		for (PartnerDto partner : this.partnersInfo) {
			System.out.println(partner);
		}
		return "messenger";
	}

	@Action(value = "/chat_init")
	public String chatInit() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		System.out.println("chat_init_this.chatInfo");
		System.out.println(this.chatInfo);
		if (this.chatInfo.getMessageSender().equals(this.chatInfo.getMessageReceiver())) {
			//自分とチャット
			this.partnerInfo = this.service.getMySelfAsPartnerInfo(this.chatInfo.getMessageReceiver());
			System.out.println("getMessageSender().equals(this.chatInfo.getMessageReceiver()");
			System.out.println("this.partnerInfo = this.service.getMySelfAsPartnerInfo();");
		} else {
			this.partnerInfo = this.service.getPartnerInfo(this.chatInfo);
			System.out.println("else");
			System.out.println("this.partnerInfo = this.service.getPartnerInfo(this.chatInfo);");
		}

		//初めてこの人とちゃっとする
		if (this.partnerInfo == null) {
			System.out.println("this.partnerInfo == null");
			EmployeeDto partnerInfo = new EmployeeDto();
			partnerInfo.setEmployeeId(this.chatInfo.getMessageSender());
			partnerInfo = this.userService.getEmployee(partnerInfo);
			this.partnerInfo = new PartnerDto();
			this.partnerInfo.setPartnerId(partnerInfo.getEmployeeId());
			this.partnerInfo.setPartnerLastname(partnerInfo.getEmployeeLastname());
			this.partnerInfo.setPartnerFirstname(partnerInfo.getEmployeeFirstname());
			this.partnerInfo.setPartnerPhoto(partnerInfo.getEmployeePhoto());
			System.out.println("this.partnerInfo");
			System.out.println(this.partnerInfo);
			return "chat";
		}
		//既存ちゃっとのデータを読み込む
		List<MessageDto> allMessages = this.service.getAllMessages(this.chatInfo);

		this.conversations = new ArrayList<>();

		ConversationDto conversation = null;

		for (int i = 0; i < allMessages.size(); i++) {
			if (conversation == null || !conversation.getDate().equals(allMessages.get(i).getMessageSent().substring(0, 10))) {
				conversation = new ConversationDto();
				conversation.setDate(allMessages.get(i).getMessageSent().substring(0, 10));
				conversation.setMessages(new ArrayList<>());
				this.conversations.add(conversation);
			}
			conversation.getMessages().add(allMessages.get(i));
		}
		this.service.updateMessageRead(this.chatInfo);
		NotificationDto notification = new NotificationDto();
		notification.setNotificationSender(this.chatInfo.getMessageSender());
		notification.setNotificationReceiver(this.chatInfo.getMessageReceiver());
		notification.setNotificationNotificationTypeCode(2);
		this.nService.deleteNotificationByType(notification);

		return "chat";
	}
	@Action(value = "/send_message")
	public String sendMessage() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		System.out.println(this.chatInfo);
		if (!this.service.insertMessage(this.chatInfo)) {
			this.message = "システムエラー";
			return "insert_success";
		}
		NotificationDto notification = new NotificationDto();
		notification.setNotificationSender(this.chatInfo.getMessageSender());
		notification.setNotificationReceiver(this.chatInfo.getMessageReceiver());
		notification.setNotificationNotificationTypeCode(2);
		if (this.nService.getMessageNotificationExists(notification)) {
			this.nService.deleteNotificationByType(notification);
		}
		this.nService.insertNotification(notification);

		return "insert_success";
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<PartnerDto> getPartnersInfo() {
		return partnersInfo;
	}
	public void setPartnersInfo(List<PartnerDto> partnersInfo) {
		this.partnersInfo = partnersInfo;
	}
	public PartnerDto getPartnerInfo() {
		return partnerInfo;
	}
	public void setPartnerInfo(PartnerDto partnerInfo) {
		this.partnerInfo = partnerInfo;
	}
	public List<ConversationDto> getConversations() {
		return conversations;
	}
	public void setConversations(List<ConversationDto> conversations) {
		this.conversations = conversations;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public MessageDto getChatInfo() {
		return chatInfo;
	}
	public void setChatInfo(MessageDto chatInfo) {
		this.chatInfo = chatInfo;
	}
}