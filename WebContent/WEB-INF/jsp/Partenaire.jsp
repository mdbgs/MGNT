<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
	if (user == null) {
		System.out.println("Utilisateur inexistant!!!");
		response.sendRedirect("connexion");
	} else {
		System.out.println("Utilisateur existant!!!");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Formulaire Partenaire</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
<link rel="stylesheet" href="Assets/css/style.css" media="screen" />
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen" />
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
										Formulaire d'inscription Partenaire
										</h2>
								</div>
								<form method="post" action="Partenaire" class="myForm">
									<h3>Coordonnées Partenaire</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Nom <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="lastName"
													name="lastName" value="${param.lastName}" placeholder="Nom" />
											</div>
											<span class="erreur">${errors['lastName']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Type<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="type"
													name="type" value="${param.type}" placeholder="type" />
											</div>
											<span class="erreur">${errors['type']}</span>
										</div>
									</div>
									
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Email <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="email" id="mail"
													name="mail" value="${param.mail}" placeholder="Email" />
											</div>
											<span class="erreur">${errors['mail']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Adresse <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="adress"
													name="adress" value="${param.adress}" placeholder="Adresse" />
											</div>
											<span class="erreur">${errors['adress']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Téléphone <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phone"
													name="phone" value="${param.phone}" placeholder="Téléphone" />
											</div>
											<span class="erreur">${errors['phone']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Boite Postale</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="bp" name="bp"
													value="${param.bp}" placeholder="Boite postale" />
											</div>
											<span class="erreur">${errors['bp']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Titre de l'accord </label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="acc_Title"
													name="acc_Title" value="${param.acc_Title}" placeholder="titre de l'accord" />
											</div>
											<span class="erreur">${errors['acc_Title']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Domaine de collaboration</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="collaboration_D" name="collaboration_D"
													value="${param.collaboration_D}" placeholder="domaine de collaboration" />
											</div>
											<span class="erreur">${errors['collaboration_D']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Date de signature </label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="signDate"
													name="signDate" value="${param.signDate}" placeholder="date de signature" />
											</div>
											<span class="erreur">${errors['signDate']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Expiration de l'accord</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="acc_Expiration" name="acc_Expiration"
													value="${param.acc_Expiration}" placeholder="expiration de l'accord" />
											</div>
											<span class="erreur">${errors['acc_Expiration']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Résultat attendu</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="att_Result"
													name="att_Result" value="${param.att_Result}" placeholder="résultat attendu" />
											</div>
											<span class="erreur">${errors['att_Result']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Projet conjoint</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="conjointProject" name="conjointProject"
													value="${param.conjointProject}" placeholder="projet conjoint" />
											</div>
											<span class="erreur">${errors['conjointProject']}</span>
										</div>
									</div>
										
									<div class="row myBtn">
											<input class="btn btn-danger " type="reset"
												value="Annuler" />
											<input class="btn btn-info " type="submit"
												value="Inscription" />
										
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
	<script src="http://code.jquery.com/jquery.js"></script>
	<!-- Jessor slider Start-->
	<script type="text/javascript" src="Assets/js/jssor.core.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.utils.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.slider.js"></script>
	<!-- JS -->
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<!-- 	<script type="text/javascript" src="Assets/js/jquery.min.js"></script> -->
	<script type="text/javascript" src="Assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Assets/js/myScript.js"></script>
	<script src="Assets/plugins/jquery-2.0.3.min.js"></script>
	<!-- END GLOBAL SCRIPTS -->
	<!-- PAGE LEVEL SCRIPTS -->
	<script src="Assets/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="Assets/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#myDataTable').dataTable();
		});
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
	$(document).ready(function() {

		$('.date').datepicker({
			format : "dd/mm/yyyy"
		});
	});
</script>
</html>
