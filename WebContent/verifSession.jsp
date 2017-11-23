  <% if (session.getAttribute("login") == null) { 
   		RequestDispatcher dispat = request.getRequestDispatcher("login.jsp");
		dispat.forward(request, response);
	} %>