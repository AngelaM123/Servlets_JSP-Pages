
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Professor" %>

<html>
<head>
    <title>Professor List</title>
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

<legend><h2><b>Professor Structure</b></h2></legend>

        <caption> 
			<legend><b><h3 class="title">List of Professors</h3></b></legend>
		
		</caption>

	<h1>
		<a class="btn btn-primary btn-lg" 
			href="http://localhost:8080/ProfessorServlet?action=new"
			role="button">
			Add New Professor
		</a>

			&nbsp;&nbsp;&nbsp;
			
		<a class="btn btn-primary btn-lg" 
			href="http://localhost:8080/ProfessorServlet?action=all"
			role="button">
			List All Professor
		</a>
    </h1>
	
</div>

	<br>

<div id="table_div" class="align-center">
    <table class="table table-striped table-bordered">
		<thead class="thead-dark">
        <tr>
            <th>id</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Age</th>
            <th>primary_subject1</th>
            <th>primary_subject2</th>
            <th>Actions</th>
        </tr>



        <c:forEach var="professor" items="${professorListfromJsp}">
        <tr>
            <td><c:out value="${professor.getId()}" /></td>
            <td><c:out value="${professor.getName()}" /></td>
            <td><c:out value="${professor.getSurname()}" /></td>
            <td><c:out value="${professor.getAge()}" /></td>
            <td><c:out value="${professor.getPrimary_subject1()}" /></td>
            <td><c:out value="${professor.getPrimary_subject2()}" /></td>


            <td>
					<form>


                        <a class="btn btn-warning"
                           href="http://localhost:8080/ProfessorServlet?action=byId&id=<c:out value='${professor.getId()}'/>"
                           role="button">
                            Edit
                        </a>

                    <a class="btn btn-danger"
                       href="http://localhost:8080/ProfessorServlet?action=delete&id=<c:out value='${professor.getId()}'/>"
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
