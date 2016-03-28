<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire des Reunions</title>
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
									<h2>Formulaire des reunions</h2>
								</div>
								<form method="post" action="reunion" class="myForm">
									<h3>Information</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Type <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="type"
													name="type" value="${param.type}" placeholder="type" />
											</div>
											<span class="erreur">${errors['type']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Objet<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="object"
													name="object" value="${param.object}" placeholder="objet" />
											</div>
											<span class="erreur">${errors['object']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Date de début <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text"
													id="dateDeb" name="dateDeb" value="${param.dateDeb}"
													placeholder="Date debut" />
											</div>
											<span class="erreur">${errors['dateDeb']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Date de fin <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text"
													id="dateFin" name="dateFin" value="${param.dateFin}"
													placeholder="Date fin" />
											</div>
											<span class="erreur">${errors['dateFin']}</span>
										</div>
									</div>
									<div class="row">
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nombre de participants <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="participNumber"
													name="participNumber" value="${param.participNumber}"
													placeholder="nombre de participant" />
											</div>
											<span class="erreur">${errors['participNumber']}</span>
										</div>
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Lieu</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="lieu"
													name="lieu" value="${param.lieu}" placeholder="lieu" />
											</div>
											<span class="erreur">${errors['lieu']}</span>
										</div>
									</div>
									<div class="row">
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Compte Rendu <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="compteRendu"
													name="compteRendu" value="${param.compteRendu}"
													placeholder="compte rendu" />
											</div>
											<span class="erreur">${errors['compteRendu']}</span>
										</div>
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Pièces Justificatifs</label>
											</div>
											<div class="row">
												<input class="form-control" type="text"
													id="pieceJustificatif" name="pieceJustificatif"
													value="${param.pieceJustificatif}"
													placeholder="pièces justificatfs" />
											</div>
											<span class="erreur">${errors['pieceJustificatif']}</span>
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
