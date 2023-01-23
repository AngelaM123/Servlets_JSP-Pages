<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="model.University" %>

<html>
<head>
    <title>University List</title>
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

        <legend><h2><b>University Structure</b></h2></legend>

        <caption>
            <legend><b><h3 class="title">List of Universities</h3></b></legend>

        </caption>

        <h1>
            <a class="btn btn-primary btn-lg"
               href="http://localhost:8080/UniversityServlet?action=new"
               role="button">
                Add New University
            </a>

            &nbsp;&nbsp;&nbsp;

            <a class="btn btn-primary btn-lg"
               href="http://localhost:8080/UniversityServlet?action=all"
               role="button">
                List All Universities
            </a>
        </h1>

    </div>

    <br>

    <div id="table_div" class="align-center">
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>



            <c:forEach var="university" items="${universityListfromJsp}">
            <tr>
                <td><c:out value="${university.getId()}"/></td>
                <td><c:out value="${university.getName()}"/></td>
                <td><c:out value="${university.getDescription()}"/></td>

                <td>
                    <form>


                        <a class="btn btn-warning"
                           href="http://localhost:8080/UniversityServlet?action=byId&id=<c:out value='${university.getId()}'/>"
                           role="button">
                            Edit
                        </a>


                        <a class="btn btn-danger"
                           href="http://localhost:8080/UniversityServlet?action=delete&id=<c:out value='${university.getId()}'/>"
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
