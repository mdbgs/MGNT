<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
	// 	if (user == null) {
	// 		System.out.println("Utilisateur inexistant!!!");
	// 		response.sendRedirect("connexion");
	// 	} else {
	// 		System.out.println("Utilisateur existant!!!");
	// 	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SE.Ceamitic</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css" />
<link rel="stylesheet" href="Assets/css/style.css" media="screen" />
<link rel="shortcut icon" type="image/x-icon"
	href="Assets/images/slideshow/logoceamitic.png" sizes="16x16" />
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen" />
<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/main.css" />
<link rel="stylesheet" href="Assets/css/MoneAdmin.css" />
<link rel="stylesheet"
	href="Assets/plugins/Font-Awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="Assets/plugins/Font-Awesome/css/font-awesome.css" />
<link href="Assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
<link rel="stylesheet" href="Assets/css/nexus.css" rel="stylesheet" />
</head>
<body>
	<!-- First image in the header -->
	<div class="main_menu">
		<ul id="nav2" class="barreOutil">
			<div class="col-xs-12 barreValue">
				<c:set scope="session" var="rolename" value="${rolename}"></c:set>
				<c:choose>
					<c:when test="${rolename=='admin'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<li><a href="listeCompte">Créer Compte<span>.</span></a>
							<ul>
								<li><a href="javascript:responsableSuivi()">Responsable Suivi</a></li>
								<li><a href="javascript:responsableSaisie()">Responsable Saisie</a></li>
								<li><a href="javascript:responsableControle()">Responsable Contrôle</a></li>
								<li><a href="javascript:coordonnateur()">Coordonnateur</a></li>
								<li><a href="javascript:viceCoordonnateur()">Vice Coordonnateur</a></li>
							</ul></li>
						<li><a href="reunion">Liste des comptes</a></li>
					</c:when>
					<c:when test="${rolename=='etudiant'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='enseignat'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='coordonnateur'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='responsable_Suivi_Evaluation'}">
						<li><a href="listeEtudiant">Etudiant<span>.</span></a>
							<ul>
								<li><a href="javascript:apprentissageActivite()">Régionaux</a></li>
								<li><a href="javascript:rechercheActivite()">Nationaux</a></li>
								<li><a href="javascript:partenaireActivite()">Féminins</a></li>
								<li><a href="javascript:gouvernanceActivite()">Tous</a></li>
							</ul></li>
						<li><a href="enseignant">Enseignant</a></li>
						<li><a href="activite">Activités<span>.</span></a>
							<ul>
								<li><a href="javascript:apprentissageActivite()">Apprentissage</a></li>
								<li><a href="javascript:rechercheActivite()">Recherche</a></li>
								<li><a href="javascript:partenaireActivite()">Partenariat</a></li>
								<li><a href="javascript:gouvernanceActivite()">Gouvernance</a></li>
							</ul></li>
						<li><a href="indicateur">Indicateur</a></li>
						<li><a href="publication">Publication<span>.</span></a>
							<ul>
								<li><a href="javascript:apprentissageActivite()">Mémoire</a></li>
								<li><a href="javascript:rechercheActivite()">Thése</a></li>
								<li><a href="javascript:rechercheActivite()">Article</a></li>
							</ul></li>
						<li><a href="stage">Stage<span>.</span></a>
							<ul>
								<li><a href="javascript:apprentissageActivite()">Enseignant</a></li>
								<li><a href="javascript:rechercheActivite()">Etudiant</a></li>
							</ul></li>
						<li><a href="reunion">Reunion</a></li>
						<li><a href="formation">Formation</a></li>
						<li><a href="programme">Programme</a></li>
						<li><a href="animateur">Animateur-Relecteur</a></li>
					</c:when>
					<c:when test="${rolename=='responsable_Saisie'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='responsable_Controle'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='partenaire'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='BanqueMondial'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='viceCoordonnateur'}">
						<li><a href="administrator"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
				</c:choose>
				
			</div>
		</ul>
	</div>
	<script src="http://code.jquery.com/jquery.js"></script>
	<!-- Jessor slider Start-->
	<script type="text/javascript" src="Assets/js/jssor.core.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.utils.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.slider.js"></script>
	<!-- JS -->
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<script type="text/javascript" src="Assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Assets/js/myScript.js"></script>
	<script src="Assets/plugins/jquery-2.0.3.min.js"></script>
	<!-- END GLOBAL SCRIPTS -->
	<!-- PAGE LEVEL SCRIPTS -->
	<script src="Assets/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="Assets/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#myDataTable').dataTable();

		});
	</script>	
</body>
</html>
