package com.spring.nemo.soap_service_demo_client.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.nemo.soap_service_demo_client.client.SoapClient;
import com.spring.nemo.soap_service_demo_client.courses.CourseDetails;
import com.spring.nemo.soap_service_demo_client.courses.DeleteCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.GetAllCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.GetCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.InsertCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.InsertCourseDetailsResponse;
import com.spring.nemo.soap_service_demo_client.courses.Status;
import com.spring.nemo.soap_service_demo_client.courses.UpdateCourseDetailsRequest;

@Repository
public class CourseImpl implements CourseDAO {

	@Autowired
	SoapClient soapClient;
	
	@Override
	public List<CourseDetails> getAllCourse() {
		GetAllCourseDetailsRequest request = new GetAllCourseDetailsRequest();
		List<CourseDetails> response = soapClient.getAllCourse(request).getCourseDetails();
		return response;
	}

	@Override
	public CourseDetails getCourseById(int id) {
		GetCourseDetailsRequest request = new GetCourseDetailsRequest();
		request.setId(id);
		CourseDetails response = soapClient.getCourseDetailById(request).getCourseDetails();
		return response;
	}

	@Override
	public Status deleteCourseById(int id) {
		DeleteCourseDetailsRequest request = new DeleteCourseDetailsRequest();
		request.setId(id);
		Status response = soapClient.deleteCourseDetailById(request).getStatus();
		return response;
	}

	@Override
	public CourseDetails addNewCourse(String name, String description) {
		InsertCourseDetailsRequest request = new InsertCourseDetailsRequest();
		request.setName(name);
		request.setDescription(description);
		InsertCourseDetailsResponse result = soapClient.insertCourse(request);
		CourseDetails response = new CourseDetails();
		response.setId(result.getId());
		response.setName(result.getName());
		response.setDescription(result.getDescription());
		return response;
	}

	@Override
	public Status updateCourse(Integer id, String name, String description) {
		UpdateCourseDetailsRequest request = new UpdateCourseDetailsRequest();
		request.setId(id);
		request.setName(name);
		request.setDescription(description);
		Status response = soapClient.updateCourse(request).getStatus();
		return response;
	}

}
