package com.tps.web.staroffice.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.web.staroffice.dao.ContactsDao;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.entity.ContactsEntity;

public class ContactsDaoImpl extends SqlSessionDaoSupport implements ContactsDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int deleteContacts(ContactsEntity contactsEntity) {
		return this.sqlSession.delete("deleteContacts", contactsEntity);
	}
	@Override
	public int insertContacts(ContactsEntity contactsEntity) {
		return this.sqlSession.insert("insertContacts", contactsEntity);
	}
	@Override
	public List<EmployeeDto> getMyContactsByQueryAndEmployeeDepartmentCode(
			EmployeeDto employeeDto) {
		return this.sqlSession.selectList("getMyContactsByQueryAndEmployeeDepartmentCode", employeeDto);
	}
	@Override
	public List<EmployeeDto> getMyContactsByQuery(EmployeeDto employeeDto) {
		return this.sqlSession.selectList("getMyContactsByQuery", employeeDto);
	}
	@Override
	public List<EmployeeDto> getContactsByQueryAndEmployeeDepartmentCode(
			EmployeeDto employeeDto) {
		return this.sqlSession.selectList("getContactsByQueryAndEmployeeDepartmentCode", employeeDto);
	}
	@Override
	public List<EmployeeDto> getContactsByQuery(EmployeeDto employeeDto) {
		return this.sqlSession.selectList("getContactsByQuery", employeeDto);
	}
}