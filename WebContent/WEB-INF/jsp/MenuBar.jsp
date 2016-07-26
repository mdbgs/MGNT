<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- First image in the header -->
	<c:set scope="session" var="pseudo"><%=user.getPseudo()%></c:set>
	<div class="main_menu">
		<ul id="nav2" class="barreOutil">
			<div class="col-lg-12 col-md-12 col-sm-12 barreValue">
				<c:set scope="session" var="rolename" value="${rolename}"></c:set>
				<c:choose>
					<c:when test="${rolename=='admin'}">
						<li><a href="adminHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<li><a href="responsableForm">Créer Compte<span>.</span></a></li>
						<li><a href="accountList">Liste des comptes<span>.</span></a>
							<ul>
								<li><a href="javascript:responsableSuivi()">Etudiant</a></li>
								<li><a href="javascript:responsableSaisie()">Responsable</a></li>
								<li><a href="javascript:responsableControle()">Enseignant</a></li>
								<li><a href="javascript:coordonnateur()">Partenaire</a></li>
								<li><a href="javascript:viceCoordonnateur()">Animateur
										relecteur</a></li>
							</ul></li>
						<li class="DeconProfil"><a href="">Bonjour <c:out value="${pseudo}"></c:out><span>.</span></a>
							<ul>
								<li><a href="detail?studentSending=<c:out value="${pseudo}"></c:out>">Profil</a></li>
								<li><a href="connection">Déconnexion</a></li>
							</ul></li>
					</c:when>
					<c:when test="${rolename=='etudiant'}">
						<li class="homeimg"><a href="studentHome"><img
								alt="Accueil" src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<li class="DeconProfil">
							<a class="glyphicon glyphicon-user">Bonjour <c:out value="${pseudo}"></c:out><span>.</span></a>
							<ul>
								<li><a href="detail?studentSending=<c:out value="${pseudo}"></c:out>"> <i class="glyphicon glyphicon-user"></i> Profil</a></li>
								<li><a href="connection"> <i class="glyphicon glyphicon-off"></i> Déconnexion </a></li>
							</ul>
						</li>
					</c:when>
					<c:when test="${rolename=='enseignat'}">
						<li><a href="teacherHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<li class="DeconProfil">
							<a class="glyphicon glyphicon-user">Bonjour <c:out value="${pseudo}"></c:out><span>.</span></a>
							<ul>
								<li><a href="detail?rseSending=1"> <i class="glyphicon glyphicon-user"></i> Profil</a></li>
								<li><a href="connection"> <i class="glyphicon glyphicon-off"></i> Déconnexion </a></li>
							</ul>
						</li>
					</c:when>
					<c:when test="${rolename=='coordonnateur'}">
						<li><a href="coordonatorHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>
						<li class="DeconProfil">
							<a class="glyphicon glyphicon-user">Bonjour <c:out value="${pseudo}"></c:out><span>.</span></a>
							<ul>
								<li><a href="detail?rseSending=1"> <i class="glyphicon glyphicon-user"></i> Profil</a></li>
								<li><a href="connection"> <i class="glyphicon glyphicon-off"></i> Déconnexion </a></li>
							</ul>
						</li>
					</c:when>
					<c:when test="${rolename=='responsable_Suivi_Evaluation'}">
						<li class="homeimg">
							<a href="RSEHome"><img alt="Accueil" src="Assets/images/slideshow/logoceamitic.png"></a>
						</li>
						<c:set scope="session" var="student" value="${responsableRecu}"></c:set>
						<li class="DeconProfil">
							<a class="glyphicon glyphicon-user">Bonjour <c:out value="${pseudo}"></c:out><span>.</span></a>
							<ul>
								<li><a href="detail?rseSending=1"> <i class="glyphicon glyphicon-user"></i> Profil</a></li>
								<li><a href="connection"> <i class="glyphicon glyphicon-off"></i> Déconnexion </a></li>
							</ul>
						</li>
					</c:when>
					<c:when test="${rolename=='responsable_Saisie'}">
						<li class="homeimg">
							<a href="RSHome"><img alt="Accueil" src="Assets/images/slideshow/logoceamitic.png"></a>
						</li>
						<li class="DeconProfil">
							<a class="glyphicon glyphicon-user">Bonjour <c:out value="${pseudo}"></c:out><span>.</span></a>
							<ul>
								<li class="glyphicon glyphicon-user"><a href="detail?studentSending=<c:out value="${pseudo}"></c:out>">Profil</a></li>
								<li class="glyphicon glyphicon-off"><a href="connection">Déconnexion</a></li>
							</ul>
						</li>
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
						<li><a href="coordinatorHome"><img alt="Accueil"
								src="Assets/images/slideshow/logoceamitic.png"></a></li>

					</c:when>
				</c:choose>
			</div>
		</ul>
	</div>
</body>
</html>
