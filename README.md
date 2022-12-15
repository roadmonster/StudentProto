# Student Grade-Book backend Service

REST API support CRUD for Student and their grades for Math, Science and history.

# Tech Stack
	SpringBoot
	SpringData JPA

# Resource Endpoints:
	GetAllStudentDetails: GET "/"
	CreateStudent: POST "/"
	GetStudentByID: GET "/studentInformation/{id}"
	DeleteStudentByID: DELETE "/student/{id}"
	CreateGradesForStudent: POST "/grades/?grade={grade}&gradeType={gradeType}&studentId={studentId}"
	
