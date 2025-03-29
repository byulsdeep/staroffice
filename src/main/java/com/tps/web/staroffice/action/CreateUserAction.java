package com.tps.web.staroffice.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.service.UserService;

@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "sign_up_init", location = "2_sign_up.jsp"),
	@Result(name = "sign_up_fail", location = "2_sign_up.jsp"),
	@Result(name = "sign_up_success", location = "1_home.jsp"),

})
public class CreateUserAction extends ActionSupport {

	@Resource
	private UserService service;

	private EmployeeDto createUserInfo;
	private String message;

	@Action(value = "/sign_up_init")
	public String signUpInit() {
		return "sign_up_init";
	}

	@Action(value = "/sign_up")
	public String signUp() {
		if (this.service.checkEmployeeId(this.createUserInfo.getEmployeeId())) {
			this.message = "使用できないidです";
			return "sign_up_fail";
		}
		if (this.service.checkEmployeeEmail(this.createUserInfo.getEmployeeEmail())) {
			this.message = "使用できないe-mailです";
			return "sign_up_fail";
		}
		this.createUserInfo.setEmployeePhoto("https://cdn.imweb.me/thumbnail/20221203/fba3a2f258bdc.png");
		if (!this.service.insertEmployee(this.createUserInfo)) {
			this.message = "システムエラー";
			return "sign_up_fail";
		}
		this.message = "ようこそ、Star Officeへ、" + this.createUserInfo.getEmployeeLastname() + this.createUserInfo.getEmployeeFirstname() + "様。登録成功しました。ログインしてください。";
		return "sign_up_success";
	}
	public EmployeeDto getCreateUserInfo() {
		return createUserInfo;
	}
	public void setCreateUserInfo(EmployeeDto createUserInfo) {
		this.createUserInfo = createUserInfo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}