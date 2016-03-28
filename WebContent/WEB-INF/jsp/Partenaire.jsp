<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire Partenaire</title>
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
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire d'inscription Partenaire</h2>
								</div>
								<form method="post" action="partenaire" class="myForm">
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
													name="acc_Title" value="${param.acc_Title}"
													placeholder="titre de l'accord" />
											</div>
											<span class="erreur">${errors['acc_Title']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Domaine de collaboration</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="collaboration_D"
													name="collaboration_D" value="${param.collaboration_D}"
													placeholder="domaine de collaboration" />
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
													name="signDate" value="${param.signDate}"
													placeholder="date de signature" />
											</div>
											<span class="erreur">${errors['signDate']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Expiration de l'accord</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="acc_Expiration"
													name="acc_Expiration" value="${param.acc_Expiration}"
													placeholder="expiration de l'accord" />
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
													name="att_Result" value="${param.att_Result}"
													placeholder="résultat attendu" />
											</div>
											<span class="erreur">${errors['att_Result']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Projet conjoint</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="conjointProject"
													name="conjointProject" value="${param.conjointProject}"
													placeholder="projet conjoint" />
											</div>
											<span class="erreur">${errors['conjointProject']}</span>
										</div>
									</div>

									<div class="row myBtn">
										<input class="btn btn-danger " type="reset" value="Annuler" />
										<input class="btn btn-info " type="submit" value="Inscription" />

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
