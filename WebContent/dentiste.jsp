<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<h1>Annuaire dentiste</h1>

	<form class="form-horizontal" action="RechercheDentisteServlet"
		method="post">
		<div class="form-group">

			<div class="row">
				<label class="control-label col-xs-2" for="">Nom :</label> <input
					type="text" id="nom" name="nom" class="control-label col-xs-2" />
			</div>

			<div class="row">
				<label class="control-label col-xs-2" for="">Ville :</label> <input
					type="text" id="ville" name="ville" class="control-label col-xs-2" />
			</div>

			<div class="row">
				<label class="control-label col-xs-2" for="">Jour :</label>
			</div>
			<div class="row">

				<div class="checkbox">
					<label class="control-label col-xs-2 col-xs-offset-1"><input
						type="checkbox" checked value="1">Lundi</label>
				</div>
				<div class="checkbox">
					<label class="control-label col-xs-2 col-xs-offset-1"><input
						type="checkbox" checked value="2">Mardi</label>
				</div>
				<div class="checkbox">
					<label class="control-label col-xs-2 col-xs-offset-1"><input
						type="checkbox" checked value="3">Mercredi</label>
				</div>
				<div class="checkbox">
					<label class="control-label col-xs-2 col-xs-offset-1"><input
						type="checkbox" checked value="4">Jeudi</label>
				</div>
				<div class="checkbox">
					<label class="control-label col-xs-2 col-xs-offset-1"><input
						type="checkbox" checked value="5">Vendredi</label>
				</div>
			</div>

			<div class="row">
				<label class="control-label col-xs-2" for="">Horaire début :</label>
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

			<div class="row">
				<label class="control-label col-xs-2" for="">Horaire fin :</label> <select
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

			<div class="row">
				<label class="control-label col-xs-2" for="">Specialite :</label> <select
					name="horaires" id="horraires" class="control-label col-xs-2">
					<option value="1">a</option>
					<option value="2">b</option>
					<option value="3">c</option>
					<option value="4">d</option>
				</select>
			</div>
		</div>
	</form>
</body>
</html>