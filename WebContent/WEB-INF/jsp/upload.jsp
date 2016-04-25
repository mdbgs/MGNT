<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Envoi de fichier</title>
<link type="text/css" rel="stylesheet" href="form.css">
</head>
<body>
	<form method="post" action="upload" class="myForm"
		enctype="multipart/form-data">
		<c:import url="entete.jsp"></c:import>
		<h3>Coordonnées Etudiant</h3>
		<div class="row">
			<div class="fileupload fileupload-new" data-provides="fileupload">
				<div class="fileupload-preview thumbnail"
					style="width: 200px; height: 150px;"></div>
				<div>
					<span class="btn btn-file btn-success"><span
						class="fileupload-new">Choisir photo</span><span
						class="fileupload-exists">Changer</span></span> <span href="#"
						class="btn btn-danger fileupload-exists" data-dismiss="fileupload">Effacer</span>
					<input type="file" name="file" size="50" /> <input type="submit"
						value="Upload File" />
				</div>
			</div>
		</div>
	</form>
</body>
<%@ include file="piedsPage.jsp"%>
<script>
	$(function() {
		$("#overlay").click(function() {
			$("#cadre").fadeOut();
			$("#overlay").fadeOut();
		});
	});
</script>
</body>
<!-- JS -->
<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
<script type="text/javascript" src="Assets/js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="Assets/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="Assets/js/bootstrap-datepicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function getValueOption(valueOption) {
		var selectedanswer = document.getElementById(valueOption).selectedIndex;
		return document.getElementsByTagName("option")[selectedanswer].value;
	});
</script>
</html>