  <% if (session.getAttribute("utilisateur") == null) { 
   		RequestDispatcher dispat = request.getRequestDispatcher("login.jsp");
		dispat.forward(request, response);
	} else{
		RequestDispatcher dispat = request.getRequestDispatcher("accueil.jsp");
		dispat.forward(request, response);
	}%>