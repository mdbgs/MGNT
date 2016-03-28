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
<title>Formulaire des Reunions</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
<link rel="stylesheet" href="Assets/css/style.css" media="screen" />
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
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
			<c:import url="entete.jsp"></c:import>
						<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h1>
										Formulaire des reunions
										</h2>
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
													name="object" value="${param.object}"
													placeholder="objet" />
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
												<input class="form-control dateShow" type="text" id="dateDeb"
													name="dateDeb" value="${param.dateDeb}" placeholder="Date debut" />
											</div>
											<span class="erreur">${errors['dateDeb']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Date de fin <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text" id="dateFin"
													name="dateFin" value="${param.dateFin}" placeholder="Date fin" />
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
												<input class="form-control" type="text" id="participNumber" name="participNumber"
													value="${param.participNumber}" placeholder="nombre de participant" />
											</div>
											<span class="erreur">${errors['participNumber']}</span>
										</div>
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Lieu</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="lieu" name="lieu"
													value="${param.lieu}" placeholder="lieu" />
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
												<input class="form-control" type="text" id="compteRendu" name="compteRendu"
													value="${param.compteRendu}" placeholder="compte rendu" />
											</div>
											<span class="erreur">${errors['compteRendu']}</span>
										</div>
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Pièces Justificatifs</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="pieceJustificatif" name="pieceJustificatif"
													value="${param.pieceJustificatif}" placeholder="pièces justificatfs" />
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
<<<<<<< HEAD
	<%@ include file="piedsPage.jsp" %>
	<script src="http://code.jquery.com/jquery.js"></script>
=======
	<section id="footer_top_area">
		<div class="fix footer_top center">
			<div class="fix footer_top_container">
				<div>
					<ul class="col-xs-12">
						<li class="col-xs-2 myFooter"><a href=""><span>A
									propos</span></a></li>
						<li class="col-xs-2 myFooter"><a href=""><span>Nous
									contacter</span></a></li>
						<li class="col-xs-2 myFooter"><a href=""><span>Aide</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section id="footer_bottom_area">
		<div class="fix footer_bottom center">
			<div class="fix copyright floatleft">
				<p>&#169 2015 CEAMITIC</p>
			</div>
			<div class="fix footer_bottom_text floatright">
				<p>
					<a href="http://www.ceamitic.sn" title="Site web du centre"
						target="_blank">www.ceamitic.sn</a>
				</p>
			</div>
		</div>
	</section>
>>>>>>> branch 'master' of https://github.com/mdbgs/MGNT.git
	<!-- Jessor slider Start-->
	<script src="Assets/plugins/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="Assets/js/bootstrap.min.js"></script>
    <script src="Assets/plugins/jasny/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript"
		src="Assets/plugins/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.core.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.utils.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.slider.js"></script>
	<!-- JS -->
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<script type="text/javascript" src="Assets/js/myScript.js"></script>
	<script src="Assets/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="Assets/plugins/dataTables/dataTables.bootstrap.js"></script>
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
