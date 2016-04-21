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
								<div class="panel-heading">Liste des étudiants</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Numéro étudiant</th>
													<th>Nom</th>
													<th>Prénom</th>
													<th>Niveau</th>
													<th>Détails</th>
												</tr>
											</thead>
											<tbody id="allEtud">
												<c:forEach items="${studentRecu.studentList}" var="student">
													<tr>
														<td><c:out value="${student.studentNumber}"></c:out></td>
														<td><c:out value="${student.lastName}"></c:out></td>
														<td><c:out value="${student.firstName}"></c:out></td>
														<td><c:out value="${student.level}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?studentSending=${student.idStudent}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tbody id="natEtud">
												<c:forEach items="${studentRecu.studentList}" var="student">
													<c:if test="${student.nationality== 'sÃ©nÃ©galaise'}">
														<tr>
															<td><c:out value="${student.studentNumber}"></c:out></td>
														<td><c:out value="${student.lastName}"></c:out></td>
														<td><c:out value="${student.firstName}"></c:out></td>
														<td><c:out value="${student.level}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?studentSending=${student.idStudent}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
											<tbody id="regEtud">
												<c:forEach items="${studentRecu.studentList}" var="student">
													<c:if test="${student.nationality== 'gambie'}">
														<tr>
															<td><c:out value="${student.studentNumber}"></c:out></td>
														<td><c:out value="${student.lastName}"></c:out></td>
														<td><c:out value="${student.firstName}"></c:out></td>
														<td><c:out value="${student.level}"></c:out></td>
														<td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?studentSending=${student.idStudent}';">
																<img alt="action" src="Assets/images/icons/editer.jpg">
															</button>
														</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
											<tbody id="femEtud">
												<c:forEach items="${studentRecu.studentList}" var="student">
													<c:if test="${student.gender== '1'}">
													 <tr>
														<td><c:out value="${student.studentNumber}"></c:out></td>
														<td><c:out value="${student.lastName}"></c:out></td>
														<td><c:out value="${student.firstName}"></c:out></td>
														<td><c:out value="${student.level}"></c:out></td>
														 <td>
															<button type="submit" class=" btn btn-info"
																id="detailBtn"
																onclick="location.href = 'detail?studentSending=${student.idStudent}';">
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
					onclick="location.href = 'upload';" value="Ajouter" />
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
