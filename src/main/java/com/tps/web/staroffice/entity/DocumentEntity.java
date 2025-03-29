package com.tps.web.staroffice.entity;


public class DocumentEntity {

	private Integer documentDepartmentCode;
    private Integer documentNumber;
    private String documentEmployeeId;
    private String documentTitle;
    private String documentBody;
    private String documentCreated;
    private String documentUpdated;
    private Boolean documentDeleted;
    private Integer documentViewCount;

	public Integer getDocumentDepartmentCode() {
		return documentDepartmentCode;
	}
	public void setDocumentDepartmentCode(Integer documentDepartmentCode) {
		this.documentDepartmentCode = documentDepartmentCode;
	}
	public Integer getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getDocumentEmployeeId() {
		return documentEmployeeId;
	}
	public void setDocumentEmployeeId(String documentEmployeeId) {
		this.documentEmployeeId = documentEmployeeId;
	}
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	public String getDocumentBody() {
		return documentBody;
	}
	public void setDocumentBody(String documentBody) {
		this.documentBody = documentBody;
	}
	public String getDocumentCreated() {
		return documentCreated;
	}
	public void setDocumentCreated(String documentCreated) {
		this.documentCreated = documentCreated;
	}
	public String getDocumentUpdated() {
		return documentUpdated;
	}
	public void setDocumentUpdated(String documentUpdated) {
		this.documentUpdated = documentUpdated;
	}
	public Boolean isDocumentDeleted() {
		return documentDeleted;
	}
	public void setDocumentDeleted(Boolean documentDeleted) {
		this.documentDeleted = documentDeleted;
	}
	public Integer getDocumentViewCount() {
		return documentViewCount;
	}
	public void setDocumentViewCount(Integer documentViewCount) {
		this.documentViewCount = documentViewCount;
	}
}
