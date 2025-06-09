<%-- 
    Document   : search
    Created on : May 30, 2025, 10:14:52 PM
    Author     : p14s
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Search Employees</title>
</head>
<body>
    <h1>Search Employees</h1>
    <form action="search" method="post">
        <label for="ename">Name:</label>
        <input type="text" id="ename" name="ename" value="${ename}"><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="all" ${gender == 'all' || gender == null ? 'selected' : ''}>All</option>
            <option value="true" ${gender == 'true' ? 'selected' : ''}>Male</option>
            <option value="false" ${gender == 'false' ? 'selected' : ''}>Female</option>
        </select><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${address}"><br><br>

        <label for="did">Department:</label>
        <select id="did" name="did">
            <option value="">-- Chose a Department --</option>
            <c:forEach var="department" items="${departments}">
                <option value="${department.did}" ${did == department.did ? 'selected' : ''}>
                    ${department.dname}
                </option>
            </c:forEach>
        </select><br><br>

        <input type="submit" value="Search">
    </form>

    <h2>Results</h2>
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
