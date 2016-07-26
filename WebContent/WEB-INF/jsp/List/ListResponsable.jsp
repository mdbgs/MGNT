<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%
	User user = (User) request.getSession().getAttribute("user");
	if (user == null) {
		response.sendRedirect("connection");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../Header.jsp"></c:import>
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
													<c:forEach items="${responsableRecu.responsableList}"
														var="responsable">
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
	</div>
	<div class="col-sm-12 col-md-12 col-xs-12 footerContent">
		<c:import url="../Footer.jsp"></c:import>
	</div>
</body>
<script>
	$(document).ready(function() {
		$('#myDataTable').dataTable();
	});
</script>
</html>
