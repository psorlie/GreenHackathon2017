<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<jsp:include page="head.jsp" />
		<title>Accueil</title>
	</head>

	<body class="fixed-nav sticky-footer bg-dark" id="page-top">
		<!-- Navigation -->
		<jsp:include page="navigationBase.jsp"/>
		
		<!-- Contenu -->
		
		<div class="content-wrapper">
			<div class="container-fluid">
			  <!-- Breadcrumbs-->
			  <ol class="breadcrumb">
				<li class="breadcrumb-item">
				  <a href="index.html">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Blank Page</li>
			  </ol>
			  
			  <!-- CONTENU PAGE ICI -->
			  <div class="row">
				<div class="col-12">
				  <h1>Blank</h1>
				  <p>This is an example of a blank page that you can use as a starting point for creating new ones.</p>
				</div>
			  </div>
			</div>
			
			<!-- Pied de Page -->
			<footer class="sticky-footer">
			  <div class="container">
				<div class="text-center">
				  <small>Copyright © Your Website 2017</small>
				</div>
			  </div>
			</footer>
			
			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top">
			  <i class="fa fa-angle-up"></i>
			</a>
			
			<!-- Logout Modal-->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
				<div class="modal-content">
				  <div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">×</span>
					</button>
				  </div>
				  <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
				  <div class="modal-footer">
					<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				  </div>
				</div>
			  </div>
			</div>
		</div>
		
		<div>
		
			<jsp:include page="bootstrapJS.jsp"/>
		</div>
	</body>
</html>