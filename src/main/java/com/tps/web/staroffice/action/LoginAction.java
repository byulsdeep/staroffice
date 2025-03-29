package com.tps.web.staroffice.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.customer.utils.StarUtil;
import com.tps.web.staroffice.dto.DocumentDto;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.service.DocService;
import com.tps.web.staroffice.service.NotificationService;
import com.tps.web.staroffice.service.UserService;

@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "main", location = "3_main.jsp")
})
public class LoginAction extends ActionSupport implements SessionAware {

	private static final Logger logger = Logger.getLogger("");

	@Resource
	private UserService service;

	@Resource
	private DocService dService;
	@Resource
	private NotificationService nService;

	private Map<String, Object> session;

	private EmployeeDto loginUserInfo;

	private List<DocumentDto> newDocs;
	private List<DocumentDto> myDocs;
	private List<NotificationDto> notifications;

	private String message;

	@Action(value = "/")
	public String home() {

		this.loginUserInfo = (EmployeeDto) this.getSession().get("accessInfo");

		if (this.loginUserInfo != null) {
			this.newDocs = this.dService.getNewestDocumentsFromAllDepartmentsLimit5();
			DocumentDto doc = new DocumentDto();
			doc.setSavedDocumentEmployeeId(this.loginUserInfo.getEmployeeId());
			this.myDocs = this.dService.getNewestSavedDocumentsFromAllDepartmentsLimit5(doc);
			this.notifications = this.nService.getNotificationsLimit5(this.loginUserInfo.getEmployeeId());
			return "main";
		}
		logger.info("ウェルカムトゥスターオフィス");
		return "home";
	}

	@Action(value = "/logout")
	public String logout() {
		EmployeeDto accessInfo = (EmployeeDto) this.getSession().get("accessInfo");
		if (accessInfo != null) {
			this.session.clear();
		}
		return "home";
	}

	@Action(value = "/login")
	public String login() {

		// リフレッシュ制御
		EmployeeDto accessInfo = (EmployeeDto) this.getSession().get("accessInfo");
		if (accessInfo != null) {
			this.loginUserInfo = accessInfo;

			return "main";
		}

		// ログイン
		this.loginUserInfo = this.service.getEmployeeByIdAndPassword(this.loginUserInfo);

		if (this.loginUserInfo != null) {
			this.loginUserInfo.setAccessTime(StarUtil.formatDate(new Date()));
			this.session.put("accessInfo", this.loginUserInfo);
			this.newDocs = this.dService.getNewestDocumentsFromAllDepartmentsLimit5();
			DocumentDto doc = new DocumentDto();
			doc.setSavedDocumentEmployeeId(this.loginUserInfo.getEmployeeId());
			this.myDocs = this.dService.getNewestSavedDocumentsFromAllDepartmentsLimit5(doc);
			this.notifications = this.nService.getNotificationsLimit5(this.loginUserInfo.getEmployeeId());
			return "main";
		}
		this.message = "間違ってる情報です";
		return "home";
	}

	public EmployeeDto getLoginUserInfo() {
		return loginUserInfo;
	}
	public void setLoginUserInfo(EmployeeDto loginUserInfo) {
		this.loginUserInfo = loginUserInfo;
	}
	public List<DocumentDto> getNewDocs() {
		return newDocs;
	}
	public void setNewDocs(List<DocumentDto> newDocs) {
		this.newDocs = newDocs;
	}
	public List<DocumentDto> getMyDocs() {
		return myDocs;
	}
	public void setMyDocs(List<DocumentDto> myDocs) {
		this.myDocs = myDocs;
	}
	public List<NotificationDto> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<NotificationDto> notifications) {
		this.notifications = notifications;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
