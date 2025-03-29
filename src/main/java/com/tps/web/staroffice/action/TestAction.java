package com.tps.web.staroffice.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.tps.web.staroffice.dto.ProductDto;

@ParentPackage("default")
@Results({
	@Result(name = "testResult", type = "json", params = { "root", "message" }),
	@Result(name = "test2Result", location = "test.jsp"),
})
public class TestAction extends ActionSupport {

	private File employeePhoto;
	private String message;

	private List<ProductDto> productList;

	@Action(value = "/test")
	public String test() {
		System.out.println("test");
		System.out.println(this.employeePhoto);
		this.message = "写真が変更されました";
		return "testResult";
	}

	@Action(value = "/test2")
	public String test2() {
		this.productList = new ArrayList<>();
		ProductDto product;
		for (int i = 0; i < 10; i++) {
			product = new ProductDto();
			product.setIsdeleted(i % 2 == 0 ? "true" : "false");
			this.productList.add(product);
		}
		return "test2Result";
	}

	public File getEmployeePhoto() {
		return employeePhoto;
	}
	public void setEmployeePhoto(File employeePhoto) {
		this.employeePhoto = employeePhoto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}
}