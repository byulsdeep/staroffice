package com.tps.web.staroffice.service;

import com.tps.web.staroffice.dto.EmployeeDto;

public interface UserService {

	public abstract int updateEmployeePhoto(EmployeeDto employeeDto);
	public abstract boolean deleteEmployee(String employeeId);
	public abstract boolean updateEmployeePassword(EmployeeDto employeeDto);
	public abstract EmployeeDto getEmployee(EmployeeDto employeeDto);
	public abstract boolean updateEmployee(EmployeeDto employeeDto);
	public abstract EmployeeDto getEmployeeByIdAndPassword(EmployeeDto employeeDto);
	public abstract boolean insertEmployee(EmployeeDto employeeDto);
	public abstract boolean checkEmployeeId(String employeeId);
	public abstract boolean checkEmployeeEmail(String employeeEmail);
}
