<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire des Stages</title>
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content centr">
			<c:import url="entete.jsp"></c:import>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire des Stages</h2>
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
												<input class="form-control dateShow" type="text"
													id="dateDeb" name="dateDeb" value="${param.dateDeb}"
													placeholder="Date" />
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
												<input class="form-control dateShow" type="text"
													id="dateFin" name="dateFin" value="${param.dateFin}"
													placeholder="Date" />
											</div>
											<span class="erreur">${errors['dateFin']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Certificat <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="certificat"
													name="certificat" value="${param.certificat}"
													placeholder="certificat" />
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
													name="institutionName" value="${param.institutionName}"
													placeholder="nom de l'institution" />
											</div>
											<span class="erreur">${errors['institutionName']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Statut de l'institution</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="institutionStatut" name="institutionStatut"
													value="${param.institutionStatut}"
													placeholder="statut de l'institution" />
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
												<input class="form-control" type="text"
													id="diectorFirstName" name="diectorFirstName"
													value="${param.diectorFirstName}"
													placeholder="prénom du directeur" />
											</div>
											<span class="erreur">${errors['diectorFirstName']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nom du directeur</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="directorLastName" name="directorLastName"
													value="${param.directorLastName}"
													placeholder="nom du directeur" />
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
													name="directorphone" value="${param.directorphone}"
													placeholder="téléphone" />
											</div>
											<span class="erreur">${errors['directorphone']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Email</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="directorEmail"
													name="directorEmail" value="${param.directorEmail}"
													placeholder="email" />
											</div>
											<span class="erreur">${errors['directorEmail']}</span>
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
	</section>
	<c:import url="piedsPage.jsp"></c:import>
</body>
<script type="text/javascript">
	$(function getValueOption(valueOption) {
		var selectedanswer = document.getElementById(valueOption).selectedIndex;
		return document.getElementsByTagName("option")[selectedanswer].value;
	});
</script>
</html>
