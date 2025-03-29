	package com.tps.web.staroffice.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.ContactsDto;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.service.ContactsService;

@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "contacts", location = "5_contacts.jsp"),
	@Result(name = "success_search_user", location = "search_user", params = {
			"queryInfo.query", "${queryInfo.query}",
			"queryInfo.employeeDepartmentCode",
			"${queryInfo.employeeDepartmentCode}",
			"message", "${message}",
			"followInfo.userContact", "false"
			}, type = "redirect"),
	@Result(name = "success_user_contacts", location = "user_contacts", params = {
			"queryInfo.query", "${queryInfo.query}",
			"queryInfo.employeeDepartmentCode",
			"${queryInfo.employeeDepartmentCode}",
			"message", "${message}" ,
			"followInfo.userContact", "true"
	}, type = "redirect"),
})
public class ContactsAction extends ActionSupport implements SessionAware {

	@Resource
	private ContactsService service;
	private Map<String, Object> session;
	private List<EmployeeDto> contacts;
	private EmployeeDto queryInfo;
	private ContactsDto followInfo;
	private String message;

	@Action(value = "/remove_contact")
	public String removeContact() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.followInfo.setContactsFollower(accessInfo.getEmployeeId());
		if (this.service.deleteContacts(this.followInfo)) {
			this.message = "連絡先を削除しました";
			if (this.followInfo.isUserContact()) {
				return "success_user_contacts";
			}
			return "success_search_user";
		} else {
			this.message = "システムエラー";
		}
		return "contacts";
	}
	@Action(value = "/add_contact")
	public String addContact() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.followInfo.setContactsFollower(accessInfo.getEmployeeId());
		if (this.service.insertContacts(this.followInfo)) {
			this.message = "連絡先を追加しました";
			if (this.followInfo.isUserContact()) {
				return "success_user_contacts";
			}
			return "success_search_user";
		} else {
			this.message = "システムエラー";
		}
		return "contacts";
	}
	@Action(value = "/user_contacts")
	public String userContacts() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.queryInfo.setEmployeeId(accessInfo.getEmployeeId());

		if (this.queryInfo.getEmployeeDepartmentCode() == null) {
			this.contacts = this.service.getMyContactsByQuery(this.queryInfo);
		} else {
			this.contacts = this.service.getMyContactsByQueryByEmployeeDepartmentCode(this.queryInfo);
		}
		return "contacts";
	}
	@Action(value = "/search_user")
	public String searchUser() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.queryInfo.setEmployeeId(accessInfo.getEmployeeId());

		if (this.queryInfo.getEmployeeDepartmentCode() == null) {
			this.contacts = this.service.getContactsByQuery(this.queryInfo);
		} else {
			this.contacts = this.service.getContactsByQueryByEmployeeDepartmentCode(this.queryInfo);
		}
		return "contacts";
	}
	@Action(value = "/contacts_init")
	public String contactsInit() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		return "contacts";
	}
	public List<EmployeeDto> getContacts() {
		return contacts;
	}
	public void setContacts(List<EmployeeDto> contacts) {
		this.contacts = contacts;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public EmployeeDto getQueryInfo() {
		return queryInfo;
	}
	public void setQueryInfo(EmployeeDto queryInfo) {
		this.queryInfo = queryInfo;
	}
	public ContactsDto getFollowInfo() {
		return followInfo;
	}
	public void setFollowInfo(ContactsDto followInfo) {
		this.followInfo = followInfo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}