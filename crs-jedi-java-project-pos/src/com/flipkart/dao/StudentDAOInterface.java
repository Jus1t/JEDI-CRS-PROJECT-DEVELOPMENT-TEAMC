package com.flipkart.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.GradeCard;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.GradeNotAllotedException;

public interface StudentDAOInterface {
	public CourseCatalogue viewCatalogue();
	public boolean registerCourse(int studentId, int courseId, String semester)  throws SQLException, CourseLimitExceededException;
	public HashMap<Integer,String> viewResult(int id) throws GradeNotAllotedException;
}
