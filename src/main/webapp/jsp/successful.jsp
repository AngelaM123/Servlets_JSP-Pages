<%--
  Created by IntelliJ IDEA.
  User: angjela.milosavljevi
  Date: 11/29/2022
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <script type="text/javascript" src="js/test.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/mybootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron">
    <div class="text-center" class="container">
        <caption>
            <legend><b><h2>Success</h2></b></legend>
        </caption>


        <a class="btn btn-info btn-lg"
           href="${link}"
           role="button">
            Go to Updated List
            <span class="glyphicon glyphicon-send"></span>
        </a>


    </div>
</div>
<%--<button class="btn-close-white" >
    <a href="${link}">Updated List</a>
</button>--%>


<%--<button class="btn-close-white">
    <a href="/FacultyServlet?action=all">List of Faculties</a>

</button>--%>

<%--
<script>
    window.setTimeout(function(){

        window.location.href = "http://localhost:8080/FacultyServlet?action=all";

    }, 5000);

</script>
--%>


</body>
</html>
