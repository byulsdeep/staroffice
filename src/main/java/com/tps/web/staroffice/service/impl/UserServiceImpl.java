package com.tps.web.staroffice.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.web.staroffice.customer.utils.StarUtil;
import com.tps.web.staroffice.dao.UserDao;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.entity.EmployeeEntity;
import com.tps.web.staroffice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao dao;

	@Override
	public int updateEmployeePhoto(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		return this.dao.updateEmployeePhoto(employeeEntity);
	}
	@Override
	public boolean deleteEmployee(String employeeId) {
		return StarUtil.convertToBoolean(this.dao.deleteEmployee(employeeId));
	}
	@Override
	public boolean updateEmployeePassword(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		employeeEntity.setEmployeePassword(StarUtil.encode(employeeEntity.getEmployeePassword()));
		return StarUtil.convertToBoolean(this.dao.updateEmployeePassword(employeeEntity));
	}
	@Override
	public EmployeeDto getEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		employeeEntity.setEmployeePassword(StarUtil.encode(employeeEntity.getEmployeePassword()));
		return this.dao.getEmployee(employeeEntity);
	}
	@Override
	public boolean updateEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		return StarUtil.convertToBoolean(this.dao.updateEmployee(employeeEntity));
	}
	@Override
	public EmployeeDto getEmployeeByIdAndPassword(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		employeeEntity.setEmployeePassword(StarUtil.encode(employeeEntity.getEmployeePassword()));
		return this.dao.getEmployeeByIdAndPassword(employeeEntity);
	}
	@Override
	public boolean insertEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		employeeEntity.setEmployeePassword(StarUtil.encode(employeeEntity.getEmployeePassword()));
		employeeEntity.setEmployeeGradeCode(1);
		return StarUtil.convertToBoolean(this.dao.insertEmployee(employeeEntity));
	}
	@Override
	public boolean checkEmployeeEmail(String employeeEmail) {
		return this.dao.checkEmployeeEmail(employeeEmail);
	}
	@Override
	public boolean checkEmployeeId(String employeeId) {
		return this.dao.checkEmployeeId(employeeId);
	}
}