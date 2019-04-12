<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get CommentFlag by ID!</title>
</head>
<body>
    <div align="center">
        <form:form action="getCommentFlag" method="post" commandName="commentFlagGetForm" modelAttribute="commentFlagGetForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Get CommentFlag by ID:</h2></td>
                </tr>
                <tr>
                    <td>Enter ID of Row to retrieve:</td>
                    <td><form:input  path="course_id" placeholder="int" name="course_id" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Retrieve row from CommentFlag Table" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>