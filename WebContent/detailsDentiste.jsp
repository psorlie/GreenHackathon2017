<!DOCTYPE html>
<html lang="en">

<jsp:include page="verifSession.jsp" />

<head>
<jsp:include page="head.jsp" />
<title>Login</title>
</head>

<%
	// 	if (session.getAttribute("dentiste") == null) {
	// 		RequestDispatcher dispat = request.getRequestDispatcher("index.jsp?connexion=false");
	// 		dispat.forward(request, response);
	// 	}
%>

<%@ page import="greenHackaton2017.java.model.User"%>
<%@ page import="greenHackaton2017.java.model.Dentiste"%>
<%@ page import="greenHackaton2017.java.model.Day"%>

<%
	Dentiste dentiste = ((User) request.getSession().getAttribute("utilisateur")).getDentistesConsultes().get(Integer.parseInt(request.getParameter("nDentist")));
%>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation -->
	<jsp:include page="navigationBase.jsp" />

	<!-- Contenu -->
	<div class="content-wrapper">

		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb offset-lg-1 col-lg-10">
				<li class="breadcrumb-item">
					<h3><%=(dentiste.isFemale() ? "Mrs " : "Mr. ") + dentiste.getSurname() + " " + dentiste.getFirstName()
					+ (dentiste.getSpeciality() != "" ? " (" + dentiste.getSpeciality() + ")" : "")%></h3>
				</li>
			</ol>




			<div class="offset-lg-1 col-lg-10 ">

				<div class="card mb-3">

					<div class="card-body">

						<div class="form-inline">
							<div class="form-group col-lg-3">
								<img src="<%=dentiste.getPhoto()%>">
							</div>

							<div class="form-group">
								<div class="form-horizontal">
									<div class="form-group col-lg-12">
										<h5>Horraires :</h5>
									</div>
									<div class="form-group col-lg-12">
										<div class="form-group col-lg-5">
											<table class="table table-bordered" style="font-size: 10px">
												<tr>
													<th></th>
													<th>Lundi</th>
													<th>Mardi</th>
													<th>Mercredi</th>
													<th>Jeudi</th>
													<th>Vendredi</th>
												</tr>
												<tr>
													<th>Ouverture</th>
													<th><%=dentiste.getOpeningHours()[0].getOpening()%></th>
													<th><%=dentiste.getOpeningHours()[1].getOpening()%></th>
													<th><%=dentiste.getOpeningHours()[2].getOpening()%></th>
													<th><%=dentiste.getOpeningHours()[3].getOpening()%></th>
													<th><%=dentiste.getOpeningHours()[4].getOpening()%></th>
												</tr>
												<tr>
													<th>Fermeture</th>
													<th><%=dentiste.getOpeningHours()[0].getClosing()%></th>
													<th><%=dentiste.getOpeningHours()[1].getClosing()%></th>
													<th><%=dentiste.getOpeningHours()[2].getClosing()%></th>
													<th><%=dentiste.getOpeningHours()[3].getClosing()%></th>
													<th><%=dentiste.getOpeningHours()[4].getClosing()%></th>
												</tr>
											</table>
										</div>
									</div>
									<div class="form-group col-lg-12">
										<h5>Adresse :</h5>
									</div>
									<div class="form-group col-lg-12">
										<div class="form-group col-lg-8">
											<label><%=dentiste.getAddress()%></label>
										</div>
										<div class="form-group col-lg-8">
											<label><%=dentiste.getCity()%></label>
										</div>
									</div>
									<div class="form-group col-lg-12" style="margin-top: 10px">
										<h5>Contact :</h5>
									</div>
									<div class="form-group col-lg-12">
										<div class="form-inline">
											<div class="form-group col-lg-6">
												<div class="form-horizontal">
													<div class="form-group col-lg-12">
														<label><%=dentiste.getPhoneString().substring(0, 3)+"-"
														+dentiste.getPhoneString().substring(3, 6)+"-"+dentiste.getPhoneString().substring(6, 10)%></label>
													</div>
													<div class="form-group col-lg-12">
														<label><%=dentiste.getEmail()%></label>
													</div>
												</div>
											</div>
											<div class="form-group col-lg-3 offset-lg-3"
												style="margin-top: 10px">
												<form class="form-horizontal" action="ContacterServlet"
													method="get">
													<input type="hidden" name="idDentist"
														value=<%=dentiste.getId()%> />
													<button type="submit" class="btn btn-info"
														data-toggle="collapse" data-target="#contacter">
														Contacter</button>


												</form>


												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
