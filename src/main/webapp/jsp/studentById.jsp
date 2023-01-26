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
    <title>Student Field</title>
    <script type="text/javascript" src="js/test.js"></script>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/mybootstrap.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">

    <form class="well form-horizontal" action="/StudentServlet" method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <h2><b>STUDENT UPDATE</b></h2>
            </legend>

            <div class="form-group">
                <input type="text" name="action" value="update" style="display: none"/>
            </div>

            <div class="form-group">
                <input type="text" name="id" value="${subject.id}" style="display: none"/>
            </div>
            <br>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Student Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <input name="name" placeholder="Enter Student Name"
                               class="form-control" type="text" value="${student.name}">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="surname">Student Surname</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <input name="surname" placeholder="Enter Student Surname"
                               class="form-control" type="text" value="${student.surname}">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="location">Student Location</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <input name="location" placeholder="Enter Student Location"
                               class="form-control" type="text" value="${student.location}">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="indeks">Indeks</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <input name="indeks" placeholder="Enter Indeks"
                               class="form-control" type="text" value="${subject.indeks}">
                    </div>
                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4"><br>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button type="submit" class="btn btn-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspUPDATE <span
                            class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    </button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</div>

</body>
</html>
