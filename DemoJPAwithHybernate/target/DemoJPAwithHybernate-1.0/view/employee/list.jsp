<%-- 
    Document   : list
    Created on : May 30, 2025, 11:57:22 AM
    Author     : p14s
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employees List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Address</th>
            <th>Department</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.eid}</td>
                <td>${employee.ename}</td>
                <td>${employee.gender ? 'Male' : 'Female'}</td>
                <td>${employee.address}</td>
                <td>${employee.department.dname}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
