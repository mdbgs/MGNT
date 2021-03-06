<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<c:import url="../Header.jsp"></c:import>
<head>
<meta charset="utf-8" />
<title>Formulaire Formation</title>
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
									<h2>Formation</h2>
								</div>
								<form method="post" action="formationForm" class="myForm">
									<h3>Information</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Titre <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="title"
													name="title" value="${param.title}" placeholder="titre" />
											</div>
											<span class="erreur">${errors['title']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Position <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="position"
													name="position" value="${param.position}"
													placeholder="position" />
											</div>
											<span class="erreur">${errors['position']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Institution <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="institution"
													name="institution" value="${param.institution}"
													placeholder="institution" />
											</div>
											<span class="erreur">${errors['institution']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Contenu <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="contenu"
													name="contenu" value="${param.contenu}"
													placeholder="contenu" />
											</div>
											<span class="erreur">${errors['contenu']}</span>
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
