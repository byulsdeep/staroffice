package com.tps.web.staroffice.dto;


public class SavedDocumentDto {

	private String savedDocumentEmployeeId;
    private Integer savedDocumentDepartmentCode;
    private Integer savedDocumentNumber;

	public String getSavedDocumentEmployeeId() {
		return savedDocumentEmployeeId;
	}
	public void setSavedDocumentEmployeeId(String savedDocumentEmployeeId) {
		this.savedDocumentEmployeeId = savedDocumentEmployeeId;
	}
	public Integer getSavedDocumentDepartmentCode() {
		return savedDocumentDepartmentCode;
	}
	public void setSavedDocumentDepartmentCode(Integer savedDocumentDepartmentCode) {
		this.savedDocumentDepartmentCode = savedDocumentDepartmentCode;
	}
	public Integer getSavedDocumentNumber() {
		return savedDocumentNumber;
	}
	public void setSavedDocumentNumber(Integer savedDocumentNumber) {
		this.savedDocumentNumber = savedDocumentNumber;
	}
}
