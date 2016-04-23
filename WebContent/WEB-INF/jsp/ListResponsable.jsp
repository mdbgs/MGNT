<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<div class="panel-heading">Liste des responsables</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Nom</th>
													<th>Prénom</th>
													<th>Telephone</th>
													<th>Adresse</th>
													<th>Sexe</th>
													<th>Email</th>
													<th>Poste</th>
													<th>Type</th>
													
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${responsableRecu.responsableList}" var="responsable">
													<tr>
														<td><c:out value="${responsable.lastName}"></c:out></td>
														<td><c:out value="${responsable.firstName}"></c:out></td>
														<td><c:out value="${responsable.mail}"></c:out></td>
														<td><c:out value="${responsable.adress}"></c:out></td>
														<td><c:out value="${responsable.gender}"></c:out></td>
														<td><c:out value="${responsable.phone}"></c:out></td>
														<td><c:out value="${responsable.type}"></c:out></td>
														<td><c:out value="${responsable.post}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?responsableSending=${responsable.idResponsable}';">
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
					onclick="location.href = 'responsableForm';" value="Ajouter" />
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
	</script>
</body>
</html>
