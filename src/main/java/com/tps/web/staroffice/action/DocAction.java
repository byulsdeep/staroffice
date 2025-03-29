package com.tps.web.staroffice.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.CommentsDto;
import com.tps.web.staroffice.dto.DocumentDto;
import com.tps.web.staroffice.dto.EmployeeDto;
import com.tps.web.staroffice.dto.FilesDto;
import com.tps.web.staroffice.dto.NotificationDto;
import com.tps.web.staroffice.dto.SavedDocumentDto;
import com.tps.web.staroffice.service.DocService;
import com.tps.web.staroffice.service.NotificationService;

@ParentPackage("default")
@Results({
	@Result(name = "home", location = "1_home.jsp"),
	@Result(name = "doc", location = "7_doc.jsp"),
	@Result(name = "view_doc", location = "8_view_doc.jsp"),
	@Result(name = "write_doc", location = "9_write_doc.jsp"),
	@Result(name = "edit_doc", location = "10_edit_doc.jsp"),
	@Result(name = "save_success", location = "view_doc_init", params = {
			"doc.documentDepartmentCode", "${saveInfo.savedDocumentDepartmentCode}",
			"doc.documentNumber", "${saveInfo.savedDocumentNumber}",
			"message", "${message}"
	}, type = "redirect"),
	@Result(name = "delete_success", location = "doc_init", params = {
			"doc.query", "",
			"doc.documentDepartmentCode", "",
			"doc.currentPage", "1",
			"doc.myDoc", "false",
			"doc.sort", "newest",
			"message", "${message}"
	}, type = "redirect"),
//	@Result(name = "edit_comment_success", location = "view_doc_init", params = {
//			"doc.documentDepartmentCode", "${commentInfo.commentsDocumentDepartmentCode}",
//			"doc.documentNumber", "${commentInfo.commentsDocumentNumber}",
//			"message", "${message}"
//	}, type = "redirect"),
	@Result(name = "doc_success", location = "view_doc_init", params = {
			"doc.documentDepartmentCode", "${doc.documentDepartmentCode}",
			"doc.documentNumber", "${doc.documentNumber}",
			"message", "${message}"
	}, type = "redirect"),
	@Result(name = "ajaxResult", type = "json", params = { "root", "message" }),
	@Result(name = "edit_comment_success", type = "json", params = { "root", "doc" })
})
public class DocAction extends ActionSupport implements SessionAware {

	@Resource
	private DocService service;

	@Resource
	private NotificationService nService;

	private Map<String, Object> session;

	private String message;

	private List<DocumentDto> docs;
	private DocumentDto doc;
	private SavedDocumentDto saveInfo;
	private CommentsDto commentInfo;
	private int documentCount;
	private NotificationDto notification;
	private File[] attachedFiles;
	private List<String> attachedFileNames;
	private File file;
	private String fileName;

	@Action(value = "/doc_init")
	public String doc() {
//		http://localhost:8080/staroffice/doc_init?doc.query=&doc.documentDepartmentCode=&doc.currentPage=1&doc.myDoc=false&doc.sort=newest//		department / sort / saved

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		if (this.doc.getDocumentDepartmentCode() != null && this.doc.getDocumentDepartmentCode() == 0) {
			this.doc.setDocumentDepartmentCode(null);
		}
		this.doc.setOffset((this.doc.getCurrentPage() - 1) * 10);

		if (this.doc.isMyDoc()) {
			this.doc.setSavedDocumentEmployeeId(accessInfo.getEmployeeId());
			if (this.doc.getDocumentDepartmentCode() != null) {
				this.documentCount = this.service.getSavedDocumentsCount(this.doc);
				if (this.doc.getSort().equals("newest")) {
					this.docs = this.service.getNewestSavedDocuments(this.doc);
				} else if (this.doc.getSort().equals("mostViewed")) {
					this.docs = this.service.getMostViewedSavedDocuments(this.doc);
				}
			} else {
				this.documentCount = this.service.getSavedDocumentsCountFromAllDepartments(this.doc);
				if (this.doc.getSort().equals("newest")) {
					this.docs = this.service.getNewestSavedDocumentsFromAllDepartments(this.doc);
				} else if (this.doc.getSort().equals("mostViewed")) {
					this.docs = this.service.getMostViewedSavedDocumentsFromAllDepartments(this.doc);
				}
			}
		} else {
			if (this.doc.getDocumentDepartmentCode() != null) {
				this.documentCount = this.service.getDocumentsCount(this.doc);
				if (this.doc.getSort().equals("newest")) {
					this.docs = this.service.getNewestDocuments(this.doc);
				} else if (this.doc.getSort().equals("mostViewed")) {
					this.docs = this.service.getMostViewedDocuments(this.doc);
				}
			} else {
				this.documentCount = this.service.getDocumentsCountFromAllDepartments(this.doc);
				if (this.doc.getSort().equals("newest")) {
					this.docs = this.service.getNewestDocumentsFromAllDepartments(this.doc);
				} else if (this.doc.getSort().equals("mostViewed")) {
					this.docs = this.service.getMostViewedDocumentsFromAllDepartments(this.doc);
				}
			}
		}
		return "doc";
	}
	@Action(value = "/view_doc_init")
	public String viewDoc() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		this.doc.setSavedDocumentEmployeeId(accessInfo.getEmployeeId());
		this.service.updateDocumentViewCount(this.doc);
		this.doc = this.service.getDocument(this.doc);

