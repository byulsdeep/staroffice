package com.tps.web.staroffice.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.web.staroffice.dao.UserDao;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.entity.EmployeeEntity;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int updateEmployeePhoto(EmployeeEntity employeeEntity) {
		return this.sqlSession.update("updateEmployeePhoto", employeeEntity);
	}
	@Override
	public int deleteEmployee(String employeeId) {
		return this.sqlSession.update("deleteEmployee", employeeId);
	}
	@Override
	public int updateEmployeePassword(EmployeeEntity employeeEntity) {
		return this.sqlSession.update("updateEmployeePassword", employeeEntity);
	}
	@Override
	public EmployeeDto getEmployee(EmployeeEntity employeeEntity) {
		return this.sqlSession.selectOne("getEmployee", employeeEntity);
	}
	@Override
	public int updateEmployee(EmployeeEntity employeeEntity) {
		int result = -99;
		try {
			result = this.sqlSession.update("updateEmployee", employeeEntity);
		} catch (Exception e) {}
		return result;
	}
	@Override
	public EmployeeDto getEmployeeByIdAndPassword(EmployeeEntity employeeEntity) {
		return this.sqlSession.selectOne("getEmployeeByIdAndPassword", employeeEntity);
	}
	@Override
	public int insertEmployee(EmployeeEntity employeeEntity) {
		return this.sqlSession.insert("insertEmployee", employeeEntity);
	}
	@Override
	public boolean checkEmployeeEmail(String employeeEmail) {
		return this.sqlSession.selectOne("checkEmployeeEmail", employeeEmail);
	}
	@Override
	public boolean checkEmployeeId(String employeeId) {
		return this.sqlSession.selectOne("checkEmployeeId", employeeId);
	}
}