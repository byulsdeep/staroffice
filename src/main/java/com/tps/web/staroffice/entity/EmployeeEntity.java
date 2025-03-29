package com.tps.web.staroffice.entity;


public class EmployeeEntity {

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
	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", employeeEmail="
				+ employeeEmail + ", employeePassword=" + employeePassword
				+ ", employeeLastname=" + employeeLastname
				+ ", employeeFirstname=" + employeeFirstname
				+ ", employeeGradeCode=" + employeeGradeCode
				+ ", employeeDepartmentCode=" + employeeDepartmentCode
				+ ", employeePhone=" + employeePhone + ", employeePhoto="
				+ employeePhoto + ", employeeDeleted=" + employeeDeleted + "]";
	}
}
