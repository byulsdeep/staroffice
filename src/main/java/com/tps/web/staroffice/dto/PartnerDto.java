package com.tps.web.staroffice.dto;

public class PartnerDto {

	private String partnerId;
	private String partnerLastname;
	private String partnerFirstname;
	private String partnerPhoto;
	private String lastMessageSent;
	private String lastMessageBody;
	private Boolean lastMessageRead;

	private String myId;
	private Integer unreadCount;

	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerLastname() {
		return partnerLastname;
	}
	public void setPartnerLastname(String partnerLastname) {
		this.partnerLastname = partnerLastname;
	}
	public String getPartnerFirstname() {
		return partnerFirstname;
	}
	public void setPartnerFirstname(String partnerFirstname) {
		this.partnerFirstname = partnerFirstname;
	}
	public String getPartnerPhoto() {
		return partnerPhoto;
	}
	public void setPartnerPhoto(String partnerPhoto) {
		this.partnerPhoto = partnerPhoto;
	}
	public String getLastMessageSent() {
		return lastMessageSent;
	}
	public void setLastMessageSent(String lastMessageSent) {
		this.lastMessageSent = lastMessageSent;
	}
	public String getLastMessageBody() {
		return lastMessageBody;
	}
	public void setLastMessageBody(String lastMessageBody) {
		this.lastMessageBody = lastMessageBody;
	}
	public Boolean getLastMessageRead() {
		return lastMessageRead;
	}
	public void setLastMessageRead(Boolean lastMessageRead) {
		this.lastMessageRead = lastMessageRead;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public Integer getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}
	@Override
	public String toString() {
		return "PartnerDto [partnerId=" + partnerId + ", partnerLastname="
				+ partnerLastname + ", partnerFirstname=" + partnerFirstname
				+ ", partnerPhoto=" + partnerPhoto + ", lastMessageSent="
				+ lastMessageSent + ", lastMessageBody=" + lastMessageBody
				+ ", lastMessageRead=" + lastMessageRead + ", myId=" + myId
				+ ", unreadCount=" + unreadCount + "]";
	}
}