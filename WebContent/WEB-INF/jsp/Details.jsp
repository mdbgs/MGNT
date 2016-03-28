<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Détails</title>
<link rel="shortcut icon" type="image/x-icon"
	href="Assets/images/slideshow/logoceamitic.png" sizes="16x16" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content center">
			<div class="main_menu row">
				<c:import url="entete.jsp"></c:import>
			</div>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sideb">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-body">
									<c:set scope="session" var="activ" value="${activiteRecu}"></c:set>
									<c:if test="${activ!=null}">
										<div class="panel-heading">
											<h1>
												Détail de l'activité
												</h2>
												<hr>
										</div>
										<div class="formulDetail">
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Libelle <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.libelle}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Periode <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.periode}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Echéance Prévu <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.echeancePrevu}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Echéance Réalisé <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.echeanceRealise}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Statut de l'activité <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.statutActivite}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Nature de l'indicateur <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.natureIndicateur}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Libelle de l'indicateur <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.libelleIndicateur}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>reférence au tableau de saisie <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.referenceTableauDeSaisie}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Pièce justificatif <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.pieceJustificatif}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Composant <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.composant}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Objectif <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.objectif}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Resultat Attendu <span>:</span></label>
													</div>
													<div class="row">
														<b>${activ.resultatAttendu}</b>
													</div>
												</div>
											</div>
											<input class="btn btn-danger myBtnDetail"
												onclick="location.href = 'activite';" value="Retour" />
										</div>
									</c:if>
									<c:set scope="session" var="std" value="${etudiantRecu}"></c:set>
									<c:if test="${std!=null}">
										<div class="panel-heading">
											<h1>
												Détail de l'étudiant
												</h2>
										</div>
										<div class="formulDetail">
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Numéro d'étudiant <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.studentNumber}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Prenom <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.firstName}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Nom <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.lastName}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Date de Naissance <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.birthday}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Lieu de naissance</ <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.countryOfBirth}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>niveau d'étude</ <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.level}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Nationalité <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.nationality}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Adresse <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.adress}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Email <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.mail}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Téléphone <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.phone}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Boite postale <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.bp}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Sexe <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.gender}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Programme <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.program}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Semestre <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.semester}</b>
													</div>
												</div>
											</div>
											<hr>
											<h2>Personne à contacter</h2>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Prenom <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.firstNamePAC}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Nom <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.lastNamePAC}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Télephone <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.phonePAC}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Adresse <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.adressPAC}</b>
													</div>
												</div>
											</div>
											<input class="btn btn-danger myBtnDetail"
												onclick="location.href = 'listeEtudiant';" value="Retour" />
										</div>
									</c:if>
									<c:set scope="session" var="indic" value="${indicateurRecu}"></c:set>
									<c:if test="${indic!=null}">
										<div class="panel-heading">
											<h1>Détail de l'indicateur</h1>
										</div>
										<div class="formulDetail">
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Numero <span>:</span></label>
													</div>
													<div class="row">
														<b>${indic.numero}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>libelle <span>:</span></label>
													</div>
													<div class="row">
														<b>${indic.libelle}</b>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-5" id="formeGauche">
													<div class="row ">
														<label>Objectif <span>:</span></label>
													</div>
													<div class="row">
														<b>${indic.objectif}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>Sigle <span>:</span></label>
													</div>
													<div class="row">
														<b>${indic.sigle}</b>
													</div>
												</div>
											</div>
										</div>
										<input class="btn btn-danger myBtnDetail"
											onclick="location.href = 'indicateur';" value="Retour" />
									</c:if>
								</div>
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
