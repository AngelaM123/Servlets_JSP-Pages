<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Subject" %>

<html>
<head>
    <title>Subject Create</title>
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
            <form class="well form-horizontal" action="/SubjectServlet" method="post" id="contact_form">
                <fieldset>

                    <!-- Form Name -->
                    <legend>
                        <center><h2><b>ADD NEW SUBJECT</b></h2></center>
                    </legend>
                    <br>

                    <div class="form-group">
                        <input type="text" name="action" value="save" style="display: none"/>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="name">Subject Name</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="name" placeholder="Enter Subject Name"
                                       class="form-control" type="text" value="${subject.name}">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="semester">Semester</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="semester" placeholder="Enter Semester"
                                       class="form-control" type="text" value="${subject.semester}">
                            </div>
                        </div>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="credits">Credits</label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <input name="credits" placeholder="Enter Credits"
                                       class="form-control" type="text" value="${subject.credits}">
                            </div>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4"><br>

                            <button type="submit" value="Save" class="btn btn-warning">
                                SAVE SUBJECT
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