		if (this.notification == null) {
			return "view_doc";
		}
		this.notification.setNotificationSender(this.doc.getDocumentEmployeeId());
		this.notification.setNotificationReceiver(accessInfo.getEmployeeId());

		System.out.println("delete check");
		System.out.println(this.notification);
		if (this.nService.deleteNotification(this.notification)) {
			System.out.println("deleted");
		} else {
			System.out.println("failed");
		}
		return "view_doc";
	}
	@Action(value = "/unsave_doc")
	public String unsaveDoc() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.saveInfo.setSavedDocumentEmployeeId(accessInfo.getEmployeeId());

		if (this.service.deleteSavedDocument(this.saveInfo)) {
			this.message = "排除しました";
		} else {
			this.message = "システムエラー";
		}
		return "save_success";
	}
	@Action(value = "/save_doc")
	public String saveDoc() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		this.saveInfo.setSavedDocumentEmployeeId(accessInfo.getEmployeeId());

		if (this.service.insertSavedDocument(this.saveInfo)) {
			this.message = "保存しました";
		} else {
			this.message = "システムエラー";
		}
		return "save_success";
	}
	@Action(value = "/delete_doc")
	public String deleteDoc() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		if (this.service.deleteDocument(this.doc)) {
			this.message = "削除しました";
		} else {
			this.message = "システムエラー";
		}
		return "delete_success";
	}
	@Action(value = "/write_doc_init")
	public String writeDocInit() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		return "write_doc";
	}
	@Action(value = "/write_doc")
	public String writeDoc() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		if (this.service.insertDocument(this.doc)) {
			this.message = "投稿しました";
		} else {
			this.message = "システムエラー";
		}
		this.doc.setDocumentNumber(this.service.getInsertedDocumentNumber(this.doc));

		if (this.attachedFiles != null) {
			String uploadPath = "C:\\dev_folder\\workspace\\staroffice\\src\\main\\webapp\\docFile\\" + this.doc.getDocumentDepartmentCode() + "\\" + this.doc.getDocumentNumber();
			String relativePath = "./docFile/" + this.doc.getDocumentDepartmentCode() + "/" + this.doc.getDocumentNumber();
			File localFile;
			FilesDto filesDto = new FilesDto();
			filesDto.setFilesDocumentDepartmentCode(this.doc.getDocumentDepartmentCode());
			filesDto.setFilesDocumentNumber(this.doc.getDocumentNumber());

			for (int i = 0; i < this.attachedFiles.length; i++) {
				localFile = new File(uploadPath, this.attachedFileNames.get(i));
				try {
					FileUtils.copyFile(this.attachedFiles[i], localFile);
					filesDto.setFilesName(this.attachedFileNames.get(i));
					filesDto.setFilesAbsolutePath(uploadPath + "\\" + this.attachedFileNames.get(i));
					filesDto.setFilesRelativePath(relativePath + "/" + this.attachedFileNames.get(i));
					this.service.insertFiles(filesDto);
				} catch (Exception e) {}
			}
		}

		NotificationDto notification = new NotificationDto();
		notification.setNotificationDocumentDepartmentCode(this.doc.getDocumentDepartmentCode());
		notification.setNotificationSender(this.doc.getDocumentEmployeeId());
		List<String> receivers = this.nService.getNotificationReceivers(notification);
		notification.setNotificationNotificationTypeCode(1);
		notification.setNotificationDocumentNumber(this.doc.getDocumentNumber());
		for (String receiver : receivers) {
			notification.setNotificationReceiver(receiver);
			this.nService.insertNotification(notification);
		}
				return "doc_success";
	}

	@Action(value = "/uploadDocImage")
	public String editUserImage() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";
		String uploadPath = "C:\\dev_folder\\workspace\\staroffice\\src\\main\\webapp\\img\\docImage\\";
		this.fileName = System.currentTimeMillis() + "_" + this.fileName;
		String relativePath = "./img/docImage/" + this.fileName;
		File localFile = new File(uploadPath, this.fileName);
		try {
			FileUtils.copyFile(this.file, localFile);
			this.message = relativePath;
		} catch (Exception e) {
			this.message = "システムエラー";
			e.printStackTrace();
		}

		return "ajaxResult";
	}


	@Action(value = "/edit_doc_init")
	public String editDocInit() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		this.doc.setSavedDocumentEmployeeId(accessInfo.getEmployeeId());
		this.doc = this.service.getDocument(this.doc);

		return "edit_doc";
	}
	@Action(value = "/edit_doc")
	public String editDoc() {
		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		if (this.service.updateDocument(this.doc)) {
			this.message = "修正しました";
		} else {
			this.message = "システムエラー";
		}

		if (this.attachedFiles != null) {

			String uploadPath = "C:\\dev_folder\\workspace\\staroffice\\src\\main\\webapp\\docFile\\" + this.doc.getDocumentDepartmentCode() + "\\" + this.doc.getDocumentNumber();

			File[] filesInDirectory = new File(uploadPath).listFiles();
			if (filesInDirectory != null) {
				for (File file : filesInDirectory) {
					file.delete();
				}
			}

			String relativePath = "./docFile/" + this.doc.getDocumentDepartmentCode() + "/" + this.doc.getDocumentNumber();
			File localFile;
			FilesDto filesDto = new FilesDto();
			filesDto.setFilesDocumentDepartmentCode(this.doc.getDocumentDepartmentCode());
			filesDto.setFilesDocumentNumber(this.doc.getDocumentNumber());
			this.service.deleteFiles(filesDto);

			for (int i = 0; i < this.attachedFiles.length; i++) {
				localFile = new File(uploadPath, this.attachedFileNames.get(i));
				try {
					FileUtils.copyFile(this.attachedFiles[i], localFile);
					filesDto.setFilesName(this.attachedFileNames.get(i));
					filesDto.setFilesAbsolutePath(uploadPath + "\\" + this.attachedFileNames.get(i));
					filesDto.setFilesRelativePath(relativePath + "/" + this.attachedFileNames.get(i));
					this.service.insertFiles(filesDto);
				} catch (Exception e) {}
			}
		}

		return "doc_success";
	}
	@Action(value = "/edit_comment")
	public String editComment() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		if (this.service.updateComments(this.commentInfo)) {
			this.doc = new DocumentDto();
			this.doc.setDocumentDepartmentCode(this.commentInfo.getCommentsDocumentDepartmentCode());
			this.doc.setDocumentNumber(this.commentInfo.getCommentsDocumentNumber());
			this.doc = this.service.getDocument(this.doc);
		}
		return "edit_comment_success";
	}
	@Action(value = "insert_comment")
	public String insertComment() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		if (this.service.insertComments(this.commentInfo)) {
			this.doc = new DocumentDto();
			this.doc.setDocumentDepartmentCode(this.commentInfo.getCommentsDocumentDepartmentCode());
			this.doc.setDocumentNumber(this.commentInfo.getCommentsDocumentNumber());
			this.doc = this.service.getDocument(this.doc);
		}
		return "edit_comment_success";
	}
	@Action(value = "/delete_comment")
	public String deleteComment() {

		EmployeeDto accessInfo = (EmployeeDto) this.session.get("accessInfo");
		if (accessInfo == null) return "home";

		if (this.service.deleteComments(this.commentInfo)) {
			this.doc = new DocumentDto();
			this.doc.setDocumentDepartmentCode(this.commentInfo.getCommentsDocumentDepartmentCode());
			this.doc.setDocumentNumber(this.commentInfo.getCommentsDocumentNumber());
			this.doc = this.service.getDocument(this.doc);
		}
		return "edit_comment_success";
	}

	public List<DocumentDto> getDocs() {
		return docs;
	}
	public void setDocs(List<DocumentDto> docs) {
		this.docs = docs;
	}
	public DocumentDto getDoc() {
		return doc;
	}
	public void setDoc(DocumentDto doc) {
		this.doc = doc;
	}
	public int getDocumentCount() {
		return documentCount;
	}
	public void setDocumentCount(int documentCount) {
		this.documentCount = documentCount;
	}
	public SavedDocumentDto getSaveInfo() {
		return saveInfo;
	}
	public void setSaveInfo(SavedDocumentDto saveInfo) {
		this.saveInfo = saveInfo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CommentsDto getCommentInfo() {
		return commentInfo;
	}
	public void setCommentInfo(CommentsDto commentInfo) {
		this.commentInfo = commentInfo;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public NotificationDto getNotification() {
		return notification;
	}
	public void setNotification(NotificationDto notification) {
		this.notification = notification;
	}
	public File[] getAttachedFiles() {
		return attachedFiles;
	}
	public void setAttachedFiles(File[] attachedFiles) {
		this.attachedFiles = attachedFiles;
	}
	public List<String> getAttachedFileNames() {
		return attachedFileNames;
	}
	public void setAttachedFileNames(List<String> attachedFileNames) {
		this.attachedFileNames = attachedFileNames;
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