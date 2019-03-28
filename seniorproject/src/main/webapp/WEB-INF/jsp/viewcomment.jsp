<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Comments List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Comment Id</th><th>Post</th><th>User</th><th>Created</th><th>Modified</th><th>Comment</th><th>Flagged</th><th>Update</th><th>Delete</th></tr>  
   <c:forEach var="comment" items="${list}">   
	   <tr>  
	   <td>${comment.id}</td>  
	   <td>${comment.postID}</td>  
	   <td>${comment.userID}</td>  
	   <td>${comment.createdTS}</td> 
	   <td>${comment.modified}</td>  
	   <td>${comment.comment}</td>   
	   <td>${comment.flagged}</td>
	   <td><a href="updateComment/${comment.id}">edit</a></td>
	   <td><a href="deleteComment/${comment.id}">delete</a></td>
	   </tr>  
   </c:forEach>  
</table>  
<a href="addComment">Add Comment</a>