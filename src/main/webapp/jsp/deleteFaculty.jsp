<%--
  Created by IntelliJ IDEA.
  User: angjela.milosavljevi
  Date: 11/29/2022
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Faculty Field</title>
</head>
<body>
<form method="GET" action="/FacultyServlet">
    <input type="text" name="action" value="update" style="display: none"/>
    <input type="text" name="id" value="${faculty.id}" style="display: none"/>
    <input type="text" name="name" value="${faculty.name}"/>
    <input type="text" name="location" value="${faculty.location}"/>
    <input type="text" name="study_field" value="${faculty.study_field}"/>
    <input type="submit" value="Delete"/>
</form>


</body>
</html>
