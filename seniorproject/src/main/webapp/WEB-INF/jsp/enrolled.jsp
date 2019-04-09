<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Enrolled List</h1>  
<table border="2" width="70%" cellpadding="2">  
	<tr>
		<th>Course ID</th>
		<th>User ID</th>
	</tr>  
	
   <c:forEach var="enrolled" items="${list}">   
	   <tr>  
	   <td>${enrolled.courseID}</td>  
	   <td>${enrolled.userID}</td> 
	   </tr>  
   </c:forEach> 
   <a href="home">Home</a>  
</table>