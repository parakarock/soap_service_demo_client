package com.spring.nemo.soap_service_demo_client.DAO;

import java.util.List;

import com.spring.nemo.soap_service_demo_client.courses.CourseDetails;
import com.spring.nemo.soap_service_demo_client.courses.Status;

public interface CourseDAO {
	List<CourseDetails> getAllCourse();
	CourseDetails getCourseById(int id);
	Status deleteCourseById(int id);
	CourseDetails addNewCourse(String name,String description);
	Status updateCourse(Integer id,String name,String description);
}
