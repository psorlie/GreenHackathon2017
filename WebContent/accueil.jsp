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
				<li class="breadcrumb-item active">
				  <a href="accueil.jsp">Rechercher un dentiste</a>
				</li>
			  </ol>
			  
			  <!-- CONTENU PAGE ICI -->
			<div class="row">
				<div class="col-12">
				
					<h1>Annuaire dentiste</h1>

					<form class="form-horizontal" action="RechercheDentisteServlet"
						method="post">

						<div class="form-group">
							<label class="control-label col-xs-1" for="">Nom :</label> <input
								type="text" id="nom" name="nom" class="control-label col-xs-2" />
						</div>

						<div class="form-group">
							<label class="control-label col-xs-1" for="">Ville :</label> <input
								type="text" id="ville" name="ville" class="control-label col-xs-2" />
						</div>

						<div class="form-group">
							<label class="control-label col-xs-1" for="">Jour :</label>
						</div>

						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox">Lundi
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox">Mardi
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox">Mercredi
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox">Jeudi
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox">Vendredi
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-1" for="">Horaire début :</label>
							<select name="horaire_debut" id="horraires"
								class="control-label col-xs-2">
								<option value="6">6:00</option>
								<option value="7">7:00</option>
								<option value="8">8:00</option>
								<option value="9">9:00</option>
								<option value="10">10:00</option>
								<option value="11">11:00</option>
								<option value="12">12:00</option>
								<option value="13">13:00</option>
								<option value="14">14:00</option>
								<option value="15">15:00</option>
								<option value="16">16:00</option>
								<option value="17">17:00</option>
								<option value="18">18:00</option>
								<option value="19">19:00</option>
							</select>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-1" for="">Horaire fin :</label> <select
								name="horaire_fin" id="horraires" class="control-label col-xs-2">
								<option value="6">6:00</option>
								<option value="7">7:00</option>
								<option value="8">8:00</option>
								<option value="9">9:00</option>
								<option value="10">10:00</option>
								<option value="11">11:00</option>
								<option value="12">12:00</option>
								<option value="13">13:00</option>
								<option value="14">14:00</option>
								<option value="15">15:00</option>
								<option value="16">16:00</option>
								<option value="17">17:00</option>
								<option value="18">18:00</option>
								<option value="19">19:00</option>
							</select>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-1" for="">Specialite :</label> <select
								name="horaires" id="horraires" class="control-label col-xs-2">
								<option value="1">a</option>
								<option value="2">b</option>
								<option value="3">c</option>
								<option value="4">d</option>
							</select>
						</div>
					</form>
				<div/>
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