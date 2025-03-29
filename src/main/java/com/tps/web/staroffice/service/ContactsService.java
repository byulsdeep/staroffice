package com.tps.web.staroffice.service;

import java.util.List;

import com.tps.web.staroffice.dto.ContactsDto;
import com.tps.web.staroffice.dto.EmployeeDto;

public interface ContactsService {
	public abstract boolean deleteContacts(ContactsDto contactsDto);
	public abstract boolean insertContacts(ContactsDto contactsDto);
	public abstract List<EmployeeDto> getMyContactsByQueryByEmployeeDepartmentCode(EmployeeDto employeeDto);
	public abstract List<EmployeeDto> getMyContactsByQuery(EmployeeDto employeeDto);
	public abstract List<EmployeeDto> getContactsByQueryByEmployeeDepartmentCode(EmployeeDto employeeDto);
	public abstract List<EmployeeDto> getContactsByQuery(EmployeeDto employeeDto);
}
