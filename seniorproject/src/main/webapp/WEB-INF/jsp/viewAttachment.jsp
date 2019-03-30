<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Attachment List</h1>  
<table border="2 width="70%" cellpadding="2">  
<tr><th>AttachmentId</th><th>Post ID</th><th>Link</th><th>Type</th></tr>  
   <c:forEach var="viewAttachment" items="${list}">   
   <tr>  
   <td>${viewAttachment.id}</td>  
   <td>${viewAttachment.postId}</td>  
   <td>${viewAttachment.link}</td>  
   <td>${viewAttachment.type}</td> 
   </tr>  
   </c:forEach>  
   </table>  