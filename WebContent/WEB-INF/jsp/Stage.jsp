<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
// 	if (user == null) {
// 		System.out.println("Utilisateur inexistant!!!");
// 		response.sendRedirect("connexion");
// 	} else {
// 		System.out.println("Utilisateur existant!!!");
// 	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Formulaire des Stages</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
<link rel="stylesheet" href="Assets/css/style.css" media="screen" />
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen" />
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/main.css" />
<link rel="stylesheet" href="Assets/css/MoneAdmin.css" />
<link rel="stylesheet"
	href="assets/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="Assets/plugins/Font-Awesome/css/font-awesome.css" />
<link href="Assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/nexus.css" rel="stylesheet" />
</head>

<body id="scroll_top">
	<section id="header_areaBis"> </section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content center">
			<div class="main_menu row">
				<nav>
					<ul id="nav2" class="barreOutil">
						<div class="col-xs-10 barreValue">
							<li><a href="home">Accueil</a></li>
							<li><a href="javascript:allActivite()">Activités<span>.</span></a>
								<ul>
									<li><a href="javascript:apprentissageActivite()">Apprentissage</a></li>
									<li><a href="javascript:rechercheActivite()">Recherche</a></li>
									<li><a href="javascript:partenaireActivite()">Partenariat</a></li>
									<li><a href="javascript:gouvernanceActivite()">Gouvernance</a></li>
								</ul> </a></li>
							<li><a href="">Indicateurs</li>
							<li><a href="">Résultats</a></li>
						</div>
						<div class="row ">
							<%
								if (user == null) {
									System.out.println("Utilisateur inexistant!!!");
							%>
							<li><a href="connexion"> Se connecter</a></li>
							<%
								} else {
							%>
							<li><a href="deconnection"> Se Déconnecter</a></li>
							<%
								}
							%>
						
					</ul>
				</nav>
			</div>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h1>
										Formulaire des Stages
										</h2>
								</div>
								<form method="post" action="stage" class="myForm">
									<h3>Stage</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Acteur <span>*</span></label>
											</div>
											<div class="row">
												<select id="Acteur"
													<input class="form-control" type="acteur" name="acteur" vvalue="${param.acteur}" />>
													<option>Indiquer l'acteur</option>
													<option>Etudiant</option>
													<option>Enseignant</option>
												</select>
											</div>
											<span class="erreur">${errors['acteur']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Date de début<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text" id="dateDeb"
													name="dateDeb" value="${param.dateDeb}" placeholder="Date" />
											</div>
											<span class="erreur">${errors['dateDeb']}</span>
										</div>
									</div>
									
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Date de fin</label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text" id="dateFin"
													name="dateFin" value="${param.dateFin}" placeholder="Date" />
											</div>
											<span class="erreur">${errors['dateFin']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Certificat <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="certificat"
													name="certificat" value="${param.certificat}" placeholder="certificat" />
											</div>
											<span class="erreur">${errors['certificat']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Nom de l'institution <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="institutionName"
													name="institutionName" value="${param.institutionName}" placeholder="nom de l'institution" />
											</div>
											<span class="erreur">${errors['institutionName']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Statut de l'institution</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="institutionStatut" name="institutionStatut"
													value="${param.institutionStatut}" placeholder="statut de l'institution" />
											</div>
											<span class="erreur">${errors['institutionStatut']}</span>
										</div>
										
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Prénom du directeur</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="diectorFirstName"
													name="diectorFirstName" value="${param.diectorFirstName}" placeholder="prénom du directeur" />
											</div>
											<span class="erreur">${errors['diectorFirstName']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nom du directeur</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="directorLastName" name="directorLastName"
													value="${param.directorLastName}" placeholder="nom du directeur" />
											</div>
											<span class="erreur">${errors['directorLastName']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Téléphone</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="directorphone"
													name="directorphone" value="${param.directorphone}" placeholder="téléphone" />
											</div>
											<span class="erreur">${errors['directorphone']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Email</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="directorEmail" name="directorEmail"
													value="${param.directorEmail}" placeholder="email" />
											</div>
											<span class="erreur">${errors['directorEmail']}</span>
										</div>
										
									</div>
									
									<div class="row myBtn">
											<input class="btn btn-danger " type="reset"
												value="Annuler" />
											<input class="btn btn-info " type="submit"
												value="Valider" />
										
									</div>
									<p class="${empty errors ? 'succes' : 'erreur'}">${resultat}</p>
								</form>
								<div class="fix scroll_to_top">
									<a href="#scroll_top" class="floatright">Remonter </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="footer_top_area">
		<div class="fix footer_top center">
			<div class="fix footer_top_container">
				<div>
					<ul class="col-xs-12">
						<li class="col-xs-2 myFooter"><a href=""><span>A
									propos</span></a></li>
						<li class="col-xs-2 myFooter"><a href=""><span>Nous
									contacter</span></a></li>
						<li class="col-xs-2 myFooter"><a href=""><span>Aide</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section id="footer_bottom_area">
		<div class="fix footer_bottom center">
			<div class="fix copyright floatleft">
				<p>&#169 2015 CEAMITIC</p>
			</div>
			<div class="fix footer_bottom_text floatright">
				<p>
					<a href="http://www.ceamitic.sn" title="Site web du centre"
						target="_blank">www.ceamitic.sn</a>
				</p>
			</div>
		</div>
	</section>
	<!-- Jessor slider Start-->
	<script src="Assets/plugins/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="Assets/js/bootstrap.min.js"></script>
    <script src="Assets/plugins/jasny/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript"
		src="Assets/plugins/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.core.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.utils.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.slider.js"></script>
	<!-- JS -->
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<script type="text/javascript" src="Assets/js/myScript.js"></script>
	<script src="Assets/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="Assets/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(function() {
			$("#overlay").click(function() {
				$("#cadre").fadeOut();
				$("#overlay").fadeOut();
			});
		});
	</script>




</body>
<!-- JS -->
<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
<script type="text/javascript" src="Assets/js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="Assets/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="Assets/js/bootstrap-datepicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function getValueOption(valueOption) {
		var selectedanswer = document.getElementById(valueOption).selectedIndex;
		return document.getElementsByTagName("option")[selectedanswer].value;
	});
</script>
</html>
