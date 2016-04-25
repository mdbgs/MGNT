<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Formulaire des activités</title>
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content center">
			<c:import url="entete.jsp"></c:import>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire des programmes CEA</h2>
								</div>
								<form method="post" action="programmeFormulaire" class="myForm">
									<h3>Programme</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Titre</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="title"
													name="title" value="${param.title}" placeholder="titre" />
											</div>
											<span class="erreur">${errors['title']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Niveau</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="level"
													name="level" value="${param.level}" placeholder="niveau" />
											</div>
											<span class="erreur">${errors['level']}</span>
										</div>
									</div>
									<div class="row ">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Type d'accréditation</label>
											</div>
											<div class="row date">
												<input class="form-control " type="text"
													id="type_Accreditation" name="type_Accreditation"
													value="${param.type_Accreditation}"
													placeholder="type d'accréditation" />
											</div>
											<span class="erreur">${errors['type_Accreditation']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row ">
												<label>Référence d'accréditation</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="ref_Accreditation" name="ref_Accreditation"
													value="${param.ref_Accreditation}"
													placeholder="Référence d'accréditation" />
											</div>
											<span class="erreur">${errors['ref_Accreditation']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Nom de l'agence d'accréditation</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="nom_Agence_ACC"
													name="nom_Agence_ACC" value="${param.nom_Agence_ACC}"
													placeholder="nom agence accréditation" />
											</div>
											<span class="erreur">${errors['nom_Agence_ACC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Email de l'agence</label>
											</div>
											<div class="row">
												<input class="form-control" type="email" id="mail_Agence"
													name="mail_Agence" value="${param.mail_Agence}"
													placeholder="Email" />
											</div>
											<span class="erreur">${errors['mail_Agence']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Téléphone de l'agence</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="tel_Agence"
													name="tel_Agence" value="${param.tel_Agence}"
													placeholder="téléphone" />
											</div>
											<span class="erreur">${errors['tel_Agence']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Boite postale de l'agence</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="bp_Agence"
													name="bp_Agence" value="${param.bp_Agence}"
													placeholder="boite postale" />
											</div>
											<span class="erreur">${errors['bp_Agence']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Date d'accréditation</label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text"
													id="date_Acc" name="date_Acc" value="${param.date_Acc}"
													placeholder="Date" />
											</div>
											<span class="erreur">${errors['date_Acc']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Date d'expiration</label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text"
													id="date_Expiration" name="date_Expiration"
													value="${param.date_Expiration}" placeholder="Date" />
											</div>
											<span class="erreur">${errors['date_Expiration']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Type</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="type"
													name="type" value="${param.type}" placeholder="type" />
											</div>
											<span class="erreur">${errors['type']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Statut</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="statut"
													name="statut" value="${param.statut}" placeholder="statut" />
											</div>
											<span class="erreur">${errors['statut']}</span>
										</div>
									</div>

									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Offert par</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="offert_par"
													name="offert_par" value="${param.offert_par}"
													placeholder="offert par" />
											</div>
											<span class="erreur">${errors['offert_par']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Date de création</label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text"
													id="date_creation" name="date_creation"
													value="${param.date_creation}" placeholder="Date" />
											</div>
											<span class="erreur">${errors['date_creation']}</span>
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