<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body id="scroll_top">
	<section id="header_areaBis"> </section>
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
								<div class="panel-heading">Liste des Partenaires</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Nom Partenaire</th>
													<th>Type</th>
													<th>Adresse</th>
													<th>Téléphone</th>
													<th>Détails</th>
												</tr>
											</thead>
											<tbody >
												<c:forEach items="${partnerRecu.partnerList}" var="partenaire">
														<tr>
														<td><c:out value="${partenaire.nom}"></c:out></td>
														<td><c:out value="${partenaire.type}"></c:out></td>
														<td><c:out value="${partenaire.adresse}"></c:out></td>
														<td><c:out value="${partenaire.telephone}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
														</tr>
												</c:forEach>		
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<input class="btn btn-info myBtnDetail"
					onclick="location.href = 'partnerForm';" value="Ajouter" />
				<div class="fix scroll_to_top">
					<a href="#scroll_top" class="floatright">Remonter </a>
				</div>
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
