<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Post by ID!</title>
</head>
<body>
    <div align="center">
        <form:form action="getPost" method="post" commandName="postGetForm" modelAttribute="postGetForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Get Post by ID:</h2></td>
                </tr>
                <tr>
                    <td>Enter ID of Row to retrieve:</td>
                    <td><form:input  path="postID" placeholder="int" name="postID" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Retrieve row from Post Table" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>