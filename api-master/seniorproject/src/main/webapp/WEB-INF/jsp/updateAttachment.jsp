<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Attachment!</title>
</head>
<body>
    <div align="center">
        <form:form action="updateAttachment" method="post" commandName="attachmentUpdateForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Update Attachment</h2></td>
                </tr>
                <tr>
                    <td>Id:</td>
                    <td><form:input  path="id" placeholder="int" /></td>
                </tr>
                <tr>
                    <td>Post Id:</td>
                    <td><form:input path="postId" placeholder="int" /></td>
                </tr>
                <tr>
                    <td>Link</td>
                    <td><form:input path="link" /></td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td><form:input path="type" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Update Attachment in Database" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>