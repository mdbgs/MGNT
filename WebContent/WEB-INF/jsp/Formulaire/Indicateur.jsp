<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SE.Ceamitic</title>
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
								<div class="panel-heading">Tableau des Indicateurs</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="myDataTable">
											<thead>
												<tr>
													<th>Num&eacute;ro</th>
													<th>Libell&eacute;</th>
													<th>Objectif</th>
													<th>Sigle</th>
													<th>Graphe</th>
													<th>Reporting</th>
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
														<td class="row"><button type="submit"
																class=" btn btn-info"
																onclick="location.href = 'indicator?sendIndicateur=${indicat.numero}';"
																id="detailBtn1">
																<img alt="action" src="Assets/images/icons/graphe.jpg">
																<span>Voir le graphe</span>
															</button>
															<button type="submit" class=" btn btn-info"
																onclick="location.href = 'graphe';" id="detailBtn1">
																<img alt="action" src="Assets/images/icons/graphe1.jpg">
																<span>Voir le graphe</span>
															</button></td>
															<td>
															   <button type="submit" class=" btn btn-info"
																onclick="location.href = 'indicateur<c:out value="${indicat.numero}"></c:out>';" id="detailBtn">
																<img alt="action" src="Assets/images/icons/pdf.jpg">
																<span>voir le fichier pdf</span>
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
					onclick="location.href = '#';" value="Ajouter" />
				<input class="btn btn-default" onclick="location.href = 'monImage';" value="Graphe" />
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
</html>
