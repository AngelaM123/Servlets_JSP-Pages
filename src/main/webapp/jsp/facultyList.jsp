<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Faculty" %>

<html>
<head>
    <title>Faculty List</title>
    <script type="text/javascript" src="js/test.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/mybootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>

        table, th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        table {
            border-collapse: collapse;
            width: 50%;
            mso-cellspacing: 5cm;
        }

        td {
            height: 50px;
            vertical-align: bottom;
        }


        tr:hover {
            background-color: steelblue;
        }

        input[type=button], input[type=submit], input[type=reset] {
            background-color: #084298;
            border: none;
            color: white;
            padding: 16px 32px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
        }

        .header {
            background-color: #f1f1f1;
            padding: 20px;
            text-align: center;
        }

        .title {
            color: darkred;
        }

        h2 {
            color: darkred;
        }
    </style>
</head>

<body>

<div class="jumbotron">

    <div id="greeting_div" class="text-center" class="container">

        <legend><h2><b>Faculty Structure</b></h2></legend>

        <caption>
            <legend><b><h3 class="title">List of Faculties</h3></b></legend>

        </caption>

        <h1>
            <a class="btn btn-primary btn-lg"
               href="http://localhost:8080/FacultyServlet?action=new"
               role="button">
                Add New Faculty
            </a>

            <a class="btn btn-primary btn-lg"
               href="http://localhost:8080/FacultyServlet?action=all"
               role="button">
                List All Faculties
            </a>
        </h1>

    </div>

    <br>

    <div id="table_div" class="align-center">
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>id</th>
                <th>Location</th>
                <th>Name</th>
                <th>Study Field</th>
                <th>Actions</th>
            </tr>
            </thead>
            <c:forEach var="faculty" items="${facultyListfromJsp}">
                <tr>
                    <td><c:out value="${faculty.getId()}"/></td>
                    <td><c:out value="${faculty.getLocation()}"/></td>
                    <td><c:out value="${faculty.getName()}"/></td>
                    <td><c:out value="${faculty.getStudy_field()}"/></td>

                    <td>
                        <form>


                            <a class="btn btn-warning"
                               href="http://localhost:8080/FacultyServlet?action=byId&id=<c:out value='${faculty.getId()}'/>"
                               role="button">
                                Edit
                            </a>


                            <a class="btn btn-danger"
                               href="http://localhost:8080/FacultyServlet?action=delete&id=<c:out value='${faculty.getId()}'/>"
                               role="button">Delete</a>


                        </form>
                    </td>


                </tr>
            </c:forEach>
        </table>


        <script>


            $(document).ready(function () {
                $(".btn-warning").click(function () {
                    $(this).button('toggle');
                });
            });
        </script>
    </div>
</div>
</body>
</html>
