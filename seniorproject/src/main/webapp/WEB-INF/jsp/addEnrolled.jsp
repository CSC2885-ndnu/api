<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add enrolled!</title>
</head>
<body>
    <div align="center">
        <form:form action="addEnrolled" method="post" commandName="enrolledForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Add Enrolled</h2></td>
                </tr>
                <tr>
                    <td>Course ID:</td>
                    <td><form:input path="courseID" /></td>
                </tr>
                <tr>
                    <td>User ID:</td>
                    <td><form:input path="userID" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add to Enrolled Table" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>