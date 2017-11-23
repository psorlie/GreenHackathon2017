<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="head.jsp"/>
	<title>Login</title>
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form action="LoginServlet" method="get">
					<div class="form-group">
						<label for="login">Identifiant</label> <input
							class="form-control" id="login" type="text"
							aria-describedby="loginHelp"
							placeholder="Enter identifiant">
					</div>
					<div class="form-group">
						<label for="password">Mot de passe</label> <input class="form-control"
							id="mdp" type="password" placeholder="Entrer mot de passe">
					</div>
					<button type="submit" class="btn  btn-primary btn-block">Login</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="register.jsp">Register an
						Account</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
