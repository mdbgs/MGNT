<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
								<div class="panel-heading">Liste des publications</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Responsable publication</th>
													<th>titre</th>
													<th>Date publication</th>
													<th>Nom journal</th>
													<th>Détails</th>
												</tr>
											</thead>
											<tbody id="all">
												<c:forEach items="${publicationRecu.publicationList}" var="publication">
													<tr>
														<td><c:out value="${publication.idResponsable}"></c:out></td>
														<td><c:out value="${publication.title}"></c:out></td>
														<td><c:out value="${publication.datePublication}"></c:out></td>
														<td><c:out value="${publication.nameJournal}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?publicationSending=${publication.idPublication}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tbody id="these">
												<c:forEach items="${publicationRecu.publicationList}" var="publication">
													 <c:if test="${publication.type== 'thÃ©se'}">
												    	<tr>
														<td><c:out value="${publication.idResponsable}"></c:out></td>
														<td><c:out value="${publication.title}"></c:out></td>
														<td><c:out value="${publication.datePublication}"></c:out></td>
														<td><c:out value="${publication.nameJournal}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?publicationSending=${publication.idPublication}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
													</tr>
													</c:if>
												</c:forEach>
													
											</tbody>
											<tbody id="memoire">
												<c:forEach items="${publicationRecu.publicationList}" var="publication">
													 <c:if test="${publication.type== 'MÃ©moire'}">
												    	<tr>
														<td><c:out value="${publication.idResponsable}"></c:out></td>
														<td><c:out value="${publication.title}"></c:out></td>
														<td><c:out value="${publication.datePublication}"></c:out></td>
														<td><c:out value="${publication.nameJournal}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?publicationSending=${publication.idPublication}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
													</tr>
													</c:if>
												</c:forEach>
											</tbody>
											<tbody id="article">
												<c:forEach items="${publicationRecu.publicationList}" var="publication">
													 <c:if test="${publication.type== 'article'}">
												    	<tr>
														<td><c:out value="${publication.idResponsable}"></c:out></td>
														<td><c:out value="${publication.title}"></c:out></td>
														<td><c:out value="${publication.datePublication}"></c:out></td>
														<td><c:out value="${publication.nameJournal}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?publicationSending=${publication.idPublication}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
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
				<input class="btn btn-info myBtnDetail"
					onclick="location.href = 'publicationForm';" value="Ajouter" />
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
