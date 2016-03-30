<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire Etudiant</title>
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content ">
			<c:import url="entete.jsp"></c:import>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire d'inscription Etudiant</h2>
								</div>
								<form method="post" action="etudiant" class="myForm">
									<h3>Coordonnées Etudiant</h3>
									<div class="row">
										<div class="fileupload fileupload-new"
											data-provides="fileupload">
											<div class="fileupload-preview thumbnail"
												style="width: 200px; height: 150px;"></div>
											<div>
												<span class="btn btn-file btn-success"><span
													class="fileupload-new">Choisir photo</span><span
													class="fileupload-exists">Changer</span><input type="file"
													name="myFile" /></span> <span href="#"
													class="btn btn-danger fileupload-exists"
													data-dismiss="fileupload">Effacer</span>
											</div>
										</div>
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
									<div class="row ">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Date de naissance <span>*</span></label>
											</div>
											<div class="row date">
												<input class="form-control dateShow" type="text"
													id="birthday" name="birthday" value="${param.birthday}"
													placeholder="Date de naissance" />
											</div>
											<span class="erreur">${errors['birthday']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row ">
												<label>Lieu de naissance<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="countryOfBirth"
													name="countryOfBirth" value="${param.countryOfBirth}"
													placeholder="Lieu de naissance" />
											</div>
											<span class="erreur">${errors['countryOfBirth']}</span>
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
												<label>Numéro Etudiant <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="studentNumber"
													name="studentNumber" value="${param.studentNumber}"
													placeholder="Ex: P2612" />
											</div>
											<span class="erreur">${errors['studentNumber']}</span>
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
												<label>Sexe<span>*</span></label>
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
												<label>Nationalité <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="nationality"
													name="nationality" value="${param.nationality}"
													placeholder="Nationalité" />
											</div>
											<span class="erreur">${errors['nationality']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Niveau<span>*</span></label>
											</div>
											<div class="row">
												<select id="level"
													<input class="form-control" type="text" name="level" value="${param.level}" />>
													<option value="" disabled selected>Choisir le
														niveau</option>
													<option>Master 1</option>
													<option>Master 2</option>
													<option>1er Année</option>
													<option>2ième Année</option>
													<option>3ième Année</option>
													<option>Maitrîse</option>
													<option>Doctorat</option>
												</select>
											</div>
											<span class="erreur">${errors['level']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Programme<span>*</span></label>
											</div>
											<div class="row">
												<select id="program"
													<input class="form-control" type="text" name="program" value="${param.program}" />>
													<option value="" disabled selected>Choisir le
														programme</option>
													<option>M2ITIC/FOAD</option>
													<option>Algébre Appliquée</option>
													<option>DIETEL</option>
													<option>Energie Renouvelable</option>
													<option>Informatique</option>
													<option>MaDSI</option>
													<option>MAI</option>
													<option>MAIF</option>
													<option>MaRT</option>
													<option>Maths Appliquée</option>
													<option>MMAF</option>
													<option>MMSCI</option>
													<option>MMSTOCH</option>
													<option>Physique Appliquée</option>
													<option>Physique A Statistique Appliquée</option>
												</select>
											</div>
											<span class="erreur">${errors['program']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Semestre<span>*</span></label>
											</div>
											<div class="row">
												<select id="semester"
													<input class="form-control" type="text" name="semester" value="${param.semester}" />>
													<option value="" disabled selected>choisir le
														semestre</option>
													<option>Semestre 1</option>
													<option>Semestre 2</option>
													<option>Autre</option>
												</select>
											</div>
											<span class="erreur">${errors['semester']}</span>
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
									<h3>Personne à contacter</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label> Nom </label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="lastNamePAC"
													name="lastNamePAC" value="${param.lastNamePAC}"
													placeholder="Nom" />
											</div>
											<span class="erreur">${errors['lastNamePAC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label> Prenom</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="firstNamePAC"
													name="firstNamePAC" value="${param.firstNamePAC}"
													placeholder="Prénom" />
											</div>
											<span class="erreur">${errors['firstNamePAC']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label> Telephone</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phonePAC"
													name="phonePAC" value="${param.phonePAC}"
													placeholder="Telephone" />
											</div>
											<span class="erreur">${errors['phonePAC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label> Adresse</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="adressPAC"
													name="adressPAC" value="${param.adressPAC}"
													placeholder="Adresse" />
											</div>
											<span class="erreur">${errors['adressPAC']}</span>
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
	<%@ include file="piedsPage.jsp"%>
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
