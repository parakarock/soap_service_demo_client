package com.spring.nemo.soap_service_demo_client.service;



import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.spring.nemo.soap_service_demo_client.DAO.CourseImpl;
import com.spring.nemo.soap_service_demo_client.courses.CourseDetails;
import com.spring.nemo.soap_service_demo_client.exception.UserNotFoundException;
import com.spring.nemo.soap_service_demo_client.exception.ValidatationException;
import com.spring.nemo.soap_service_demo_client.model.InsertData;
import com.spring.nemo.soap_service_demo_client.model.ResponseData;
import com.spring.nemo.soap_service_demo_client.model.UpdateData;

@RestController
public class CourseService {

	@Autowired
	CourseImpl courseService;

	@GetMapping("/getAllCourse")
	public ResponseData getAllCourseDetailsResponse() {
		ResponseData response = new ResponseData(200, courseService.getAllCourse());
		System.out.println("hello");
		return response;
	}

	@GetMapping("/getCourse/{id}")
	public ResponseData getCourseDetailsResponse(@PathVariable int id) {
		CourseDetails result;
		try {
			result = courseService.getCourseById(id);
		} catch (SoapFaultClientException e) {
			throw new UserNotFoundException("Not Found By Id : " + id);
		}
		ResponseData response = new ResponseData(200,result);
		return response;
	}

	@GetMapping("/removeCourse/{id}")
	public ResponseData deleteCourseDetailsResponse(@PathVariable int id) {
		ResponseData response = new ResponseData(200, courseService.deleteCourseById(id));
		return response;
	}

	@PostMapping("/insertCourse")
	public ResponseData insertCourseDetailsResponse(@Valid @RequestBody InsertData item , BindingResult valid) {
		if (valid.hasErrors()) {
			ArrayList<String> errors = new ArrayList<String>();
			for (int i = 0; i < valid.getErrorCount(); i++) {
				errors.add(valid.getFieldErrors().get(i).getDefaultMessage());
			}
			throw new ValidatationException(errors.toString());
		}else {
			ResponseData response = new ResponseData(200,
					courseService.addNewCourse(item.getName(), item.getDescription()));
			return response;
		}
	}

	@PostMapping("/updateCourse")
	public ResponseData updateCourseDetailsResponse(@Valid @RequestBody UpdateData item, BindingResult valid) {
		if (valid.hasErrors()) {
			ArrayList<String> errors = new ArrayList<String>();
			for (int i = 0; i < valid.getErrorCount(); i++) {
				errors.add(valid.getFieldErrors().get(i).getDefaultMessage());
			}
			throw new ValidatationException(errors.toString());
		}else {
			ResponseData response = new ResponseData(200,
					courseService.updateCourse(item.getId(), item.getName(), item.getDescription()));
			return response;
		}	
		
	}
}
