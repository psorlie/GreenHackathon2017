<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="greenHackaton2017.java.model.User"%>
<%@ page import="greenHackaton2017.java.model.Dentiste"%>
<%@ page import="java.util.List"%>

<%
	User userCourant = (User) request.getSession().getAttribute("utilisateur");
	List<Dentiste> dentistes = userCourant.getDentistesConsultes();
	int nbResultats = dentistes.size();
%>

<jsp:include page="verifSession.jsp" />

<html lang="en">
<head>
<jsp:include page="head.jsp" />
<title>Resultats</title>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation -->
	<jsp:include page="navigationBase.jsp" />

	<!-- Contenu -->
	<div class="content-wrapper">

		<div class="container">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item">
					<h3>Resultats de la recherche</h3>
				</li>
			</ol>

			<!-- CONTENU PAGE ICI -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-search"></i> <strong>Dentistes trouves :</strong>
				</div>
				<div class="card-body">
					<%
						if (dentistes.size() == 0) {
					%>
					<h4>Aucun resultat pour cette recherche</h4>
					<%
						} else {
					%>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Ville</th>
								<th>Specialite</th>
							</tr>
						</thead>

						<tbody>
							<%
								for (int i = 0; i < nbResultats; ++i) {
									out.println("<tr onclick=\"location.href='detailsDentiste.jsp?nDentist="+i+"'\">");
									out.println("<td>"+(dentistes.get(i).isFemale() ? "Mme. " : "M. ") + dentistes.get(i).getSurname() + " "
											+ dentistes.get(i).getFirstName()+"</td>");
									out.println("<td>"+dentistes.get(i).getCity()+"</td>");
									out.println("<td>"+dentistes.get(i).getSpeciality()+"</td>");
									out.println("</tr>");
								}
							%>
						</tbody>
					</table>
					<%
						}
					%>
				</div>
			</div>
		</div>

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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<div>

		<jsp:include page="bootstrapJS.jsp" />
	</div>

</body>
</html>