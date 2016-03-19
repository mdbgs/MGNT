<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Authentification</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Css include -->
	<link rel="stylesheet" href="Assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css">
	<link rel="stylesheet" href="Assets/css/style.css" media="screen">
	<link rel="stylesheet" href="Assets/css/responsive.css" media="screen">
	<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
	<link rel="stylesheet" href="Assets/css/nexus.css" rel="stylesheet">
</head>
<body>
	<div class="row">
      <form class="form-signin" method="post" action="j_security_check">
        <h2 class="form-signin-heading">Connexion</h2>
        <label for="inputEmail" class="sr-only">Adresse mail</label>
        <input type="email" name="j_username" class="form-control" placeholder="Email" required autofocus>
        <label for="inputPassword" class="sr-only">mot de passe</label>
        <input type="password" name="j_password" class="form-control" placeholder="Mot de passe" required>
        <button id="connexion" class="btn btn-lg btn-primary btn-block" type="submit">Connecter</button>
      </form>

    </div>
</body>
	<!-- JS -->
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<script type="text/javascript" src="Assets/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="Assets/js/bootstrap.min.js" type="text/javascript"></script>
</html>