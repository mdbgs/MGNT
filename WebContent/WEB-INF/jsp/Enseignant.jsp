<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Formulaire Enseignant</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
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
	<section id="header_areaBis"> </section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content ">
				<%@ include file="entete.jsp" %>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h1>
										Formulaire d'inscription Enseignant
										</h2>
								</div>
								<form method="post" action="enseignant" class="myForm">
									<h3>Coordonnées Enseignant</h3>
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
													name="firstName" value="${param.firstName}" placeholder="Prénom" />
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
												<label>Niveau<span>*</span></label>
											</div>
											<div class="row">
												<select id="level"
													<input class="form-control" type="text" name="level" value="${param.level}" />>
													<option value="" disabled select>Choisir le niveau</option>
													<option>Master 1</option>
													<option>Master 2</option>
													<option>Thèse</option>
												</select>
											</div>
											<span class="erreur">${errors['level']}</span>
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
													<option value="" disabled select>sexe</option>
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
													name="nationality" value="${param.nationality}" placeholder="Nationalité" />
											</div>
											<span class="erreur">${errors['nationality']}</span>
										</div>
									</div>
									
										
								<div class="row">
											<div class="formDroite col-xs-5">
											<div class="row">
												<label>Boite Postale<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="bp" name="bp"
													value="${param.bp}" placeholder="Boite postale" />
											</div>
											<span class="erreur">${errors['bp']}</span>
										</div>
									
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Affiliation Institutionnelle<span>*</span></label>
											</div>
											<div class="row">
												<select id="institutionAffiliation"
													<input class="form-control" type="text" name="institutionAffiliation" value="${param.institutionAffiliation}" />>
													<option value="" disabled select>Choix</option>
													<option>CEA</option>
													<option>IP</option>
													<option>REG</option>
												</select>
											</div>
											<span class="erreur">${errors['institutionAffiliation']}</span>
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
	<%@ include file="piedsPage.jsp" %>
	
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
