<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>View Course by ID</h1>  
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
		<th>Year</th>
		<th>Professor</th>
		<th>Link</th>
	</tr>  
	
   <c:forEach var="items" items="${list}">   
	   <tr>  
	   <td>${items.course_id}</td>  
	   <td>${items.courseCode}</td>  
	   <td>${items.department}</td>  
	   <td>${items.courseName}</td> 
	   <td>${items.courseDescription}</td>  
	   <td>${items.section}</td>  
	   <td>${items.courseSyllabus}</td>  
	   <td>${items.semester}</td>
	   <td>${items.year}</td>
	   <td>${items.professor}</td>
	   <td>${items.link}</td>
	   </tr>  
   </c:forEach> 
   <a href="home">Home</a>  
</table>  