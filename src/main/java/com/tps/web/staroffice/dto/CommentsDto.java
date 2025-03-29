package com.tps.web.staroffice.dto;

public class CommentsDto {

	private Integer commentsDocumentDepartmentCode;
    private Integer commentsDocumentNumber;
    private String commentsEmployeeId;
    private String commentsBody;
    private String commentsCreated;
    private String commentsUpdated;
    private Boolean commentsDeleted;

	private String employeeLastname;
	private String employeeFirstname;

	public Integer getCommentsDocumentDepartmentCode() {
		return commentsDocumentDepartmentCode;
	}
	public void setCommentsDocumentDepartmentCode(Integer commentsDocumentDepartmentCode) {
		this.commentsDocumentDepartmentCode = commentsDocumentDepartmentCode;
	}
	public Integer getCommentsDocumentNumber() {
		return commentsDocumentNumber;
	}
	public void setCommentsDocumentNumber(Integer commentsDocumentNumber) {
		this.commentsDocumentNumber = commentsDocumentNumber;
	}
	public String getCommentsEmployeeId() {
		return commentsEmployeeId;
	}
	public void setCommentsEmployeeId(String commentsEmployeeId) {
		this.commentsEmployeeId = commentsEmployeeId;
	}
	public String getCommentsBody() {
		return commentsBody;
	}
	public void setCommentsBody(String commentsBody) {
		this.commentsBody = commentsBody;
	}
	public String getCommentsCreated() {
		return commentsCreated;
	}
	public void setCommentsCreated(String commentsCreated) {
		this.commentsCreated = commentsCreated;
	}
	public String getCommentsUpdated() {
		return commentsUpdated;
	}
	public void setCommentsUpdated(String commentsUpdated) {
		this.commentsUpdated = commentsUpdated;
	}
	public Boolean isCommentsDeleted() {
		return commentsDeleted;
	}
	public void setCommentsDeleted(Boolean commentsDeleted) {
		this.commentsDeleted = commentsDeleted;
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
	@Override
	public String toString() {
		return "CommentsDto [commentsDocumentDepartmentCode="
				+ commentsDocumentDepartmentCode + ", commentsDocumentNumber="
				+ commentsDocumentNumber + ", commentsEmployeeId="
				+ commentsEmployeeId + ", commentsBody=" + commentsBody
				+ ", commentsCreated=" + commentsCreated + ", commentsUpdated="
				+ commentsUpdated + ", commentsDeleted=" + commentsDeleted
				+ ", employeeLastname=" + employeeLastname
				+ ", employeeFirstname=" + employeeFirstname + "]";
	}
}
