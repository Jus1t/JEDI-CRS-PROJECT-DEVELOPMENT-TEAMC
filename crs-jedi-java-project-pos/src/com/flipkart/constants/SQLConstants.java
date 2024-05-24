package com.flipkart.constants;

public class SQLConstants {
	public static final String COURSE_DETAILS = "select courseId, courseName, instructorId from Course";
	public static final String COURSE_INSERTION = "insert into Course(courseId, courseName, instructorId, enrolledStudents, isOffered) values (?, ?, ?, ?, ?)";
	public static final String COURSE_DELETION = "delete from Course where courseId = ?";
	public static final String CLOSE_REGISTRATION = "update Course set isOffered=false where courseId = ?";
	public static final String ASSIGN_COURSE = "update Course set instructorId=? where courseId = ?";
	public static final String INSERT_USER = "insert into User(userId, UserName, phone, email, password, role) values (?, ?, ?, ?, ?,?)";
	public static final String INSERT_STUDENT = "insert into Student(studentId,branch,batch,isApproved) values (?, ?, ?, 0)";
	public static final String VERIFY_CREDENTIALS = "select u.* from Student as st RIGHT JOIN User as u on st.studentId=u.userId where u.userId=? AND u.password=? AND (u.role!='student' OR st.isApproved = 1)";
	public static final String INSERT_PROFESSOR = "insert into Professor(profId,designation,department) values (?, ?, ?)";
	public static final String NOTIFICATION_SEND = "insert into Notification(notificationId,userId,content) values (?, ?, ?)";
	public static final String ONLINE_PAYMENT = "insert into Payment(paymentId,studentId,amount, paymentMode) values (?, ?, ?,?)";
	public static final String INSERT_BANK_DETAILS = "insert into BankDetails(paymentId,bankName,bankHolderName,ifsc,accountNo) values (?, ?, ?,?,?)";
	public static final String GRADE_CARD_INSERTION = "insert into GradeCard(studentId, courseId, grade) values (?, ?, ?)";
	public static final String TEACHER_PREFERENCE_INSERTION = "insert into TeacherPreference(profId, courseId) values (?, ?)";
	public static final String REGISTER_COURSE = "select courseId, courseName, instructorId, enrolledStudents, isOffered,courseFee from Course where courseId=?";
	public static final String REGISTERED_COURSE_INSERTION = "INSERT INTO RegisteredCourse(studentId, courseId, regDate, semester,isApproved) values(?,?,?,?,false)";
	public static final String GRADE_CARD_DETAILS = "select * from GradeCard where studentId=?";
	public static final String CHANGE_PASSWORD = "update User SET password=? where userId=? AND password=?";
	public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select u.userId, u.username, u.password, u.phone, u.email, u.role, s.studentId, s.branch, s.batch from Student as s join User as u on s.studentId = u.userId where s.isApproved = 0";
	public static final String VIEW_PROFESSOR_QUERY = "select u.userId, u.username, u.password, u.phone, u.email, u.role, p.profId, p.department, p.designation from Professor as p join User as u on p.profId=u.userId";
	public static final String DROP_COURSE_QUERY = "delete from RegisteredCourse where courseId = ? AND studentId = ?;";
	public static final String VIEW_REGISTERED_COURSES = " select * from Course inner join RegisteredCourse on Course.courseId = RegisteredCourse.courseId where RegisteredCourse.studentId = ?";
	public static final String CALCULATE_FEES = "select sum(courseFee) from Course where courseId in (select courseId from RegisteredCourse where studentId = ?);";
	public static final String GET_SEATS = "select enrolledStudents from Course where courseId = ?;";
	public static final String IS_REGISTERED = " select courseId from RegisteredCourse where courseId=? and studentId=? ";
	public static final String GET_REGISTRATION_STATUS = " select isApproved from Student where studentId = ? ";
	public static final String SET_REGISTRATION_STATUS = "update Student set isApproved = true  where studentId=?";
	public static final String GET_ENROLLED_STUDENTS = "select c.courseId, c.courseName, rc.studentId from Course as c inner join RegisteredCourse as rc on c.courseId = rc.courseId where c.instructorId = ? order by c.courseId";
	public static final String GET_COURSES = "select * from Course where instructorId=?";
	public static final String VIEW_AVAILABLE_COURSES = " select * from Course as c where c.courseId not in (select courseId from RegisteredCourse where studentId = ?) and c.isOffered = ? and c.enrolledStudents < 10";
//	public static final String ADD_COURSE = "insert into courseId, courseName, instructorId, enrolledStudents, isOffered,courseFee from Course where courseId=?";
	public static final String APPROVE_COURSE_QUERY = "update RegisteredCourse set isApproved = 1 where courseId = ? AND studentId=?";
}
