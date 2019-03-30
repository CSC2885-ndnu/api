<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Post</h1>  
       <form:form method="POST" action="../editSave">  
       <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Title: </td>   
          <td><form:input path="title"  /></td>  
         </tr>    
         <tr>    
          <td>Course ID:</td>    
          <td><form:input path="courseID" /></td>  
         </tr>
         <tr>    
          <td>Note:</td>    
          <td><form:input path="note" /></td>  
         </tr>
         <tr>    
          <td>User ID:</td>    
          <td><form:input path="userID" /></td>  
         </tr>
         <tr>    
          <td>Flagged:</td>    
          <td><form:input path="flagged" /></td>  
         </tr>
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save Edit" /></td>    
         </tr>    
        </table>    
       </form:form>