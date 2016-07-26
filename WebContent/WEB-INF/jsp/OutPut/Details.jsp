<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<c:import url="../Header.jsp"></c:import>
<head>
<title>Détails</title>
</head>
<body id="scroll_top">
	<c:import url="../sidebar.jsp"></c:import>
	<div
		class="main-content col-sm-offset-1 col-md-offset-1 col-xs-offset-1 col-sm-10 col-md-10 col-xs-10">
		<c:import url="../MenuBar.jsp"></c:import>
		<div class="content">
			<div class="fix main_content_area">
				<div class="fix allSearch"></div>
				<div class="fix single_sideb">
					<c:set scope="session" var="activ" value="${activiteRecu}"></c:set>
					<c:if test="${activ!=null}">
						<div
							class="detailHeading col-lg-offset-2 col-sm-offset-2 col-md-offset-2">
							<h1>D&eacute;tail de l'activit&eacute</h1>
						</div>
						<div class="menuDetail col-lg-offset-2 col-md-offset-2 col-lg-8 col-md-8 col-sm-8">
						<div class="bodyDetail">
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Libelle <span>:</span></label>
										<b>${activ.libelle}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Periode <span>:</span></label>
										<b>${activ.periode}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Echéance Prévu <span>:</span></label>
										<b>${activ.echeancePrevu}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Echéance Réalisé <span>:</span></label>
										<b>${activ.echeanceRealise}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Statut de l'activité <span>:</span></label>
										<b>${activ.statutActivite}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Nature de l'indicateur <span>:</span></label>
										<b>${activ.natureIndicateur}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Libelle de l'indicateur <span>:</span></label>
										<b>${activ.libelleIndicateur}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>reférence au tableau de saisie <span>:</span></label>
										<b>${activ.referenceTableauDeSaisie}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Pièce justificatif <span>:</span></label>
										<b>${activ.pieceJustificatif}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Composant <span>:</span></label>
										<b>${activ.composant}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Objectif <span>:</span></label>
										<b>${activ.objectif}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Resultat Attendu <span>:</span></label>
										<b>${activ.resultatAttendu}</b>
							</div>
						</div>
						</div>
							<div class="col-sm-2 col-lg-2 col-md-2">
								<input class="btn btn-info myBtnDetail"
									style="margin-bottom: 10px;"
									onclick="location.href = 'activityForm?role=${std.pseudo}';"
									value="Modifier" /> <input class="btn btn-danger myBtnDetail"
									onclick="location.href = 'activityList';" value="Retour" />
							</div>
					</c:if>
					<c:set scope="session" var="thd" value="${teacherRecu}"></c:set>
					<c:if test="${thd!=null}">
						<div
							class="detailHeading col-lg-offset-2 col-sm-offset-2 col-md-offset-2">
							<h1>D&eacute;tail de l'enseignant</h1>
						</div>
						
						<div class="menuDetail col-lg-offset-2 col-md-offset-2 col-lg-8 col-md-8 col-sm-8">
						<div class="bodyDetail">
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Nom <span>:</span></label> <b>${thd.lastName}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Prenom <span>:</span></label> <b>${thd.firstName}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Adresse <span>:</span></label> <b>${thd.adress}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Email <span>:</span></label> <b>${thd.mail}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Niveau <span>:</span></label> <b>${thd.level}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Nationnalité <span>:</span></label> <b>${thd.nationality}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Numéro de téléphone <span>:</span></label> <b>${thd.phoneNumber}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>sexe <span>:</span></label> <b>${thd.gender}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Boite postale <span>:</span></label> <b>${thd.bp}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Affiliation Institutionnelle <span>:</span></label> <b>${thd.affiliation}</b>
							</div>
						</div>
						</div>
							<div class="col-sm-2 col-lg-2 col-md-2">
								<input class="btn btn-info myBtnDetail"
									style="margin-bottom: 10px;"
									onclick="location.href = 'teacherForm?role=${std.pseudo}';"
									value="Modifier" /> <input class="btn btn-danger myBtnDetail"
									onclick="location.href = 'teacherList';" value="Retour" />
							</div>
					</c:if>
					<c:set scope="session" var="indic" value="${indicateurRecu}"></c:set>
					<c:if test="${indic!=null}">
						<div class="menuDetail col-lg-offset-2 col-md-offset-2 col-lg-8 col-md-8 col-sm-8">
						<div
							class="detailHeading col-lg-offset-2 col-sm-offset-2 col-md-offset-2">
							<h1>D&eacute;tail de l'indicateur</h1>
						</div>
						<div class="bodyDetail">
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Numero <span>:</span></label> <b>${indic.numero}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>libelle <span>:</span></label> <b>${indic.libelle}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Objectif <span>:</span></label> <b>${indic.objectif}</b>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label>Sigle <span>:</span></label> <b>${indic.sigle}</b>
							</div>
						</div>
						</div>
						<div class="col-sm-2 col-lg-2 col-md-2">
							<input class="btn btn-info myBtnDetail"
								style="margin-bottom: 10px;"
								onclick="location.href = 'indicateurForm?role=${std.pseudo}';"
								value="Modifier" /> <input class="btn btn-danger myBtnDetail"
								onclick="location.href = 'indicateurList';" value="Retour" />
						</div>
						
					</c:if>
					<c:set scope="session" var="std" value="${etudiantRecu}"></c:set>
					<c:if test="${std!=null}">
						<div
							class="detailHeading col-lg-offset-2 col-sm-offset-2 col-md-offset-2">
							<h2>Information de L'&eacute;tudiant</h2>
						</div>
						<div class="menuDetail col-lg-offset-2 col-md-offset-2 col-lg-8 col-md-8 col-sm-8">
							<div class="headerDetail">
								<div class="col-lg-9 col-md-9 col-sm-9">
									<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Numéro d'&eacute;tudiant <span>:</span></label> <b>${std.studentNumber}</b>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Pr&eacute;nom <span>:</span></label> <b>${std.firstName}</b>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12">
										<label>Nom <span>:</span></label> <b>${std.lastName}</b>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12">
										<label>niveau d'&eacute;tude <span>:</span></label> <b>${std.level}</b>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3" id="formeGauche">
									<img src="<c:url value="/image?imageId=${std.idStudent}"/>"
										class="photoDetail" />
								</div>
							</div>
						<div class="bodyDetail">
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Date de Naissance <span>:</span></label> <b>${std.birthday}</b>
							</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Lieu de naissance <span>:</span></label> <b>${std.countryOfBirth}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Nationalit&eacute; <span>:</span></label> <b>${std.nationality}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Adresse <span>:</span></label> <b>${std.adress}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Email <span>:</span></label> <b>${std.mail}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>T&eacute;l&eacute;phone <span>:</span></label> <b>${std.phone}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Boite postale <span>:</span></label> <b>${std.bp}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>S&eacute;xe <span>:</span></label>
							<c:choose>
								<c:when test="${std.gender==0}">
									<b>Feminin</b>
								</c:when>
								<c:when test="${std.gender==1}">
									<b>Masculin</b>
								</c:when>
							</c:choose>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Programme <span>:</span></label> <b>${std.program}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Semestre <span>:</span></label> <b>${std.semester}</b>
						</div>
						<hr>
						<h2>Personne à contacter</h2>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Pr&eacute;nom <span>:</span></label> <b>${std.firstNamePAC}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Nom <span>:</span></label> <b>${std.lastNamePAC}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>T&eacute;l&eacute;phone <span>:</span></label> <b>${std.phonePAC}</b>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<label>Adresse <span>:</span></label> <b>${std.adressPAC}</b>
						</div>
						</div>
						</div>
						<div class="col-sm-2 col-lg-2 col-md-2">
							<input class="btn btn-info myBtnDetail"
								style="margin-bottom: 10px;"
								onclick="location.href = 'studentForm?role=${std.pseudo}';"
								value="Modifier" /> <input class="btn btn-danger myBtnDetail"
								onclick="location.href = 'studentHome';" value="Retour" />
						</div>
					</c:if>
				</div>
				<div class="fix scroll_to_top">
					<a href="#scroll_top" class="floatright">Remonter </a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-12 col-md-12 col-xs-12 footerContent">
		<c:import url="../Footer.jsp"></c:import>
	</div>
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
