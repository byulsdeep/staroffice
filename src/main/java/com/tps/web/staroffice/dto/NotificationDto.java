package com.tps.web.staroffice.dto;


public class NotificationDto {

    private String notificationSender;
    private String notificationReceiver;
    private String notificationCreated;
    private Integer notificationNotificationTypeCode;
    private Integer notificationDocumentDepartmentCode;
    private Integer notificationDocumentNumber;

    private String employeeLastname;
    private String employeeFirstname;
    private String gradeName;
    private String departmentName;
    private String employeePhoto;
    private String notificationTypeName;

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
	public String getEmployeeLastname() {
		return employeeLastname;
	}
	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}
	public String getEmployeeFirstname() {
		return employeeFirstname;
	}
	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getEmployeePhoto() {
		return employeePhoto;
	}
	public void setEmployeePhoto(String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}
	public String getNotificationTypeName() {
		return notificationTypeName;
	}
	public void setNotificationTypeName(String notificationTypeName) {
		this.notificationTypeName = notificationTypeName;
	}
	@Override
	public String toString() {
		return "NotificationDto [notificationSender=" + notificationSender
				+ ", notificationReceiver=" + notificationReceiver
				+ ", notificationCreated=" + notificationCreated
				+ ", notificationNotificationTypeCode="
				+ notificationNotificationTypeCode
				+ ", notificationDocumentDepartmentCode="
				+ notificationDocumentDepartmentCode
				+ ", notificationDocumentNumber=" + notificationDocumentNumber
				+ ", employeeLastname=" + employeeLastname
				+ ", employeeFirstname=" + employeeFirstname + ", gradeName="
				+ gradeName + ", departmentName=" + departmentName
				+ ", employeePhoto=" + employeePhoto
				+ ", notificationTypeName=" + notificationTypeName + "]";
	}
}