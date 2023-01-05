
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Subject" %>

<html>
<head>
    <title>Subject List</title>
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

        /*  td {
              text-align: center;
          }*/

        td {
            height: 50px;
            vertical-align: bottom;
        }
        /* tr:nth-child(even){background-color: #157347}*/
        tr:hover {background-color: steelblue;}

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
        .title {color: darkred;}
        h2 {color: darkred;}
    </style>
</head>

<body>

<div class="jumbotron">

    <div id="greeting_div" class="text-center" class="container">

        <legend><h2><b>Subject Structure</b></h2></legend>

        <caption>
            <legend><b><h3 class="title">List of Subjects</h3></b></legend>

        </caption>
        <!--
            <h1 >
                <form>
                    <button class="btn btn-success btn-lg" type="submit"
                    formaction="http://localhost:8080/FacultyServlet?action=new"
                    >
                    Add New Faculty
                    </button>

                    &nbsp;&nbsp;&nbsp;

                    <button class="btn btn-success btn-lg" type="submit"
                    formaction="http://localhost:8080/FacultyServlet?action=all"
                    >
                    List All Faculties
                    </button>
                </form>
            </h1>
         -->
        <h1>
            <a class="btn btn-primary btn-lg"
               href="http://localhost:8080/SubjectServlet?action=new"
               role="button">
                Add New Subject
            </a>

            &nbsp;&nbsp;&nbsp;

            <a class="btn btn-primary btn-lg"
               href="http://localhost:8080/SubjectServlet?action=all"
               role="button">
                List All Subjects
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
                <th>Semester</th>
                <th>Credits</th>
                <th>Actions</th>
            </tr>

            <%--        rabotni kjelii--%>

            <c:forEach var="subject" items="${subjectListfromJsp}">
            <tr>
                <td><c:out value="${subject.getId()}" /></td>
                <td><c:out value="${subject.getName()}" /></td>
                <td><c:out value="${subject.getSemester()}" /></td>
                <td><c:out value="${subject.getCredits()}" /></td>

                <td>
                    <form>


                        <a class="btn btn-warning"
                           href="http://localhost:8080/SubjectServlet?action=byId&id=<c:out value='${subject.getId()}'/>"
                           role="button">
                            Edit
                        </a>

                            <%--                <button class="btn-warning">
                                                    <a href="http://localhost:8080/FacultyServlet?action=byId&id=<c:out value='${faculty.getId()}'/>">Edit</a>
                                                </button>--%>
                            <%--formaction="/FacultyServlet?action=delete&id=<c:out value='${faculty.getId()}' />"--%>

                            <%--            <button class="btn-danger" >
                                                <a href="http://localhost:8080/FacultyServlet?action=delete&id=<c:out value='${faculty.getId()}'/>">Delete</a>
                                            </button>--%>

                        <a class="btn btn-danger"
                           href="http://localhost:8080/SubjectServlet?action=delete&id=<c:out value='${subject.getId()}'/>"
                           role="button">Delete</a>
                    </form>
                </td>


            </tr>
            </c:forEach>
        </table>


        <script>



            $(document).ready(function(){
                $(".btn-warning").click(function(){
                    $(this).button('toggle');
                });
            });
        </script>
    </div>
</div>
</body>
</html>
