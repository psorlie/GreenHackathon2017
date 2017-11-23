<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="head.jsp" />
<title>Login</title>
</head>

<%
	if (session.getAttribute("dentiste") == null) {
		RequestDispatcher dispat = request.getRequestDispatcher("index.jsp?connexion=false");
		dispat.forward(request, response);
	}
%>

<%@ page import="greenHackaton2017.java.model.User"%>
<%@ page import="greenHackaton2017.java.model.Dentiste"%>
<%@ page import="greenHackaton2017.java.model.Day"%>

<%
	Dentiste dentiste = (Dentiste) request.getSession().getAttribute("dentiste");
%>

<body>
	<div class="container-fluid">
		<div class="col-lg-3 offset-lg-1" style="margin-top: 15px">
			<h1>Fiche dentiste</h1>
		</div>
		<div class="form-horizontal offset-lg-2 col-lg-8">
			<div class="form-group col-lg-12" style="text-align: left">
				<div class="form-inline">
					<div class="form-group col-lg-3">
						<div class="form-group">
							<label>image</label>
						</div>
					</div>
					<div class="form-group col-lg-3 offset-lg-2">
						<div class="form-horizontal">
							<div class="form-group">
								<label><%=(dentiste.isFemale()?"Mrs ":"Mr. ") + dentiste.getSurname() + " " + dentiste.getFirstName()%></label>
							</div>
							<div class="form-group">
								<label><%=dentiste.getSpeciality()%>></label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-lg-12">
				<h5>Informations pratiques</h5>
				<div class="form-inline">
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
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
							<tr>
								<th>Fermeture</th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</table>
					</div>
					<div class="form-group col-lg-5 offset-lg-1">
						<div class="form-horizontal">
							<div class="form-group">
								<label><%=dentiste.getAddress()%></label>
							</div>
							<div class="form-group">
								<label><%=dentiste.getCity()%></label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group col-lg-12">
				<h5>Contact</h5>
				<div class="form-horizontal">
					<div class="form-group col-lg-6">
						<label><%=dentiste.getPhone()%></label>
					</div>
					<div class="form-group col-lg-6">
						
						<label><%=dentiste.getEmail()%></label>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
