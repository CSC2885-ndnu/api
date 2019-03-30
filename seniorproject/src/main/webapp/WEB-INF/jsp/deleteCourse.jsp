<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete row from course!</title>
</head>
<body>
    <div align="center">
        <form:form action="deleteCourse" method="post" commandName="courseDeleteForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Delete Course</h2></td>
                </tr>
                <tr>
                    <td>Enter ID of Row to delete:</td>
                    <td><form:input  path="course_id" placeholder="int" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Delete id from Course Table" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>