package com.tps.web.staroffice.dao;

import java.util.List;

import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.entity.ContactsEntity;

public interface ContactsDao {
	public abstract int deleteContacts(ContactsEntity contactsEntity);
	public abstract int insertContacts(ContactsEntity contactsEntity);
	public abstract List<EmployeeDto> getMyContactsByQueryAndEmployeeDepartmentCode(EmployeeDto employeeDto);
	public abstract List<EmployeeDto> getMyContactsByQuery(EmployeeDto employeeDto);
	public abstract List<EmployeeDto> getContactsByQueryAndEmployeeDepartmentCode(EmployeeDto employeeDto);
	public abstract List<EmployeeDto> getContactsByQuery(EmployeeDto employeeDto);
}
