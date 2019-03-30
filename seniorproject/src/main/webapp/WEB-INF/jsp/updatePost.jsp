<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update post!</title>
</head>
<body>
    <div align="center">
        <form:form action="updatePost" method="post" commandName="postUpdateForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Update Post</h2></td>
                </tr>
                <tr>
                    <td>ID:</td>
                    <td><form:input  path="id" placeholder="int" /></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><form:input path="title" /></td>
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
                    <td colspan="2" align="center"><input type="submit" value="Update Post in Database" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>