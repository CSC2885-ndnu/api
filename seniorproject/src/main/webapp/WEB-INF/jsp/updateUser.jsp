<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User!</title>
</head>
<body>
    <div align="center">
        <form:form action="updateUser" method="post" commandName="userUpdateForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Update a user</h2></td>
                </tr>
                <tr>
                    <td>ID:</td>
                    <td><form:input path="user_id" /></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td>StudentID:</td>
                    <td><form:input path="studentID" placeholder="int"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td>Avatar:</td>
                    <td><form:input path="avatar" /></td>
                </tr>
                <tr>
                    <td>isAdmin (0,1):</td>
                    <td><form:input path="isAdmin" /></td>
                </tr>
                <tr>
                    <td>Flagged (0,1):</td>
                    <td><form:input path="flagged" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Edit User in Database" /></td>
                </tr>
            </table>
        </form:form>
    </div>

</body>
</html>