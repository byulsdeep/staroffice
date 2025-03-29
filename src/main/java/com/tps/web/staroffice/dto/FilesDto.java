package com.tps.web.staroffice.dto;


public class FilesDto {

    private Integer filesDocumentDepartmentCode;
    private Integer filesDocumentNumber;
    private Integer filesNumber;
    private String filesName;
    private String filesAbsolutePath;
    private String filesRelativePath;
	public Integer getFilesDocumentDepartmentCode() {
		return filesDocumentDepartmentCode;
	}
	public void setFilesDocumentDepartmentCode(Integer filesDocumentDepartmentCode) {
		this.filesDocumentDepartmentCode = filesDocumentDepartmentCode;
	}
	public Integer getFilesDocumentNumber() {
		return filesDocumentNumber;
	}
	public void setFilesDocumentNumber(Integer filesDocumentNumber) {
		this.filesDocumentNumber = filesDocumentNumber;
	}
	public Integer getFilesNumber() {
		return filesNumber;
	}
	public void setFilesNumber(Integer filesNumber) {
		this.filesNumber = filesNumber;
	}
	public String getFilesName() {
		return filesName;
	}
	public void setFilesName(String filesName) {
		this.filesName = filesName;
	}
	public String getFilesAbsolutePath() {
		return filesAbsolutePath;
	}
	public void setFilesAbsolutePath(String filesAbsolutePath) {
		this.filesAbsolutePath = filesAbsolutePath;
	}
	public String getFilesRelativePath() {
		return filesRelativePath;
	}
	public void setFilesRelativePath(String filesRelativePath) {
		this.filesRelativePath = filesRelativePath;
	}
}
