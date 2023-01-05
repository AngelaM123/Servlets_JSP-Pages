
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
  <a href="/new">Add New University</a>
  &nbsp;&nbsp;&nbsp;
  <a href="/list">List All Universities</a>

</h2>

<div >
  <table>
    <caption><h2>List of Universities</h2></caption>
    <%--        naslovni kjelii--%>
    <tr>
      <th>id</th>
      <th>Description</th>
      <th>Name</th>
      <th>Actions</th>
    </tr>

    <%--        rabotni kjelii--%>

    <c:forEach var="university" items="${universityListfromJsp}">
      <tr>
        <td><c:out value="${university.getId()}" /></td>
        <td><c:out value="${university.getName()}" /></td>
        <td><c:out value="${university.getDescription()}" /></td>

        <td>
          <a href="/edit?id=<c:out value='${university.getId()}' />">Edit</a>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <a href="/delete?id=<c:out value='${university.getId()}' />">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
