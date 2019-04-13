<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Post Flag!</title>
</head>
<body>
    <div align="center">
        <form:form action="addPostFlag" method="post" commandName="postFlagForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Add Post Flag</h2></td>
                </tr>
                <tr>
                    <td>Post Id:</td>
                    <td><form:input path="post_id" /></td>
                </tr>
                <tr>
                    <td>Flagger</td>
                    <td><form:input path="flagger" /></td>
                </tr>
                <tr>
                    <td>Notes:</td>
                    <td><form:input path="notes" /></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><form:input path="date" placeholder="yyyy-mm-dd 00:00:00"/></td>
                </tr>
                <tr>
                    <td>Active?:</td>
                    <td><form:input path="active" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add to PostFlag Table" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
