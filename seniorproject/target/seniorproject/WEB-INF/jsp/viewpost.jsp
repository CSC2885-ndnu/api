<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Post List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Post Id</th><th>Title</th><th>Course</th><th>Class Date</th><th>Post Date</th><th>Note</th><th>User</th><th>Flagged</th></tr>  
   <c:forEach var="post" items="${list}">   
	   <tr>  
	   <td>${post.id}</td>  
	   <td>${post.title}</td>  
	   <td>${post.courseID}</td>  
	   <td>${post.classDate}</td> 
	   <td>${post.postDate}</td>  
	   <td>${post.note}</td>  
	   <td>${post.userID}</td>  
	   <td>${post.flagged}</td>
	   </tr>  
   </c:forEach>  
</table>  