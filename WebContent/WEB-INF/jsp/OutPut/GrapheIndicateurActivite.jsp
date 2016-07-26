<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Graphe Indicateur Activité</title>
<c:import url="../Header.jsp"></c:import>
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content center">
			<c:import url="../MenuBar.jsp"></c:import>
			<div class="fix main_content_areaBis row ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<h1>Indicateur</h1>
								<c:set scope="session" var="indicRecu" value="${indicateurRecu}"></c:set>
								<div class="indic">
									<button type="button" class="btn btn-circle btn-info"
										onclick="location.href = 'detail?indicateurSending=${indicRecu.numero}';"
										id="indicInfo">
										<c:out value="${indicRecu.numero}"></c:out>
										<span> <b>Indicateur ${indicRecu.numero}</b><br /> <b>${indicRecu.libelle}</b><br />
											<b>${indicRecu.objectif}</b>
										</span>
									</button>
									<%-- 									<c:forEach items="${indicateurRecu.indicateurList}" --%>
									<%-- 										var="indicateur"> --%>
									<%-- 										<c:if test="${indicateur.IdIndicateur == idIndic}"> --%>
									<!-- 											<button type="button" class="btn btn-circle btn-info" -->
									<!-- 											id="indicInfo"> -->
									<%-- 											<c:out value="${indicateur.numero}"></c:out> --%>
									<%-- 											<span> <b>Indicateur ${indicateur.numero}</b><br /> <b>${indicateur.libelle}</b><br /> --%>
									<%-- 												<b>${indicateur.objectif}</b> --%>
									<!-- 											</span> -->
									<!-- 										</button> -->
									<%-- 										</c:if> --%>

									<%-- 									</c:forEach> --%>
									<c:forEach items="${activiteRecu.activeList}" var="activit">

										<button type="button" class="btn btn-circle btn-default"
											id="activInfo"
											onclick="location.href = 'detail?activiteSending=${activit.IDactivite}';">
											<c:out value="${activit.IDactivite}"></c:out>
											<span> <b>Activité ${activit.IDactivite}</b><br /> <b>${activit.libelle}</b>
											</span>
										</button>
									</c:forEach>
								</div>
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
	<c:import url="../Footer.jsp"></c:import>
	<script>
		var mySVG = $('.inner').connect();
		mySVG.drawLine({
			left_node : '#indicInfo',
			right_node : '#activInfo',
			horizantal_gap : 10,
			error : true,
			width : 3
		});
		$("#indicInfo").draggable({
			drag : function(event, ui) {
				mySVG.redrawLines();
			}
		});
		$("#activInfo").draggable({
			drag : function(event, ui) {
				mySVG.redrawLines();
			}
		});
	</script>
</body>
</html>
