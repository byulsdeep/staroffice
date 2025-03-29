package com.tps.web.staroffice.dao;

import java.util.List;

import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.entity.NotificationEntity;

public interface NotificationDao {

	public abstract List<NotificationDto> getNotificationsLimit5(String employeeId);

	public abstract int deleteNotificationByType(NotificationEntity notificationEntity);
	public abstract int deleteNotification(NotificationEntity notificationEntity);
	public abstract List<NotificationDto> getNotifications(String employeeId);
	public abstract int insertNotification(NotificationEntity notificationEntity);
	public abstract boolean getMessageNotificationExists(NotificationEntity notificationEntity);
	public abstract List<String> getNotificationReceivers(NotificationEntity notificationEntity);
}
