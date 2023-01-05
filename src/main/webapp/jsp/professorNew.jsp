<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="model.University" %>

<html>
<head>
    <title>Professor Create</title>
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
            <form class="well form-horizontal" action="/ProfessorServlet" method="post" id="contact_form">
                <fieldset>

                    <!-- Form Name -->
                    <legend>
                        <center><h2><b>ADD NEW PROFESSOR</b></h2></center>
                    </legend>
                    <br>

                    <div class="form-group">
                        <input type="text" name="action" value="save" style="display: none"/>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="name">Professor Name</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="name" placeholder="Enter Professor Name"
                                       class="form-control" type="text" value="${professor.name}">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="surname">Professor Surname</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="surname" placeholder="Enter Professor Surname"
                                       class="form-control" type="text" value="${professor.surname}">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="age">Professor Age</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="age" placeholder="Enter Professor Age"
                                       class="form-control" type="text" value="${professor.age}">
                            </div>
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="primary_subject1">Primary Subject1</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="primary_subject1" placeholder="Enter Professor Primary Subject1"
                                       class="form-control" type="text" value="${professor.primary_subject1}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="primary_subject2">Primary Subject2</label>
                            <div class="col-md-4 inputGroupContainer">
                                <div class="input-group">
                                    <input name="primary_subject2" placeholder="Enter Professor Primary Subject2"
                                           class="form-control" type="text" value="${professor.primary_subject2}">
                                </div>
                            </div>


                        </div>


                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label"></label>
                            <div class="col-md-4"><br>

                                <button type="submit" value="Save" class="btn btn-warning">
                                    SAVE PROFESSOR
                                    <span class="glyphicon glyphicon-send"></span>
                                </button>
                            </div>
                        </div>

                </fieldset>
            </form>
        </div>
    </center>
</div><!-- /.container -->

<!-- 
    <script>
        debugger;

       // document.write("You will be redirected to facultyList page in 60 seconds");
        setTimeout(  function redirect()
        {
            window.location.href = "http://localhost:8080/FacultyServlet?action=all";
        }, 60000);
    </script>
-->

</body>
</html>
