<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Course List</h1>  
<table border="2" width="70%" cellpadding="2">  
	<tr>
		<th>Course Id</th>
		<th>Course Code</th>
		<th>Department</th>
		<th>Name</th>
		<th>Description</th>
		<th>Section</th>
		<th>Syllabus</th>
		<th>Semester</th>
		<th>Meeting Day</th>
		<th>Year</th>
		<th>Professor</th>
		<th>Link</th>
	</tr>  
	
   <c:forEach var="course" items="${list}">   
	   <tr>  
	   <td>${course.course_id}</td>  
	   <td>${course.courseCode}</td>  
	   <td>${course.department}</td>  
	   <td>${course.courseName}</td> 
	   <td>${course.courseDescription}</td>  
	   <td>${course.section}</td>  
	   <td>${course.courseSyllabus}</td>  
	   <td>${course.semester}</td>
	   <td>${course.meetingDay}</td>
	   <td>${course.year}</td>
	   <td>${course.professor}</td>
	   <td>${course.link}</td>
	   </tr>  
   </c:forEach> 
   <a href="home">Home</a>  
</table>  