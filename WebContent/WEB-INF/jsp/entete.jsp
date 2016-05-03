<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>

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
<link rel="stylesheet" href="Assets/plugins/morris/morris-0.4.3.min.css"/>
</head>
<body>
	<%
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
	%>
	<c:redirect url="connection"></c:redirect>
	<%
		}
	%>
	<!-- First image in the header -->
	<div class="main_menu">
		<ul id="nav2" class="barreOutil">
			<div class="col-xs-12 barreValue">
				<c:set scope="session" var="rolename" value="${rolename}"></c:set>
				<c:choose>
					<c:when test="${rolename=='admin'}">
						<li><a href="adminHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<li><a href="listeCompte">Créer Compte<span>.</span></a>
							<ul>
								<li><a href="javascript:responsableSuivi()">Responsable
										Suivi</a></li>
								<li><a href="javascript:responsableSaisie()">Responsable
										Saisie</a></li>
								<li><a href="javascript:responsableControle()">Responsable
										Contrôle</a></li>
								<li><a href="javascript:coordonnateur()">Coordonnateur</a></li>
								<li><a href="javascript:viceCoordonnateur()">Vice
										Coordonnateur</a></li>
							</ul></li>
						<li><a href="reunion">Liste des comptes<span>.</span></a>
							<ul>
								<li><a href="javascript:responsableSuivi()">Etudiant</a></li>
								<li><a href="javascript:responsableSaisie()">Responsable</a></li>
								<li><a href="javascript:responsableControle()">Enseignant</a></li>
								<li><a href="javascript:coordonnateur()">Partenaire</a></li>
								<li><a href="javascript:viceCoordonnateur()">Animateur
										relecteur</a></li>
							</ul></li>
					</c:when>
 		            <c:when test="${rolename=='tudiant'}"> 
 						<li><a href="administrator"><img alt="Accueil" 
								src="Assets/images/slideshow/logoceamitic.png"></a></li> 
					</c:when> 
					<c:when test="${rolename=='enseignat'}">
						<li><a href="teacherHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<div class="DeconProfil">
							<li><a href="">Bonjour <%=user.getPseudo()%><span>.</span></a>
								<ul>
									<c:set scope="session" var="student" value="${etudiantRecu}"></c:set>
									<li><a href="detail?teacherSending=1">Profil</a></li>
									<li><a href="connection">Déconnexion</a></li>
								</ul></li>
						</div>

					</c:when>
					<c:when test="${rolename=='coordonnateur'}">
						<li><a href="coordonatorHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					
					<c:when test="${rolename=='responsable_Suivi_Evaluation'}" >
						<li><a href="studentList">Etudiant<span>.</span></a>
							<ul>
								<li><a href="javascript:regEtudiant()">Régionaux</a></li>
								<li><a href="javascript:natEtudiant()">Nationaux</a></li>
								<li><a href="javascript:femEtudiant()">Féminins</a></li>
								<li><a href="javascript:allEtudiant()">Tous</a></li>
							</ul></li>
						<li><a href="teacherList">Enseignant</a></li>
						<li><a href="activityList">Activités<span>.</span></a>
							<ul>
								<li><a href="javascript:apprentissageActivite()">Apprentissage</a></li>
								<li><a href="javascript:rechercheActivite()">Recherche</a></li>
								<li><a href="javascript:partenaireActivite()">Partenariat</a></li>
								<li><a href="javascript:gouvernanceActivite()">Gouvernance</a></li>
							</ul></li>
						</li>
						<li><a href="indicatorList">Indicateur</a></li>
						<li><a href="publicationList">Publication<span>.</span></a>
							<ul>
								<li><a href="javascript:thesePublication">Mémoire</a></li>
								<li><a href="javascript:memoirePublication">Thése</a></li>
								<li><a href="javascript:articlePublication">Article</a></li>
							</ul></li>
						<li><a href="stageList">Stage<span>.</span></a>
							<ul>
								<li><a href="javascript:apprentissageActivite()">Enseignant</a></li>
								<li><a href="javascript:rechercheActivite()">Etudiant</a></li>
							</ul></li>
						<li><a href="meetingList">Reunion</a></li>
						<li><a href="formationList">Formation</a></li>
						<li><a href="programList">Programme</a></li>
						<li><a href="partnerList">Partenaire</a></li>
						<li><a href="animatorList">Animateur-Relecteur</a></li>
					   <div class="DeconProfil">
					   <c:set scope="session" var="student" value="${responsableRecu}"></c:set>
					    <li >
					    <a href="">Bonjour <%= user.getPseudo() %><span>.</span></a>
<%-- 					        <a href="">${studentRecu.pseudo}bonjour<span>.</span></a> --%>
					      <ul>
 					           <li><a href="detail?studentSending=1">Profil</a></li> 
							   <li><a href="connection">Déconnexion</a></li>
							</ul>
					     </li>
					    </div> 
					</c:when>
					<c:when test="${rolename=='etudiant'}" >
						<li><a href="administrator"><img alt="Accueil" 
								src="Assets/images/slideshow/logoceamitic.png"></a></li> 
						
						
					   <div class="DeconProfil">
					    <li >
					    <a href="">Hello <%= user.getPseudo() %><span>.</span></a>
					      <ul>
					      <c:set scope="session" var="student" value="${etudiantRecu}"></c:set>
 					           <li><a href="detail?studentSending=<%= user.getPseudo() %>">Profil</a></li> 
							   <li><a href="home">Déconnexion</a></li>
							</ul>
					     </li>
					    </div> 
					</c:when>
					

					<c:when test="${rolename=='responsable_Saisie'}">
						<li><a href="RSHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='responsable_Controle'}">
						<li><a href="RCHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='partenaire'}">
						<li><a href="partnerHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='BanqueMondial'}">
						<li><a href="worldBankHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
					<c:when test="${rolename=='viceCoordonnateur'}">
						<li><a href="coordinatorHome"><img alt="Accueil" src="Assets/images/slideshow/logoceamitic.png"></a></li>
					</c:when>
				</c:choose>
			</div>
		</ul>
	</div>
</body>
</html>
