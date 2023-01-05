<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Faculty" %>

<html>
<head>
    <title>Faculty Create</title>
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
            <form class="well form-horizontal" action="/FacultyServlet" method="post" id="contact_form">
                <fieldset>

                    <!-- Form Name -->
                    <legend>
                        <center><h2><b>ADD NEW FACULTY</b></h2></center>
                    </legend>
                    <br>

                    <div class="form-group">
                        <input type="text" name="action" value="save" style="display: none"/>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="name">Faculty Name</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="name" placeholder="Enter Faculty Name"
                                       class="form-control" type="text" value="${faculty.name}">
                            </div>
                        </div>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="location">Faculty Location</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="location" placeholder="Enter Faculty Location"
                                       class="form-control" type="text" value="${faculty.location}">
                            </div>
                        </div>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="study_field">Study Field</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="study_field" placeholder="Enter Study Field of Faculty"
                                       class="form-control" type="text" value="${faculty.study_field}">
                            </div>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4"><br>

                            <button type="submit" value="Save" class="btn btn-warning">
                                SAVE FACULTY
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
