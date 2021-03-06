<%@ page import="greenHackaton2017.java.model.User"%>
<%@ page import="greenHackaton2017.java.model.Dentiste"%>

<%
	User user = (User) request.getSession().getAttribute("utilisateur");
%>

<nav class="navbar navbar-expand-lg navbar-expand-sm navbar-dark bg-dark fixed-top rounded" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="accueil.jsp"><i>Dentiste Search Engine 9000</i></a>
		<div class="collapse navbar-collapse" id="navbarResponsive">
		  <ul class="navbar-nav ml-auto">
			<li class="nav-item">
			<% if (request.getSession().getAttribute("utilisateur") != null){ %>
					<label class="nav-link"><strong>Utilisateur : <%= user.getLogin() %></strong></label>
			<% } %>
			</li>
			<li class="nav-item">
			  <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
				<i class="fa fa-fw fa-sign-out"></i>Logout</a>
			</li>
		  </ul>
		</div>
	</div>
</nav>
