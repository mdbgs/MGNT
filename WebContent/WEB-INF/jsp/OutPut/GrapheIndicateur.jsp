<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SE.Ceamitic</title>
<c:import url="../Header.jsp"></c:import>
</head>
<body id="scroll_top">
	<div id="overlay"></div>
	<div id="cadre" class="row">
		<div id="frame">
			<div id="headerFrame">
				<h2>Détails de l'activité</h2>
			</div>
			<div class="fix home_main_content" id="bodyFrame">
				<c:set var="myID" value="" target="Activite" scope="page"></c:set>
				<div class="single_latest_postBis">
					<label class="labelActivite">Composant</label>
					<p id="composant">
						<c:out value="${myID}"></c:out>
					</p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Objectif</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Résultat attendu</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Libellé</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Période</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Echéance prévu</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Echéance réaliser</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Statut</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Nature de l'indicateur</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Libellé de l'indicateur</label>
					<p id=""></p>
				</div>
				<div class="single_latest_postBis">
					<label class="labelActivite">Réference</label>
					<p id=""></p>
				</div>
				<input id="quitterActivite" class="btn btn-danger" type="submit"
					value="quitter" />
			</div>
		</div>
	</div>
	<!-- First image in the header -->
	<c:import url="../sidebar.jsp"></c:import>
	<div
		class="main-content col-sm-offset-1 col-md-offset-1 col-xs-offset-1 col-sm-10 col-md-10 col-xs-10">
		<c:import url="../MenuBar.jsp"></c:import>
		<div class="content">
			<div class="fix main_content_area">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-heading">Graphe des indicateurs</div>
									<div class="panel-body">
										<div class="table-responsive">
											<div class="panel panel-default">
												<div class="panel-body">
													<div id="morris-area-chart"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="fix scroll_to_top">
						<a href="#scroll_top" class="floatright">Remonter </a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="../Footer.jsp"></c:import>
</body>
</html>
