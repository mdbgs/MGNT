<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
	if (user == null) {
		System.out.println("Utilisateur inexistant!!!");
		response.sendRedirect("connexion");
	} else {
		System.out.println("Utilisateur existant!!!");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Graphe Indicateur Activité</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
<link rel="stylesheet" href="Assets/css/style.css" media="screen" />
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen" />
<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/main.css" />
<link rel="stylesheet" href="Assets/css/MoneAdmin.css" />
<link rel="stylesheet"
	href="assets/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="Assets/plugins/Font-Awesome/css/font-awesome.css" />
<link href="Assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content center">
			<div class="main_menu row">
				<nav>
					<ul id="nav2" class="barreOutil">
						<div class="col-xs-10 barreValue">
							<li><a href="home">Accueil</a></li>
							<li><a href="activite">Activités<span>.</span></a></li>
							<li><a href="indicateur">Indicateurs</li>
							<li><a href="listeEtudiant">Etudiant</a></li>
						</div>
						<div class="row ">
							<%
								if (user == null) {
									System.out.println("Utilisateur inexistant!!!");
							%>
							<li><a href="connexion"> Se connecter</a></li>
							<%
								} else {
							%>
							<li><a href="deconnection"> Se Déconnecter</a></li>
							<%
								}
							%>
					</ul>
				</nav>
			</div>
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

										<button type="button" class="btn btn-circle btn-default" id="activInfo" 
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
	<section id="footer_top_area">
		<div class="fix footer_top center">
			<div class="fix footer_top_container">
				<div>
					<ul class="col-lg-12">
						<li class="col-xs-2 myFooter"><a href=""><span>A
									propos</span></a></li>
						<li class="col-xs-2 myFooter"><a href=""><span>Nous
									contacter</span></a></li>
						<li class="col-xs-2 myFooter"><a href=""><span>Aide</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section id="footer_bottom_area">
		<div class="fix footer_bottom center">
			<div class="fix copyright floatleft">
				<p>&#169 2015 CEAMITIC</p>
			</div>
			<div class="fix footer_bottom_text floatright">
				<p>
					<a href="http://www.ceamitic.sn" title="Site web du centre"
						target="_blank">www.ceamitic.sn</a>
				</p>
			</div>
		</div>
	</section>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.core.js"></script>
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<script type="text/javascript" src="Assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Assets/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="Assets/js/myScript.js"></script>
	<script src="Assets/plugins/jquery-2.0.3.min.js"></script>
	<script src="Assets/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<script src="Assets/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="Assets/plugins/dataTables/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="Assets/js/jquery.connectingLine.js"></script>
<script type="text/javascript" src="Assets/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script>
		var mySVG = $('.inner').connect();
		mySVG.drawLine({
			left_node:'#indicInfo',
			right_node:'#activInfo',
			horizantal_gap:10,
			error:true,
			width:3
		});
		$( "#indicInfo" ).draggable({
		  drag: function(event, ui){mySVG.redrawLines();}
		});
		$( "#activInfo" ).draggable({
		  drag: function(event, ui){mySVG.redrawLines();}
		});
	</script>
</body>
</html>
