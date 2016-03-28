<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire Enseignant</title>
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
									<h2>Formulaire d'inscription Responsable</h2>
								</div>
								<form method="post" action="responsable" class="myForm">
									<h3>Coordonnées Responsable</h3>
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
												<label>Prénom<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="firstName"
													name="firstName" value="${param.firstName}"
													placeholder="Prénom" />
											</div>
											<span class="erreur">${errors['firstName']}</span>
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
											<div class="row ">
												<label>Sexe</label>
											</div>
											<div class="row">
												<select id="sexe"
													<input class="form-control" type="text" name="gender" value=getValueOption(gender) />>
													<option value="" disabled selected>sexe</option>
													<option value="0">Masculin</option>
													<option value="1">Féminin</option>
												</select>
											</div>
											<span class="erreur">${errors['gender']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Téléphone <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phone"
													name="phone" value="${param.phone}" placeholder="Téléphone" />
											</div>
											<span class="erreur">${errors['phone']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Type</label>
											</div>
											<div class="row">
												<select id="type"
													<input class="form-control" type="text" name="type" value="${param.type}" />>
													<option value="" disabled selected>sélectionner</option>
													<option>Responsable suivi-évaluation</option>
													<option>Responsable de controle</option>
													<option>Responsable de saisie</option>
													<option>Coordonnateur</option>
													<option>Coordonnateur adjoint</option>
												</select>
											</div>
											<span class="erreur">${errors['type']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Poste <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="post"
													name="post" value="${param.post}" placeholder="poste" />
											</div>
											<span class="erreur">${errors['post']}</span>
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
		$(function() {
			$("#overlay").click(function() {
				$("#cadre").fadeOut();
				$("#overlay").fadeOut();
			});
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
