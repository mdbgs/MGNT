<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<c:import url="../Header.jsp"></c:import>
<head>
<meta charset="utf-8" />
<title>Accueil Administrateur</title>
</head>
<body id="scroll_top">
	<c:import url="../sidebar.jsp"></c:import>
	<div
		class="main-content col-sm-offset-1 col-md-offset-1 col-xs-offset-1 col-sm-10 col-md-10 col-xs-10">
		<c:import url="../MenuBar.jsp"></c:import>
		<div class="content">
			<div class="fix main_content_area">
				<div class="fix allSearch"></div>
				<div class="fix single_sidebar">
					<div class="inner">
						<div class="row">
							<div class="col-lg-12">
								<div class="panel panel-default">
									<div class="panel-heading">Accueil Administrateur</div>
									<div class="uploadCSV">
										<span>Charger la liste des étudiants</span>
										<form enctype="multipart/form-data" method="post"
											action="importExcel">
											<input type="file" id="source" name="source" />
											<button type="submit" class="btn btn-success">Valider</button>
										</form>
									</div>
								</div>
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
	<div class="col-sm-12 col-md-12 col-xs-12 footerContent">
		<c:import url="../Footer.jsp"></c:import>
	</div>
</body>
</html>
