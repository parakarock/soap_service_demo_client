package com.spring.nemo.soap_service_demo_client.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.spring.nemo.soap_service_demo_client.custumValidate.custumInputIDValidate;



public class UpdateData {
	
	@custumInputIDValidate(message="id must be number")
	@Min(value = 1, message = "id must not be less than 1 and not be null")
	Integer id;

	@NotNull(message = "Invalid Field name")
	@Size(max = 200, message = "Field name must not be greater 200 charactors")
	String name;
	
	@NotNull(message = "Invalid Field description")
	@Size(max = 200, message = "Field description must not be greater 200 charactors")
	String description;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
