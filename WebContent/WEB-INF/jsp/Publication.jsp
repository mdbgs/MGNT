<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire des publications</title>
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content cent">
			<c:import url="entete.jsp"></c:import>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Publication</h2>
								</div>
								<form method="post" action="publicationFormulaire" enctype="multipart/form-data" class="myForm" >
									<h3>Information</h3>
									
									<div class="row">
										<div class="col-xs-5" id="formDroite">
											<div class="row ">
												<label>Titre <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="title"
													name="title" value="${param.title}" placeholder="titre" />
											</div>
											<span class="erreur">${errors['title']}</span>
										</div>
										<div class="col-xs-5" id="formgauche">
											<div class="row ">
												<label>Date de publication <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control dateShow" type="text"
													id="datePub" name="datePub" value="${param.datePub}"
													placeholder="date" />
											</div>
											<span class="erreur">${errors['datePub']}</span>
										</div>
									</div>
									<div class="row">
										<div class="formGauche col-xs-5">
											<div class="row">
												<label>Nom du journal <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="nomJournal"
													name="nomJournal" value="${param.nomJournal}"
													placeholder="nom" />
											</div>
											<span class="erreur">${errors['nomJournal']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Auteur <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="author"
													name="author" value="${param.author}" placeholder="auteur" />
											</div>
											<span class="erreur">${errors['author']}</span>
										</div>
									</div>
									<div class="row">
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Facteur d'impact</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="impactFactor"
													name="impactFactor" value="${param.impactFactor}"
													placeholder="Facteur d'impact" />
											</div>
											<span class="erreur">${errors['impactFactor']}</span>
										<div class="formGauche col-xs-5">
											<div class="row ">
												<label>Type <span>*</span></label>
											</div>
											<div class="row">
												<select id="montype" name="montype">
													<option >Mémoire</option>
													<option >Thèse</option>
													<option >Article</option>
												</select>
											</div>
											<span class="erreur">${errors['type']}</span>
										</div>
										</div>
										
										
<!-- 										<div class="formDroite col-xs-5"> -->
<!-- 											<div class="row"> -->
<!-- 												<label>Responsable</label> -->
<!-- 											</div> -->
<!-- 											<div class="row"> -->
<!-- 												<select id="resp" -->
<!-- 													<input class="form-control" type="text" name="resp" value=getValueOption(resp) />> -->
<!-- 													<option value="" disabled selected>Choisir le responsable</option> -->
<!-- 													<option value="0">Responsable suivi</option> -->
<!-- 													<option value="1">Responsable saisi</option> -->
<!-- 													<option value="2">Responsable controle</option> -->
<!-- 												</select> -->
<!-- 											</div> -->
<%-- 											<span class="erreur">${errors['resp']}</span> --%>
<!-- 										</div> -->
                                        <div class="formDroite col-xs-5">
											<div class="row">
												<label>Votre publication</label>
											</div>
											<div class="row">
												<input type="file" id="fichier" name="fichier">
											</div>
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
