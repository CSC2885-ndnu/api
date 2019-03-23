<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Comments List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Comment Id</th><th>Post</th><th>User</th><th>Created</th><th>Modified</th><th>Comment</th><th>Flagged</th></tr>  
   <c:forEach var="comment" items="${list}">   
	   <tr>  
	   <td>${comment.id}</td>  
	   <td>${comment.post.title}</td>  
	   <td></td>  
	   <td>${comment.createdTS}</td> 
	   <td>${comment.modified}</td>  
	   <td>${comment.comment}</td>   
	   <td>${comment.flagged}</td>
	   </tr>  
   </c:forEach>  
</table>  