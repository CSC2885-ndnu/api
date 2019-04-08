<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>View Comment Flag by ID</h1>  
<table border="2" width="70%" cellpadding="2">  
	<tr>
		<th>Id</th>
		<th>Comment Id</th>
		<th>Flagger</th>
		<th>Notes</th>
		<th>Date</th>
		<th>Active</th>
	</tr>  
	
   <c:forEach var="items" items="${list}">   
	   <tr>  
	   <td>${items.id}</td>  
	   <td>${items.comment_id}</td>  
	   <td>${items.flagger}</td>  
	   <td>${items.date}</td>  
	   <td>${items.active}</td> 
	   <td>${items.notes}</td>
	   </tr>  
   </c:forEach> 
   <a href="home">Home</a>  
</table>  