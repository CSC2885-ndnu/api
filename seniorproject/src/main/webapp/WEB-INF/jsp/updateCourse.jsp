<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update course!</title>
</head>
<body>
    <div align="center">
        <form:form action="updateCourse" method="post" commandName="courseUpdateForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Update Course</h2></td>
                </tr>
                <tr>
                    <td>ID:</td>
                    <td><form:input  path="course_id" placeholder="int" /></td>
                </tr>
                <tr>
                    <td>Course Code:</td>
                    <td><form:input path="courseCode" /></td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td><form:input path="department" /></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="courseName" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input path="courseDescription" /></td>
                </tr>
                <tr>
                    <td>Section:</td>
                    <td><form:input path="section" /></td>
                </tr>
                <tr>
                    <td>Syllabus:</td>
                    <td><form:input path="courseSyllabus" /></td>
                </tr>
                <tr>
                    <td>Semester:</td>
                    <td><form:input path="semester" /></td>
                </tr>
                <tr>
                    <td>Meeting Day:</td>
                    <td><form:input path="meetingDay" /></td>
                </tr>
                <tr>
                    <td>Year:</td>
                    <td><form:input path="year" /></td>
                </tr>
                <tr>
                    <td>Professor:</td>
                    <td><form:input path="professor" /></td>
                </tr>
                <tr>
                    <td>Link:</td>
                    <td><form:input path="link" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Update Course in Database" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>