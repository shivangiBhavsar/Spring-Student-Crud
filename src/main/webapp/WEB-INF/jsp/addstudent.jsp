<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add Student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>


	<div class="container my-5">
		<h3>Add Student</h3>
		<div class="card">
			<div class="card-body">
				<div class="col-md-10">
					<form:form action="/jsp/savestudentjsp" method="post"
						modelAttribute="student" enctype="multipart/form-data">
						<form:hidden path="id" />
						<div class="row">
							<div class="form-group col-md-8">
								<label for="rollno" class="col-form-label">Roll Number</label>
								<form:input type="text" class="form-control" id="rollno"
									path="rollno" placeholder="Enter Roll Number" />
							</div>
							<div class="form-group col-md-8">
								<label for="firstname" class="col-form-label">FirstName</label>
								<form:input type="text" class="form-control" id="firstname"
									path="firstname" placeholder="Enter FirstName" />
							</div>
							<div class="form-group col-md-8">
								<label for="lastname" class="col-form-label">LastName</label>
								<form:input type="text" class="form-control" id="lastname"
									path="lastname" placeholder="Enter LastName" />
							</div>
							<div class="form-group col-md-8">
								<label for="firstname" class="col-form-label">Email</label>
								<form:input type="text" class="form-control" id="email"
									path="email" placeholder="Enter Email" />
							</div>
							<div class="form-group col-md-8">
								<label for="phoneno" class="col-form-label">Phone Number</label>
								<form:input type="text" class="form-control" id="phoneno"
									path="phoneno" placeholder="Enter Phone Number" />
							</div>

							<div class="form-group col-md-8">
								<label for="address" class="col-form-label">Address</label>
								<form:textarea class="form-control" id="address" path="address"
									placeholder="Enter Address" />
							</div>

							<div class="form-group col-md-8">
								<label for="gender" class="col-form-label">Gender</label>
								<div class="form-check">
									<form:radiobutton class="form-check-input" id="male"
										value="male" path="gender" />
									<label class="form-check-label" for="male"> Male</label>
								</div>
								<div class="form-check">
									<form:radiobutton class="form-check-input" id="female"
										value="female" path="gender" />
									<label class="form-check-label" for="female"> Female</label>
								</div>
							</div>
							
							<div class="form-group col-md-8">
								<label for="standard" class="col-form-label">Standard</label>
								<form:select id="standard" path="standard" items="${standards}"/>
							</div>

							



							<div class="form-group col-md-8">
								<label for="file" class="col-form-label">Student Image</label>
								<div class="custom-file">
									<input type="file" name="file" class="custom-file-input"
										id="customFile"> <label class="custom-file-label"
										for="customFile">Choose file</label>
								</div>
							</div>


							<div class="col-md-6">
								<input type="submit" class="btn btn-primary" value=" Submit ">
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script>
		// Add the following code if you want the name of the file appear on select
		$(".custom-file-input").on(
				"change",
				function() {
					var fileName = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.html(fileName);
				});
	</script>

</body>
</html>