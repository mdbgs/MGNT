<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Détails</title>
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
											<h2>Détail de l'activité</h2>
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
											<h2>
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
														<label>Lieu de naissance <span>:</span></label>
													</div>
													<div class="row">
														<b>${std.countryOfBirth}</b>
													</div>
												</div>
												<div class="formeDroite col-xs-5">
													<div class="row">
														<label>niveau d'étude <span>:</span></label>
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
	<c:import url="piedsPage.jsp"></c:import>
	<script>
		$(document).ready(function() {
			$('#myDataTable').dataTable();
		});
	</script>
</body>
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
