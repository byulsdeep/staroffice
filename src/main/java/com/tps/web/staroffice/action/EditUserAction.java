package com.tps.web.staroffice.action;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.service.UserService;

@ParentPackage("default")
@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "account", location = "4_account.jsp"),
	@Result(name = "ajaxResult", type = "json", params = { "root", "message" })
})
public class EditUserAction extends ActionSupport implements SessionAware {

	@Resource
	private UserService service;

	private File file;
	private String fileName;

	private EmployeeDto editUserInfo;

	private Map<String, Object> session;

	private String message;

	@Action(value = "/edit_user_image")
	public String editUserImage() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		String uploadPath = "C:\\dev_folder\\workspace\\staroffice\\src\\main\\webapp\\img\\userImage\\" + accessInfo.getEmployeeId();
		File localFile = new File(uploadPath, this.fileName);
		try {
			FileUtils.copyFile(this.file, localFile);

			// delete previous image
	        File[] filesInDirectory = new File(uploadPath).listFiles();
	        if (filesInDirectory != null) {
	            for (File file : filesInDirectory) {
	                if (!file.getName().equals(this.fileName)) {
	                    file.delete();
	                }
	            }
	        }
	        // db
	        this.editUserInfo = new EmployeeDto();
	        this.editUserInfo.setEmployeeId(accessInfo.getEmployeeId());
	        this.editUserInfo.setEmployeePhoto("./img/userImage/" + accessInfo.getEmployeeId() + "/" + this.fileName);
	        this.service.updateEmployeePhoto(this.editUserInfo);
	        this.session.clear();
	        this.session.put("accessInfo", this.service.getEmployee(this.editUserInfo));
			this.message = "写真が変更されました";
		} catch (Exception e) {
			this.message = "システムエラー";
			e.printStackTrace();
		}

		return "ajaxResult";
	}

	@Action(value = "/delete_user")
	public String deleteUser() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		if (this.service.deleteEmployee(accessInfo.getEmployeeId())) {
			this.session.clear();
			this.message = "アカウントを削除しました";
			return "home";
		} else {
			this.message = "システムエラー";
		}
		return "account";
	}
	@Action(value = "/edit_user_password")
	public String editUserPassword() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.editUserInfo.setEmployeeId(accessInfo.getEmployeeId());
		if (this.service.updateEmployeePassword(this.editUserInfo)) {
			this.message = "パスワードが変更されました";
		} else {
			this.message = "システムエラー";
		}
		return "account";
	}

	@Action(value = "/edit_user")
	public String editUser() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.editUserInfo.setEmployeeId(accessInfo.getEmployeeId());
		if (this.service.updateEmployee(this.editUserInfo)) {
			String accessTime = accessInfo.getAccessTime();
			accessInfo = this.service.getEmployee(this.editUserInfo);
			accessInfo.setAccessTime(accessTime);
			this.session.clear();
			this.session.put("accessInfo", accessInfo);
			this.message = "情報が変更されました";
		} else {
			this.message = "使用できないe-mailです";
		}
		return "account";
	}
	@Action(value = "/account_init")
	public String account() {
		EmployeeDto accessInfo = (EmployeeDto) this.getSession().get("accessInfo");
		if (accessInfo != null) {
			return "account";
		}
		return "home";
	}

	public EmployeeDto getEditUserInfo() {
		return editUserInfo;
	}
	public void setEditUserInfo(EmployeeDto editUserInfo) {
		this.editUserInfo = editUserInfo;
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
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}