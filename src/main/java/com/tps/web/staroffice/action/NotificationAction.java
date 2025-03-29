package com.tps.web.staroffice.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.service.NotificationService;

@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "notification", location = "13_notification.jsp"),
})
public class NotificationAction extends ActionSupport implements SessionAware {

	@Resource
	private NotificationService service;

	private Map<String, Object> session;
	private String message;

	private List<NotificationDto> notifications;

	@Action(value = "/notification_init")
	public String notification() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.notifications = this.service.getNotifications(accessInfo.getEmployeeId());

		for (NotificationDto n : this.notifications) {
			System.out.println(n);
		}
		return "notification";
	}

	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<NotificationDto> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<NotificationDto> notifications) {
		this.notifications = notifications;
	}
}