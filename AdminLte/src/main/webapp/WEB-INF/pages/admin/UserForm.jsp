<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="prevent.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="User">
        <table>
            <form:hidden path="userid"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
             <tr>
                <td>Mobile:</td>
                <td><form:input path="mobile" /></td>
            </tr>
            <tr>
                <td>Courses:</td>
                <td><form:input path="courses" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="state" /></td>
            </tr>
             <tr>
                <td>Gender:</td>
                <td><form:input path="gender" /></td>
            </tr>
             <tr>
                <td>Password:</td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>