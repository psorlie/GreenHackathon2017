<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="head.jsp" />
<title>SB Admin - Start Bootstrap Template</title>
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Register an Account</div>
			<div class="card-body">
				<form  action="RegisterServlet" method="get">
					<div class="form-group">
						<label for="login">Identifiant</label> <input class="form-control"
							id="login" type="text" aria-describedby="loginHelp"
							placeholder="Enter identifiant">
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="password">Password</label> <input
									class="form-control" id="password" type="password"
									placeholder="Entrer mot de passe">
							</div>
							<div class="col-md-6">
								<label for="confirmPassword">Confirm password</label> <input
									class="form-control" id="confirmPassword" type="password"
									placeholder="Confirmer mot de passe">
							</div>
						</div>
					</div>
					<button type="submit" class="btn  btn-primary btn-block">Register</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.jsp">Login Page</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="bootstrapJS.jsp" />
</body>

</html>
