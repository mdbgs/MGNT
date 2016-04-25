<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body id="scroll_top">
	<section id="header_areaBis"> </section>
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
	<section id="header_bottom_area"></section>
	<section id="content_area">
	<div class="content ">			
		<c:import url="entete.jsp"></c:import>
		<div class="fix main_content_area row ">
			<div class="fix allSearch"></div>
			<div class="fix single_sidebar">
				<div class="inner">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">Tableau des Activités</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Libell&eacute</th>
													<th>P&eacuteriode</th>
													<th>Ech&eacuteance Pr&eacutevu</th>
													<th>Statut</th>
													<th>D&eacutetails</th>
												</tr>
											</thead>
											<tbody id="allAct">
												<c:forEach items="${activiteRecu.activeList}" var="activit">
													<tr>
														<td><c:out value="${activit.libelle}"></c:out></td>
														<td><c:out value="${activit.periode}"></c:out></td>
														<td><c:out value="${activit.echeancePrevu}"></c:out></td>
														<td><c:out value="${activit.statutActivite}"></c:out></td>
														<td><button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?activiteSending=${activit.IDactivite}';" ">
															<img alt="action" src="Assets/images/icons/editer.jpg">
														<span>Voir les détails</span>
															</button>

														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tbody id="parAct">
												<c:forEach items="${activiteRecu.activeList}" var="activit">
													<c:if test="${activit.composant == 'Partenariat'}">
														<tr>
															<td><c:out value="${activit.libelle}"></c:out></td>
															<td><c:out value="${activit.periode}"></c:out></td>
															<td><c:out value="${activit.echeancePrevu}"></c:out></td>
															<td><c:out value="${activit.statutActivite}"></c:out></td>
															<td><button type="submit" class=" btn btn-info"
																	id="detailBtn"
																onclick="location.href = 'detail?activiteSending=${activit.IDactivite}';" >
															<img alt="action" src="Assets/images/icons/editer.jpg">
														<span>Voir les détails</span></button>

															</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
											<tbody id="appAct">
												<c:forEach items="${activiteRecu.activeList}" var="activit">
													<c:if
														test="${activit.composant == 'Excellence en apprentissage'}">
														<tr>
															<td><c:out value="${activit.libelle}"></c:out></td>
															<td><c:out value="${activit.periode}"></c:out></td>
															<td><c:out value="${activit.echeancePrevu}"></c:out></td>
															<td><c:out value="${activit.statutActivite}"></c:out></td>
															<td>
																<button type="submit" class=" btn btn-info"
																		id="detailBtn"
																onclick="location.href = 'detail?activiteSending=${activit.IDactivite}';" >
																<img alt="action" src="Assets/images/icons/editer.jpg">
														<span>Voir les détails</span></button>
															</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
											<tbody id="recAct">
												<c:forEach items="${activiteRecu.activeList}" var="activit">
													<c:if
														test="${activit.composant == 'Excellence dans la recherche'}">
														<tr>
															<td><c:out value="${activit.libelle}"></c:out></td>
															<td><c:out value="${activit.periode}"></c:out></td>
															<td><c:out value="${activit.echeancePrevu}"></c:out></td>
															<td><c:out value="${activit.statutActivite}"></c:out></td>
															<td><button type="submit" class=" btn btn-info"
																	id="detailBtn"
																onclick="location.href = 'detail?activiteSending=${activit.IDactivite}';" >
															<img alt="action" src="Assets/images/icons/editer.jpg">
														<span>Voir les détails</span></button>
															</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
											<tbody id="gouvAct">
												<c:forEach items="${activiteRecu.activeList}" var="activit">
													<c:if
														test="${activit.composant == 'Gestion et Gouvernance'}">
														<tr>
															<td><c:out value="${activit.libelle}"></c:out></td>
															<td><c:out value="${activit.periode}"></c:out></td>
															<td><c:out value="${activit.echeancePrevu}"></c:out></td>
															<td><c:out value="${activit.statutActivite}"></c:out></td>
															<td><button type="submit" class=" btn btn-info"
																	id="detailBtn"
																onclick="location.href = 'detail?activiteSending=${activit.IDactivite}';" >
															<img alt="action" src="Assets/images/icons/editer.jpg">
														<span>Voir les détails</span></button>

															</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<input class="btn btn-info myBtnDetail" onclick="location.href = 'activityForm';" value="Ajouter" />
				<div class="fix scroll_to_top">
					<a href="#scroll_top" class="floatright">Remonter </a>
				</div>
			</div>
		</div>
	</section>
		<c:import url="piedsPage.jsp"></c:import>
	<script>
		$(document).ready(function() {
			$('#myDataTable').dataTable();
		});
		$(function(){
			$("#overlay").click(function(){
				$("#cadre").fadeOut();
				$("#overlay").fadeOut();
			});
		});
	</script>

</body>
</html>
