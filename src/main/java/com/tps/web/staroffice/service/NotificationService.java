package com.tps.web.staroffice.service;

import java.util.List;

import com.tps.web.staroffice.dto.MessageDto;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.dto.PartnerDto;
import com.tps.web.staroffice.entity.NotificationEntity;

public interface NotificationService {

	public abstract List<NotificationDto> getNotificationsLimit5(String employeeId);

	public abstract boolean deleteNotificationByType(NotificationDto notificationDto);
	public abstract boolean deleteNotification(NotificationDto notificationDto);
	public abstract List<NotificationDto> getNotifications(String employeeId);
	public abstract boolean insertNotification(NotificationDto notificationDto);
	public abstract boolean getMessageNotificationExists(NotificationDto notificationDto);
	public abstract List<String> getNotificationReceivers(NotificationDto notificationDto);
}
