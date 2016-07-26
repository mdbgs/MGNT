<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	request.getSession(false);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="Header.jsp"></c:import>
<head>
<title>Authentification</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css">
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css">
<link rel="stylesheet" href="Assets/css/style.css" media="screen">
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen">
<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="Assets/images/slideshow/logoceamitic.png" sizes="16x16" />
<link rel="stylesheet" href="Assets/css/nexus.css" rel="stylesheet">
</head>
<body>
	<div class="col-lg-offset-4 col-sm-4 col-md-offset-4 col-md-4 col-lg-offset-4 col-sm-4">
		<div class="containerConnexion">
<!-- 		<h2 class="form-signin-heading">Page de connexion</h2> -->
		<img alt="CEA-MITIC" src="Assets/images/slideshow/logoceamitic.png"
			class="imgConnextion">
		<c:if test="${connectionError==true}">
			<label class="errorConnected">Pseudo ou mot de passe
				incorrecte veillez réessayer!</label>
		</c:if>
		<form class="form-signin" method="post" action="j_security_check">
			<label for="inputEmail" class="sr-only">Adresse mail</label> <input
				type="text" name="j_username" class="form-control"
				placeholder="Pseudo ou Email" required> <label
				for="inputPassword" class="sr-only">mot de passe</label> <input
				type="password" name="j_password" class="form-control"
				placeholder="Mot de passe" required>
			<button id="connexion" class="btn btn-lg btn-primary btn-block"
				type="submit">Connectez-vous</button>
		</form></div>
	</div>
</body>
<!-- JS -->
<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
<script type="text/javascript" src="Assets/js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="Assets/js/bootstrap.min.js"
	type="text/javascript"></script>
</html>