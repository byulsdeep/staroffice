package com.tps.web.staroffice.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.web.staroffice.dao.NotificationDao;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.entity.NotificationEntity;

public class NotificationDaoImpl extends SqlSessionDaoSupport implements NotificationDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<NotificationDto> getNotificationsLimit5(String employeeId) {
		return this.sqlSession.selectList("getNotificationsLimit5", employeeId);
	}

	@Override
	public int deleteNotificationByType(NotificationEntity notificationEntity) {
		return this.sqlSession.delete("deleteNotificationByType", notificationEntity);
	}
	@Override
	public int deleteNotification(NotificationEntity notificationEntity) {
		return this.sqlSession.delete("deleteNotification", notificationEntity);
	}
	@Override
	public List<NotificationDto> getNotifications(String employeeId) {
		return this.sqlSession.selectList("getNotifications", employeeId);
	}
	@Override
	public int insertNotification(NotificationEntity notificationEntity) {
		return this.sqlSession.insert("insertNotification", notificationEntity);
	}
	@Override
	public boolean getMessageNotificationExists(NotificationEntity notificationEntity) {
		return this.sqlSession.selectOne("getMessageNotificationExists", notificationEntity);
	}
	@Override
	public List<String> getNotificationReceivers(NotificationEntity notificationEntity) {
		return this.sqlSession.selectList("getNotificationReceivers", notificationEntity);
	}
}