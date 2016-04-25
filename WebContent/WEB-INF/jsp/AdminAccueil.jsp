<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Accueil Administrateur</title>
</head>
<body id="scroll_top">
	<section id="header_areaBis"></section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
		<div class="content center">
			<c:import url="entete.jsp"></c:import>
			<div class="fix main_content_area ">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-heading">Liste des étudiants</div>
									<form enctype="multipart/form-data" method="post"
										action="importExcel">
										<input type="file" id="source" name="source" /> 
										<button type="submit" class="btn btn-success">Valider</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="fix scroll_to_top">
						<a href="#scroll_top" class="floatright">Remonter </a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<c:import url="piedsPage.jsp"></c:import>
</body>
</html>
