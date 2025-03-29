package com.tps.web.staroffice.entity;


public class CommentsEntity {

	private Integer commentsDocumentDepartmentCode;
    private Integer commentsDocumentNumber;
    private String commentsEmployeeId;
    private String commentsBody;
    private String commentsCreated;
    private String commentsUpdated;
    private Boolean commentsDeleted;

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
}
