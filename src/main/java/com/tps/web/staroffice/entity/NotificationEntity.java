package com.tps.web.staroffice.entity;


public class NotificationEntity {

    private String notificationSender;
    private String notificationReceiver;
    private String notificationCreated;
    private Integer notificationNotificationTypeCode;
    private Integer notificationDocumentDepartmentCode;
    private Integer notificationDocumentNumber;

	public String getNotificationSender() {
		return notificationSender;
	}
	public void setNotificationSender(String notificationSender) {
		this.notificationSender = notificationSender;
	}
	public String getNotificationReceiver() {
		return notificationReceiver;
	}
	public void setNotificationReceiver(String notificationReceiver) {
		this.notificationReceiver = notificationReceiver;
	}
	public String getNotificationCreated() {
		return notificationCreated;
	}
	public void setNotificationCreated(String notificationCreated) {
		this.notificationCreated = notificationCreated;
	}
	public Integer getNotificationNotificationTypeCode() {
		return notificationNotificationTypeCode;
	}
	public void setNotificationNotificationTypeCode(
			Integer notificationNotificationTypeCode) {
		this.notificationNotificationTypeCode = notificationNotificationTypeCode;
	}
	public Integer getNotificationDocumentDepartmentCode() {
		return notificationDocumentDepartmentCode;
	}
	public void setNotificationDocumentDepartmentCode(
			Integer notificationDocumentDepartmentCode) {
		this.notificationDocumentDepartmentCode = notificationDocumentDepartmentCode;
	}
	public Integer getNotificationDocumentNumber() {
		return notificationDocumentNumber;
	}
	public void setNotificationDocumentNumber(Integer notificationDocumentNumber) {
		this.notificationDocumentNumber = notificationDocumentNumber;
	}
}