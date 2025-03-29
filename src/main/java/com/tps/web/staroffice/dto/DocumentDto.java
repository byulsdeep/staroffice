package com.tps.web.staroffice.dto;

import java.util.List;

public class DocumentDto {

    private Integer documentDepartmentCode;
    private Integer documentNumber;
    private String documentEmployeeId;
    private String documentTitle;
    private String documentBody;
    private String documentCreated;
    private String documentUpdated;
    private Boolean documentDeleted;
    private Integer documentViewCount;

    private String departmentName;
    private String employeeLastname;
    private String employeeFirstname;

	private List<CommentsDto> comments;
	private List<FilesDto> files;

	private String query;
	private Boolean myDoc;
	private String sort;
	private Integer offset;
	private Integer currentPage;
	private String savedDocumentEmployeeId;

	private Integer commentsCount;

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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	public List<CommentsDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentsDto> comments) {
		this.comments = comments;
	}
	public List<FilesDto> getFiles() {
		return files;
	}
	public void setFiles(List<FilesDto> files) {
		this.files = files;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Boolean isMyDoc() {
		return myDoc;
	}
	public void setMyDoc(Boolean myDoc) {
		this.myDoc = myDoc;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}
	public String getSavedDocumentEmployeeId() {
		return savedDocumentEmployeeId;
	}
	public void setSavedDocumentEmployeeId(String savedDocumentEmployeeId) {
		this.savedDocumentEmployeeId = savedDocumentEmployeeId;
	}
	@Override
	public String toString() {
		return "DocumentDto [documentDepartmentCode=" + documentDepartmentCode
				+ ", documentNumber=" + documentNumber
				+ ", documentEmployeeId=" + documentEmployeeId
				+ ", documentTitle=" + documentTitle + ", documentBody="
				+ documentBody + ", documentCreated=" + documentCreated
				+ ", documentUpdated=" + documentUpdated + ", documentDeleted="
				+ documentDeleted + ", documentViewCount=" + documentViewCount
				+ ", departmentName=" + departmentName + ", employeeLastname="
				+ employeeLastname + ", employeeFirstname=" + employeeFirstname
				+ ", comments=" + comments + ", files=" + files + ", query="
				+ query + ", myDoc=" + myDoc + ", sort=" + sort + ", offset="
				+ offset + ", currentPage=" + currentPage
				+ ", savedDocumentEmployeeId=" + savedDocumentEmployeeId
				+ ", commentsCount=" + commentsCount + "]";
	}
}