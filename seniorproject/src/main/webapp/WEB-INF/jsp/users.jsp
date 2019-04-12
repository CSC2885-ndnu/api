<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Users List</h1>  
<table border="2" width="70%" cellpadding="2">  
	<tr>
		<th>Id</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>StudentID</th>
		<th>Email</th>
		<th>Password</th>
		<th>Avatar</th>
		<th>isAdmin</th>
		<th>flagged</th>
		<th>createdTS</th>
	</tr>  
	
   <c:forEach var="user" items="${list}">   
	   <tr>  
	    <td>${user.user_id}</td>  
  	    <td>${user.firstName}</td>  
        <td>${user.lastName}</td>  
        <td>${user.studentID}</td> 
        <td>${user.email}</td>  
        <td>${user.password}</td>  
        <td>${user.avatar}</td>  
        <td>${user.isAdmin}</td>
        <td>${user.flagged}</td>  
        <td>${user.createdTS}</td>
	   </tr>  
   </c:forEach> 
   <a href="home">Home</a>  
</table>  