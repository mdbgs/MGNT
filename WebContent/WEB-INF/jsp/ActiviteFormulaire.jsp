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
<title>Formulaire des activités</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
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
				<c:import url="entete.jsp"></c:import>
			</div>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h1>
										Formulaire des activités
										</h2>
								</div>
								<form method="post" action="activiteFormulaire" class="myForm">
									<h3>Activité</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Libelle</label>
											</div>
											<div class="row">
												<input class="form-control" type="libelle" id="libelle" name="libelle"
											value="${param.libelle}" placeholder="libelle" />
											</div>
											<span class="erreur">${errors['libelle']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Période</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="periode"
											name="periode" value="${param.periode}" placeholder="periode" />
											</div>
											<span class="erreur">${errors['periode']}</span>
										</div>
									</div>
									<div class="row ">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Echéance Prévu</label>
											</div>
											<div class="row date">
												<input class="form-control " type="text" id="echeancePrevu"
											name="echeancePrevu" value="${param.echeancePrevu}" placeholder="echeance prevu" />
											</div>
											<span class="erreur">${errors['echeancePrevu']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row ">
												<label>Echéance Réalisé</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="echeanceRealise"
											name="echeanceRealise" value="${param.echeanceRealise}" placeholder="écheance réalisé"/>
											</div>
											<span class="erreur">${errors['echeanceRealise']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Statut de l'activité</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="statutActivite"
													name="statutActivite" value="${param.statutActivite}" placeholder="Statut de l'activité" />
											</div>
											<span class="erreur">${errors['statutActivite']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nature de l'indicateur</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="natureIndicateur"
													name="natureIndicateur" value="${param.natureIndicateur}" placeholder="Nature de l'indicateur" />
											</div>
											<span class="erreur">${errors['natureIndicateur']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Libelle de l'indicateur</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="libelleIndicateur" name="libelleIndicateur"
													value="${param.libelleIndicateur}" placeholder="libelle de l'indicateur"/>
											</div>
											<span class="erreur">${errors['libelleIndicateur']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Référence tableau de saisie</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="referenceTabSaisie"
													name="referenceTabSaisie" value="${param.referenceTabSaisie}" placeholder="Référence tableau de saisie" />
											</div>
											<span class="erreur">${errors['referenceTabSaisie']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Pièce justificatif</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="pieceJustificatif"
													name="pieceJustificatif" value="${param.pieceJustificatif}" placeholder="Pièce justificatif" />
											</div>
											<span class="erreur">${errors['pieceJustificatif']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Composant</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="composant"
													name="composant" value="${param.composant}" placeholder="composant" />
											</div>
											<span class="erreur">${errors['composant']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Objectif</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="objectif"
													name="objectif" value="${param.objectif}" placeholder="objectif" />
											</div>
											<span class="erreur">${errors['objectif']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Résultat Attendu</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="resultatAttendu"
													name="resultatAttendu" value="${param.resultatAttendu}" placeholder="resultat attendu" />
											</div>
											<span class="erreur">${errors['resultatAttendu']}</span>
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

			<c:import url="piedsPage.jsp"></c:import>

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
