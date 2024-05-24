package com.flipkart.constants;

public class SQLConstants {
	public static final String COURSE_DETAILS = "select courseId, courseName, instructorId from Course";
	public static final String COURSE_INSERTION = "insert into Course(courseId, courseName, instructorId, enrolledStudents, isOffered) values (?, ?, ?, ?, ?)";
	public static final String COURSE_DELETION = "delete from Course where courseId = ?";
	public static final String CLOSE_REGISTRATION = "update Course set isOffered=false where courseId = ?";
	public static final String ASSIGN_COURSE = "update Course set instructorId=? where courseId = ?";
	public static final String INSERT_USER = "insert into User(userId, UserName, phone, email, password, role) values (?, ?, ?, ?, ?,?)";
	public static final String INSERT_STUDENT = "insert into Student(studentId,branch,batch) values (?, ?, ?)";
	public static final String VERIFY_CREDENTIALS = "select * from User where userId=? AND password=?";
	public static final String INSERT_PROFESSOR = "insert into Professor(profId,designation,department) values (?, ?, ?)";
	public static final String NOTIFICATION_SEND = "insert into Notification(notificationId,userId,content) values (?, ?, ?)";
	public static final String ONLINE_PAYMENT = "insert into Payment(paymentId,studentId,amount, paymentMode) values (?, ?, ?,?)";
	public static final String INSERT_BANK_DETAILS = "insert into BankDetails(paymentId,bankName,bankHolderName,ifsc,accountNo) values (?, ?, ?,?,?)";
	public static final String GRADE_CARD_INSERTION = "insert into GradeCard(studentId, courseId, grade) values (?, ?, ?)";
	public static final String TEACHER_PREFERENCE_INSERTION = "insert into TeacherPreference(profId, courseId) values (?, ?)";
	public static final String REGISTER_COURSE = "select courseId, courseName, instructorId, enrolledStudents, isOffered from Course where courseId=?";
	public static final String REGISTERED_COURSE_INSERTION = "INSERT INTO RegisteredCourse(studentId, courseId, regDate, semester) values(?,?,?,?)";
	public static final String GRADE_CARD_DETAILS = "select * from GradeCard where studentId=?";
	public static final String CHANGE_PASSWORD = "update User SET password=? where userId=? AND password=?";
	public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId, username, password, phone, email, role, studentId, branch, batch from Student natural join User where isApproved = 0";
	public static final String VIEW_PROFESSOR_QUERY = "select userId, username, password, phone, email, role, profId, department, designation from Professor natural join User";
	public static final String DROP_COURSE_QUERY = "delete from RegisteredCourse where courseId = ? AND studentId = ?;";
	public static final String VIEW_REGISTERED_COURSES=" select * from Course inner join RegisteredCourse on Course.courseId = RegisteredCourse.courseId where RegisteredCourse.studentId = ?";
	public static final String CALCULATE_FEES  = "select sum(courseFee) from Course where courseId in (select courseId from RegisteredCourse where studentId = ?);";
	public static final String GET_SEATS = "select enrolledStudents from Course where courseId = ?;";
	public static final String IS_REGISTERED=" select courseId from RegisteredCourse where courseId=? and studentId=? ";
	public static final String GET_REGISTRATION_STATUS=" select isApproved from Student where studentId = ? ";
	public static final String SET_REGISTRATION_STATUS="update Student set isApproved = true  where studentId=?";
	public static final String GET_ENROLLED_STUDENTS="select c.courseId, c.courseName, rc.studentId from Course as c inner join RegisteredCourse as rc on c.courseId = rc.courseId where c.instructorId = ? order by c.courseId";
	public static final String GET_COURSES="select * from Course where instructorId=?";
}
