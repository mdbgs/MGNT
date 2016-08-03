<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../Header.jsp"></c:import>
</head>
<body id="scroll_top">
	<c:import url="../sidebar.jsp"></c:import>
	<div class="main-content col-sm-offset-1 col-md-offset-1 col-xs-offset-1 col-sm-10 col-md-10 col-xs-10">
		<c:import url="../MenuBar.jsp"></c:import>
		<div class="content">
			<div class="fix main_content_area">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire des activités</h2>
								</div>
								<form method="post" action="activityForm" class="myForm">
									<h3>Activité</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Libelle</label>
											</div>
											<div class="row">
												<input class="form-control" id="libelle"
													name="libelle" value="${param.libelle}"
													placeholder="libelle" />
											</div>
											<span class="erreur">${errors['libelle']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Période</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="periode"
													name="periode" value="${param.periode}"
													placeholder="periode" />
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
													name="echeancePrevu" value="${param.echeancePrevu}"
													placeholder="echeance prevu" />
											</div>
											<span class="erreur">${errors['echeancePrevu']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row ">
												<label>Echéance Réalisé</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="echeanceRealise"
													name="echeanceRealise" value="${param.echeanceRealise}"
													placeholder="écheance réalisé" />
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
													name="statutActivite" value="${param.statutActivite}"
													placeholder="Statut de l'activité" />
											</div>
											<span class="erreur">${errors['statutActivite']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nature de l'indicateur</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="natureIndicateur" name="natureIndicateur"
													value="${param.natureIndicateur}"
													placeholder="Nature de l'indicateur" />
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
													value="${param.libelleIndicateur}"
													placeholder="libelle de l'indicateur" />
											</div>
											<span class="erreur">${errors['libelleIndicateur']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Référence tableau de saisie</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="referenceTabSaisie" name="referenceTabSaisie"
													value="${param.referenceTabSaisie}"
													placeholder="Référence tableau de saisie" />
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
												<input class="form-control" type="text"
													id="pieceJustificatif" name="pieceJustificatif"
													value="${param.pieceJustificatif}"
													placeholder="Pièce justificatif" />
											</div>
											<span class="erreur">${errors['pieceJustificatif']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Composant</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="composant"
													name="composant" value="${param.composant}"
													placeholder="composant" />
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
													name="objectif" value="${param.objectif}"
													placeholder="objectif" />
											</div>
											<span class="erreur">${errors['objectif']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Résultat Attendu</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="resultatAttendu"
													name="resultatAttendu" value="${param.resultatAttendu}"
													placeholder="resultat attendu" />
											</div>
											<span class="erreur">${errors['resultatAttendu']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>D&eacute;signer les responsables de Saisie</label>
											</div>
											<div class="row">
												<select id="level" multiple="multiple" size="5"
													<input class="form-control" type="text" name="level" />>
													<option disabled>Choisir le(s) responsable(s)</option>
													<c:forEach items="${responsableRecu.responsableList}" var="responsable">
															<option class="checkbox checkbox-success"/><input type="checkbox"/> ${responsable.pseudo}</option>
													</c:forEach>
												</select>
											</div>
											<span class="erreur">${errors['objectif']}</span>
										</div>
									</div>

									<div class="row myBtn">
										<input class="btn btn-danger " type="reset" value="Annuler" />
										<input class="btn btn-info " type="submit" value="Valider" />

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
	</div>
	<div class="col-sm-12 col-md-12 col-xs-12 footerContent">
		<c:import url="../Footer.jsp"></c:import>
	</div>
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
