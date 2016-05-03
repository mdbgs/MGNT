<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SE.Ceamitic</title>
</head>
<body id="scroll_top">
	<!-- First image in the header -->
	<section id="header_areaBis"> </section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
	<div class="content">
		<c:import url="entete.jsp"></c:import>
		<div class="fix main_content_area row ">
			<div class="fix allSearch"></div>
			<div class="fix single_sidebar">
				<div class="inner">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">Tableau des Indicateurs</div>
								<div class="panel-body">
									<div class="table-responsive">
<!-- 										<table class="table table-striped table-bordered table-hover" -->
<!-- 											id="myDataTable"> -->
<!-- 											<thead> -->
<!-- 												<tr> -->
<!-- 													<th>Num&eacutero</th> -->
<!-- 													<th>Libell&eacute</th> -->
<!-- 													<th>Objectif</th> -->
<!-- 													<th>Sigle</th> -->
<!-- 													<th>Graphe</th> -->
<!-- 												</tr> -->
<!-- 											</thead> -->
<!-- 											<tbody id="indicateurTab"> -->
<%-- 												<c:forEach items="${indicateurRecu.indicateurList}" --%>
<%-- 													var="indicat"> --%>
<!-- 													<tr> -->
<%-- 														<td>Indicateur <c:out value="${indicat.numero}"></c:out></td> --%>
<%-- 														<td><c:out value="${indicat.libelle}"></c:out></td> --%>
<%-- 														<td><c:out value="${indicat.objectif}"></c:out></td> --%>
<%-- 														<td><c:out value="${indicat.sigle}"></c:out></td> --%>
<!-- 														<td class="row"><button type="submit" -->
<!-- 																class=" btn btn-info" -->
<%-- 																onclick="location.href = 'indicator?sendIndicateur=${indicat.numero}';" --%>
<!-- 																id="detailBtn"> -->
<!-- 																<img alt="action" src="Assets/images/icons/graphe.jpg"> -->
<!-- 																<span>Voir le graphe</span> -->
<!-- 															</button> -->
<!-- 															<button type="submit" class=" btn btn-info" -->
<!-- 																onclick="location.href = 'graphe';" id="detailBtn"> -->
<!-- 																<img alt="action" src="Assets/images/icons/graphe1.jpg"> -->
<!-- 																<span>Voir le graphe</span> -->
<!-- 															</button></td> -->
<!-- 													</tr> -->
<%-- 												</c:forEach> --%>
<!-- 											</tbody> -->

<!-- 										</table> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<input class="btn btn-info myBtnDetail"
					onclick="location.href = '#';" value="Ajouter" />
				<div class="fix scroll_to_top">
					<a href="#scroll_top" class="floatright">Remonter </a>
				</div>
			</div>
		</div>
	</section>
	<div>
		<c:set var="listIndic" value="${indicateurRecu.indicateurList}"></c:set>
		<c:set var="rowsCount" value="${rowsCount}" />
		<c:set var="rowsPerPage" value="3" />
		<c:set var="pageNumber" value="${param.pageNumber}" />
		<c:set var="a">
			<fmt:formatNumber value="${rowsCount/rowsPerPage}"
				maxFractionDigits="0" />
		</c:set>
		<c:set var="b" value="${rowsCount/rowsPerPage}" />
		<c:choose>
			<c:when test="${a==0}">
				<c:set var="numberOfPages" value="1" scope="session" />
			</c:when>

			<c:when test="${b>a}">
				<c:set var="xxx" value="${b%a}" />
				<c:if test="${xxx>0}">
					<c:set var="numberOfPages" value="${b-xxx+1}" scope="session" />
				</c:if>
			</c:when>

			<c:when test="${a>=b}">
				<c:set var="numberOfPages" value="${a}" scope="session" />
			</c:when>
		</c:choose>
		<c:set var="start" value="${pageNumber*rowsPerPage-rowsPerPage}" />
		<c:set var="stop" value="${pageNumber*rowsPerPage-1}" />
		<center>
			<c:set var="columns" value="0" scope="session" />
			<c:forEach items="${listIndic}" var="indic">
				<c:set var="columns" value="${columns+1}" />
			</c:forEach>
			<c:set var="columns" value="${columns-1}" />

			<c:forEach items="${listIndic}" var="indicat">
					<div>
				<label>Indicateur <c:out value="${indicat.numero}"></c:out></label>
				<label>libelle<c:out value="${indicat.libelle}"></c:out></label>
				<label>objectif<c:out value="${indicat.objectif}"></c:out></label>
				<label>sigle<c:out value="${indicat.sigle}"></c:out></label>
					</div>
			</c:forEach>

			<%--For displaying Previous link --%>
			<c:if test="${pageNumber gt 1}">
				<a href="dispresult.jsp?pageNumber=${pageNumber - 1}">Previous</a>
			</c:if>
			<c:forEach begin="1" end="${numberOfPages}" var="i">
				<c:choose>
					<c:when test="${i!=pageNumber}">
						<a href="dispresult.jsp?pageNumber=<c:out value="${i}"/>"><c:out
								value="${i}" /></a>
					</c:when>
					<c:otherwise>
						<c:out value="${i}" />
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<%--For displaying Next link --%>
			<c:if test="${pageNumber lt numberOfPages}">
				<a href="dispresult.jsp?pageNumber=${pageNumber + 1}">Next</a>
			</c:if>
		</center>
	</div>
	<c:import url="piedsPage.jsp"></c:import>
	<script>
		$(document).ready(function() {
			$('#myDataTable').dataTable();
		});
	</script>
</body>
</html>
