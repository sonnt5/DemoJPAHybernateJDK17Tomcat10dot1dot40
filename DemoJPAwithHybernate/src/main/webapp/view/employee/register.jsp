<%-- 
    Document   : register
    Created on : May 30, 2025, 11:11:30 PM
    Author     : p14s
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register Employee</title>
</head>
<body>
    <h1> New Employee with Skills </h1>
    <form action="register" method="post">
        <label for="ename">Name:</label>
        <input type="text" id="ename" name="ename" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="true">Male</option>
            <option value="false">Female</option>
        </select><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address"><br><br>

        <label for="did">Department:</label>
        <select id="did" name="did">
            <c:forEach var="department" items="${departments}">
                <option value="${department.did}">${department.dname}</option>
            </c:forEach>
        </select><br><br>

        <label>Skills:</label><br>
        <c:forEach var="skill" items="${skills}">
            <input type="checkbox" name="skills" value="${skill.skid}">
            ${skill.skname}<br>
        </c:forEach><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
