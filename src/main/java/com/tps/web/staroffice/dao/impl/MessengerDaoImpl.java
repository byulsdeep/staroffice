package com.tps.web.staroffice.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.web.staroffice.dao.MessengerDao;
import com.tps.web.staroffice.dto.PartnerDto;
import com.tps.web.staroffice.entity.MessageEntity;

public class MessengerDaoImpl extends SqlSessionDaoSupport implements MessengerDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertMessage(MessageEntity messageEntity) {
		int result = 0;
		while (result == 0) {
			try {
				result = this.sqlSession.insert("insertMessage", messageEntity);
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {}
			}
		}
		return result;
	}
	@Override
	public int updateMessageRead(MessageEntity messageEntity) {
		return this.sqlSession.update("updateMessageRead", messageEntity);
	}
	@Override
	public List<MessageEntity> getAllMessages(MessageEntity messageEntity) {
		return this.sqlSession.selectList("getAllMessages", messageEntity);
	}
	@Override
	public PartnerDto getMySelfAsPartnerInfo(String employeeId) {
		return this.sqlSession.selectOne("getMySelfAsPartnerInfo", employeeId);
	}
	@Override
	public PartnerDto getPartnerInfo(MessageEntity messageEntity) {
		return this.sqlSession.selectOne("getPartnerInfo", messageEntity);
	}
	@Override
	public List<PartnerDto> getAllPartnersInfo(String employeeId) {
		return this.sqlSession.selectList("getAllPartnersInfo", employeeId);
	}
}