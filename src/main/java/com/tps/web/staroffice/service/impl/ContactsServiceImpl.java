package com.tps.web.staroffice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.web.staroffice.customer.utils.StarUtil;
import com.tps.web.staroffice.dao.ContactsDao;
import com.tps.web.staroffice.dto.ContactsDto;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.entity.ContactsEntity;
import com.tps.web.staroffice.service.ContactsService;

@Service
public class ContactsServiceImpl implements ContactsService {

	@Resource
	private ContactsDao dao;

	@Override
	public boolean deleteContacts(ContactsDto contactsDto) {
		ContactsEntity contactsEntity = new ContactsEntity();
		BeanUtils.copyProperties(contactsDto, contactsEntity);
		return StarUtil.convertToBoolean(this.dao.deleteContacts(contactsEntity));
	}
	@Override
	public boolean insertContacts(ContactsDto contactsDto) {
		ContactsEntity contactsEntity = new ContactsEntity();
		BeanUtils.copyProperties(contactsDto, contactsEntity);
		return StarUtil.convertToBoolean(this.dao.insertContacts(contactsEntity));
	}
	@Override
	public List<EmployeeDto> getMyContactsByQueryByEmployeeDepartmentCode(
			EmployeeDto employeeDto) {
		return this.dao.getMyContactsByQueryAndEmployeeDepartmentCode(employeeDto);
	}
	@Override
	public List<EmployeeDto> getMyContactsByQuery(EmployeeDto employeeDto) {
		return this.dao.getMyContactsByQuery(employeeDto);

	}
	@Override
	public List<EmployeeDto> getContactsByQueryByEmployeeDepartmentCode(
			EmployeeDto employeeDto) {
		return this.dao.getContactsByQueryAndEmployeeDepartmentCode(employeeDto);
	}
	@Override
	public List<EmployeeDto> getContactsByQuery(EmployeeDto employeeDto) {
		return this.dao.getContactsByQuery(employeeDto);
	}
}