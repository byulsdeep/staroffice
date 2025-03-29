package com.tps.web.staroffice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.web.staroffice.customer.utils.StarUtil;
import com.tps.web.staroffice.dao.NotificationDao;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.entity.NotificationEntity;
import com.tps.web.staroffice.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Resource
	private NotificationDao dao;

	@Override
	public List<NotificationDto> getNotificationsLimit5(String employeeId) {
		return this.dao.getNotificationsLimit5(employeeId);
	}

	@Override
	public boolean deleteNotificationByType(NotificationDto notificationDto) {
		NotificationEntity notificationEntity = new NotificationEntity();
		BeanUtils.copyProperties(notificationDto, notificationEntity);
		return StarUtil.convertToBoolean(this.dao.deleteNotificationByType(notificationEntity));
	}
	@Override
	public boolean deleteNotification(NotificationDto notificationDto) {
		NotificationEntity notificationEntity = new NotificationEntity();
		BeanUtils.copyProperties(notificationDto, notificationEntity);
		return StarUtil.convertToBoolean(this.dao.deleteNotification(notificationEntity));
	}
	@Override
	public List<NotificationDto> getNotifications(String employeeId) {
		return this.dao.getNotifications(employeeId);
	}
	@Override
	public boolean insertNotification(NotificationDto notificationDto) {
		NotificationEntity notificationEntity = new NotificationEntity();
		BeanUtils.copyProperties(notificationDto, notificationEntity);
		return StarUtil.convertToBoolean(this.dao.insertNotification(notificationEntity));
	}
	@Override
	public boolean getMessageNotificationExists(NotificationDto notificationDto) {
		NotificationEntity notificationEntity = new NotificationEntity();
		BeanUtils.copyProperties(notificationDto, notificationEntity);
		return this.dao.getMessageNotificationExists(notificationEntity);
	}
	@Override
	public List<String> getNotificationReceivers(NotificationDto notificationDto) {
		NotificationEntity notificationEntity = new NotificationEntity();
		BeanUtils.copyProperties(notificationDto, notificationEntity);
		return this.dao.getNotificationReceivers(notificationEntity);
	}
}