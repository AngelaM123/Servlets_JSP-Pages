
<%--zabeleshka so import preku alt+enter na C:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: angjela.milosavljevi
  Date: 11/29/2022
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%@ page import="model.Faculty" %>

<html>
<head>
    <title>Faculty Field</title>
</head>
<body>

    <h1>Faculty Structure</h1>
    <h2>
        <a href="/new">Add New Faculty</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Faculties</a>

    </h2>

<div >
    <table>
        <caption><h2>List of Faculties</h2></caption>
<%--        naslovni kjelii--%>
        <tr>
            <th>id</th>
            <th>Location</th>
            <th>Name</th>
            <th>Study_field</th>
            <th>Actions</th>
        </tr>

<%--        rabotni kjelii--%>

        <c:forEach var="faculty" items="${facultyListfromJsp}">
            <tr>
                <td><c:out value="${faculty.getId()}" /></td>
                <td><c:out value="${faculty.getName()}" /></td>
                <td><c:out value="${faculty.getLocation()}" /></td>
<%--                <td><c:out value="${faculty.getStudy_field()}" /></td>--%>
                <td>
                    <a href="/FacultyServlet?action=byId&id=<c:out value='${faculty.getId()}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/FacultyServlet?action=delete&id=<c:out value='${faculty.getId()}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
