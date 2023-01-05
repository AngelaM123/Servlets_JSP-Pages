
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Faculty" %>

<html>
  <head>
    <title>Faculty Details</title>
		<script type="text/javascript" src="js/test.js"></script>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="css/mybootstrap.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
  <body>
  
<center><div class="jumbotron">
<center>
<legend><h2><b>Faculty Structure</b></h2></legend>

      <h2>
		<a class="btn btn-primary btn-lg" 
			href="http://localhost:8080/FacultyServlet?action=new" 
			role="button">
			Add New Faculty
		</a>

			&nbsp;&nbsp;&nbsp;
			
		<a class="btn btn-primary btn-lg" 
			href="http://localhost:8080/FacultyServlet?action=all" 
			role="button">
			List All Faculties
		</a>
      </h2>
  </center>
  <div align="center" class="container-center">
      <c:if test="${faculty != null}">
      <form action="update" method="post" class="well form-horizontal">
          </c:if>
          <c:if test="${faculty == null}">
          <form action="insert" method="post" class="well form-horizontal">
              </c:if>

                  <caption>
				  <legend><b><h2>
                          <c:if test="${faculty != null}">
                              Edit Faculty
                          </c:if>
                          <c:if test="${faculty == null}">
                              Add New Faculty
                          </c:if>
                      </h2></b></legend>
                  </caption>
				  
				 <br>
                  <c:if test="${faculty != null}">
                      <input type="hidden" name="id" value="<c:out value='${faculty.id}' />" />
                  </c:if>
				  
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Faculty Name</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
	<input  name="name"   class="form-control"  type="text" 
		value="<c:out value='${faculty.name}' />" />
  </div>
  </div>
</div>
			

<div class="form-group">
  <label class="col-md-4 control-label" for="location">Faculty Location</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
	<input  name="location"   class="form-control" type="text" 
		value="<c:out value='${faculty.location}' />" />
  </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="study_field">Study Field</label> 
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
	<input name="study_field" class="form-control" type="text" 
		value="<c:out value='${faculty.study_field}' />" />
   </div>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4"><br>

	<button type="submit"  value="Save" class="btn btn-warning">
		SAVE FACULTY INFO
		<span class="glyphicon glyphicon-send"></span>
	</button>
  </div>
</div>

</form>
  </div>
 </div>
    </center>
  </body>
</html>
