package com.tps.web.staroffice.dao;

import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.entity.EmployeeEntity;

public interface UserDao {

	public abstract int updateEmployeePhoto(EmployeeEntity employeeEntity);
	public abstract int deleteEmployee(String employeeId);
	public abstract int updateEmployeePassword(EmployeeEntity employeeEntity);
	public abstract EmployeeDto getEmployee(EmployeeEntity employeeEntity);
	public abstract int updateEmployee(EmployeeEntity employeeEntity);
	public abstract EmployeeDto getEmployeeByIdAndPassword(EmployeeEntity employeeEntity);
	public abstract int insertEmployee(EmployeeEntity employeeEntity);
	public abstract boolean checkEmployeeEmail(String employeeEmail);
	public abstract boolean checkEmployeeId(String employeeId);
}
