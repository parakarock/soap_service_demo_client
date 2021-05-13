package com.spring.nemo.soap_service_demo_client.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.spring.nemo.soap_service_demo_client.courses.DeleteCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.DeleteCourseDetailsResponse;
import com.spring.nemo.soap_service_demo_client.courses.GetAllCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.GetAllCourseDetailsResponse;
import com.spring.nemo.soap_service_demo_client.courses.GetCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.GetCourseDetailsResponse;
import com.spring.nemo.soap_service_demo_client.courses.InsertCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.InsertCourseDetailsResponse;
import com.spring.nemo.soap_service_demo_client.courses.UpdateCourseDetailsRequest;
import com.spring.nemo.soap_service_demo_client.courses.UpdateCourseDetailsResponse;

public class SoapClient extends WebServiceGatewaySupport {

	public GetAllCourseDetailsResponse getAllCourse(GetAllCourseDetailsRequest request) {
		return (GetAllCourseDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}

	public GetCourseDetailsResponse getCourseDetailById(GetCourseDetailsRequest request) {
		return (GetCourseDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	
	public DeleteCourseDetailsResponse deleteCourseDetailById(DeleteCourseDetailsRequest request) {
		return (DeleteCourseDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	
	public InsertCourseDetailsResponse insertCourse(InsertCourseDetailsRequest request) {
		return (InsertCourseDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
	
	public UpdateCourseDetailsResponse updateCourse(UpdateCourseDetailsRequest request) {
		return (UpdateCourseDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
	}
}
