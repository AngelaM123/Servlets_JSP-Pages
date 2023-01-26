<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<html>
<head>
    <title>Student Create</title>
    <script type="text/javascript" src="js/test.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/mybootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">

    <center>
        <div class="container-center">
            <form class="well form-horizontal" action="/StudentServlet" method="post" id="contact_form">
                <fieldset>

                    <!-- Form Name -->
                    <legend>
                        <center><h2><b>ADD NEW STUDENT</b></h2></center>
                    </legend>
                    <br>

                    <div class="form-group">
                        <input type="text" name="action" value="save" style="display: none"/>
                    </div>

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

                            <button type="submit" value="Save" class="btn btn-warning">
                                SAVE STUDENT
                                <span class="glyphicon glyphicon-send"></span>
                            </button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
    </center>
</div>

</body>
</html>
