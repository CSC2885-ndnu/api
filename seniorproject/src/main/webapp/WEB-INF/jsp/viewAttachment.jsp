<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Attachment List</h1>  
<table border="2 width="70%" cellpadding="2">  
<tr><th>AttachmentId</th><th>Post ID</th><th>Link</th><th>Type</th></tr>  
   <c:forEach var="attachment" items="${list}">   
   <tr>  
   <td>${attachment.id}</td>  
   <td>${attachment.postId}</td>  
   <td>${attachment.link}</td>  
   <td>${attachment.type}</td> 
   </tr>  
   </c:forEach>  
   </table>  