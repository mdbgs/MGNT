<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SE.Ceamitic</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
<link rel="shortcut icon" type="image/x-icon"
	href="Assets/images/slideshow/logoceamitic.png" sizes="16x16" />
<link rel="stylesheet" href="Assets/css/style.css" media="screen" />
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen" />
<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/main.css" />
<link rel="stylesheet" href="Assets/css/MoneAdmin.css" />
<link rel="stylesheet" href="Assets/css/theme.css" />
<link rel="stylesheet"
	href="Assets/plugins/Font-Awesome/css/font-awesome.css" />
<link href="Assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/nexus.css" rel="stylesheet" />
</head>

<body id="scroll_top">
	<!-- First image in the header -->
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
								<div class="panel-heading">Tableau des Indicateurs</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Num&eacutero</th>
													<th>Libell&eacute</th>
													<th>Objectif</th>
													<th>Sigle</th>
													<th>Graphe</th>
												</tr>
											</thead>
											<tbody id="indicateurTab">
												<c:forEach items="${indicateurRecu.indicateurList}"
													var="indicat">
													<tr>
														<td>Indicateur <c:out value="${indicat.numero}"></c:out></td>
														<td><c:out value="${indicat.libelle}"></c:out></td>
														<td><c:out value="${indicat.objectif}"></c:out></td>
														<td><c:out value="${indicat.sigle}"></c:out></td>
														<td class="row"><button type="submit" class=" btn btn-info"
																onclick="location.href = 'indicateurActivite?sendIndicateur=${indicat.numero}';"
																id="detailBtn">
																<img alt="action" src="Assets/images/icons/graphe.jpg">
																<span>Voir le graphe</span>
															</button>
															<button type="submit" class=" btn btn-info"
																onclick="location.href = 'graphe';"
																id="detailBtn">
																<img alt="action" src="Assets/images/icons/graphe1.jpg">
																<span>Voir le graphe</span>
															</button></td>
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
				<input class="btn btn-info myBtnDetail" onclick="location.href = '#';"
					value="Ajouter" />

				<div class="fix scroll_to_top">
					<a href="#scroll_top" class="floatright">Remonter </a>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="piedsPage.jsp" %>
	
	<script>
		$(document).ready(function() {
			$('#myDataTable').dataTable();

		});
		$(function() {
			$("#overlay").click(function() {
				$("#cadre").fadeOut();
				$("#overlay").fadeOut();
			});
		});
	</script>

</body>
</html>
