package com.tps.web.staroffice.dto;


public class EmployeeDto {

	private String employeeId;
	private String employeeEmail;
	private String employeePassword;
	private String employeeLastname;
	private String employeeFirstname;
	private Integer employeeGradeCode;
	private Integer employeeDepartmentCode;
	private String employeePhone;
	private String employeePhoto;
	private Boolean employeeDeleted;

	private String gradeName;
	private String departmentName;

	private String accessTime;
	private Boolean myContact;
	private String query;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
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
	public Integer getEmployeeGradeCode() {
		return employeeGradeCode;
	}
	public void setEmployeeGradeCode(Integer employeeGradeCode) {
		this.employeeGradeCode = employeeGradeCode;
	}
	public Integer getEmployeeDepartmentCode() {
		return employeeDepartmentCode;
	}
	public void setEmployeeDepartmentCode(Integer employeeDepartmentCode) {
		this.employeeDepartmentCode = employeeDepartmentCode;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePhoto() {
		return employeePhoto;
	}
	public void setEmployeePhoto(String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}
	public Boolean getEmployeeDeleted() {
		return employeeDeleted;
	}
	public void setEmployeeDeleted(Boolean employeeDeleted) {
		this.employeeDeleted = employeeDeleted;
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
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	public Boolean getMyContact() {
		return myContact;
	}
	public void setMyContact(Boolean myContact) {
		this.myContact = myContact;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeEmail="
				+ employeeEmail + ", employeePassword=" + employeePassword
				+ ", employeeLastname=" + employeeLastname
				+ ", employeeFirstname=" + employeeFirstname
				+ ", employeeGradeCode=" + employeeGradeCode
				+ ", employeeDepartmentCode=" + employeeDepartmentCode
				+ ", employeePhone=" + employeePhone + ", employeePhoto="
				+ employeePhoto + ", employeeDeleted=" + employeeDeleted
				+ ", gradeName=" + gradeName + ", departmentName="
				+ departmentName + ", accessTime=" + accessTime
				+ ", myContact=" + myContact + ", query=" + query + "]";
	}
}