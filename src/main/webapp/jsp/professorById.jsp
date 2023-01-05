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
    <title>Professor Field</title>
    <script type="text/javascript" src="js/test.js"></script>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/mybootstrap.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<!-- 
  <div class="container">
    <form method="GET" action="/FacultyServlet">
	    <div class="form-group">
        <input type="text" name="action" value="update" style="display: none"/>
		    </div>
	    <div class="form-group">
		<label for="id">Faculty Id</label>
        <input type="text" name="id" value="${faculty.id}" style="display: none"/>
		    </div>
		<div class="form-group">
		 <label for="name">Faculty Name:</label>
        <input type="text" name="name" value="${faculty.name}"/>
		    </div>
		<div class="form-group">
		<label for="location">faculty location:</label>
        <input type="text" name="location" value="${faculty.location}"/>
		    </div>
		<div class="form-group">
		<label for="study_field">faculty study_field:</label>
        <input type="text" name="study_field" value="${faculty.study_field}"/>
		    </div>
		<div class="form-group">
        <input type="submit" value="Update"/>
		</div>
    </form>
		</div>
		
		</br></br></br></br>
		
-->

<div class="container">

    <form class="well form-horizontal" action="/ProfessorServlet" method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <h2><b>PROFESSOR UPDATE</b></h2>
            </legend>

            <div class="form-group">
                <input type="text" name="action" value="update" style="display: none"/>
            </div>

            <div class="form-group">
                <input type="text" name="id" value="${university.id}" style="display: none"/>
            </div>
            <br>

            <!-- Text input-->
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

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4"><br>
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <button type="submit" class="btn btn-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspUPDATE
                                <span
                                        class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            </button>
                        </div>
                    </div>

        </fieldset>
    </form>
</div>
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
