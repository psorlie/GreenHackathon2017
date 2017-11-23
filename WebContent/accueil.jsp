<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<jsp:include page="verifSession.jsp"/>
	<head>
		<jsp:include page="head.jsp" />
		<title>Accueil</title>
	</head>

	<body class="fixed-nav sticky-footer bg-dark" id="page-top">
		<!-- Navigation -->
		<jsp:include page="navigationBase.jsp"/>
		
		<!-- Contenu -->
		<div class="content-wrapper">
		
			<div class="container">
			  <!-- Breadcrumbs-->
			  <ol class="breadcrumb">
				<li class="breadcrumb-item">
				  <h3>Rechercher un dentiste</h3>
				</li>
			  </ol>
			  
			  <!-- CONTENU PAGE ICI -->
			  <jsp:include page="recherche.jsp" />
			</div>

			<!-- Pied de Page -->
			<div class="row">
				<footer class="sticky-footer">
				  <div class="container">
					<div class="text-center">
					  <small>Size : </small>
					</div>
				  </div>
				</footer>
			</div>
			
			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top">
			  <i class="fa fa-angle-up"></i>
			</a>
			
			<!-- Logout Modal-->
			<jsp:include page="logOutModal.jsp" />
		</div>
		
		<div>
		
			<jsp:include page="bootstrapJS.jsp"/>
		</div>
	</body>
</html>