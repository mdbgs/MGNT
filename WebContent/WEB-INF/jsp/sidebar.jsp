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
	<nav class="sidebar sidebar-menu-collapsed"> <a href="#"
		id="justify-icon"> <span class="glyphicon glyphicon-align-justify"></span>
	</a>
	<ul class="level1">
		<c:set scope="session" var="rolename" value="${rolename}"></c:set>
		<c:choose>
			<c:when test="${rolename=='etudiant'}">
				<li class="active"><a href="studentHome"
					class="expandable" title="Accueil"> <span
						class="glyphicon glyphicon-home "></span> <span
						class="expanded-element">Accueil</span>
				</a></li>
				<li><a class="expandable" href="detail?studentSending=<%=user.getPseudo()%>" title="Information">
						<span class="glyphicon glyphicon-education collapsed-element"></span>
						<span class="expanded-element">Information</span>
				</a></li>
			</c:when>
			<c:when test="${rolename=='responsable_Saisie'}">
				<li class="active"><a href="RSHome"
					class="expandable" title="Accueil"> <span
						class="glyphicon glyphicon-home "></span> <span
						class="expanded-element">Accueil</span>
				</a></li>
				<li><a class="expandable" href="activityList"
					title="Activit&eacute;s"> <span
						class="glyphicon glyphicon-cog collapsed-element"></span> <span
						class="expanded-element">Activit&eacute;s</span>
				</a></li>
			</c:when>
			<c:when test="${rolename=='responsable_Suivi_Evaluation'}">
				<li class="active"><a href="RSEHome"
					class="expandable" title="Accueil"> <span
						class="glyphicon glyphicon-home "></span> <span
						class="expanded-element">Accueil</span>
				</a></li>
				<li><a class="expandable" href="studentList" title="Etudiant">
						<span class="glyphicon glyphicon-education collapsed-element"></span>
						<span class="expanded-element">Etudiant</span>
				</a></li>
				<li><a class="expandable" href="teacherList" title="Enseignant">
						<span class="glyphicon glyphicon-briefcase collapsed-element"></span>
						<span class="expanded-element">Enseignant</span>
				</a></li>
				<li><a class="expandable" href="activityList"
					title="Activit&eacute;s"> <span
						class="glyphicon glyphicon-cog collapsed-element"></span> <span
						class="expanded-element">Activit&eacute;s</span>
				</a></li>
				<li><a class="expandable" href="indicatorList"
					title="Indicateur"> <span
						class="glyphicon glyphicon-stats collapsed-element"></span> <span
						class="expanded-element">Indicateur</span>
				</a></li>
				<li><a class="expandable" href="publicationList"
					title="Publication"> <span
						class="glyphicon glyphicon-book collapsed-element"></span> <span
						class="expanded-element">Publication</span>
				</a></li>
				<li><a class="expandable" href="stageList" title="Stage"> <span
						class="glyphicon glyphicon-tasks collapsed-element"></span> <span
						class="expanded-element">Stage</span>
				</a></li>
				<li><a class="expandable" href="meetingList"
					title="R&eacute;union"> <span
						class="glyphicon glyphicon-calendar collapsed-element"></span> <span
						class="expanded-element">R&eacute;union</span>
				</a></li>
				<li><a class="expandable" href="formationList"
					title="Formation"> <span
						class="glyphicon glyphicon-blackboard collapsed-element"></span> <span
						class="expanded-element">Formation</span>
				</a></li>
				<li><a class="expandable" href="partnerList" title="Partenaire">
						<span class="glyphicon glyphicon-star-empty collapsed-element"></span>
						<span class="expanded-element">Partenaire</span>
				</a></li>
				<li><a class="expandable" href="programList" title="Programme">
						<span class="glyphicon glyphicon-folder-open collapsed-element"></span>
						<span class="expanded-element">Programme</span>
				</a></li>
				<li><a class="expandable" href="responsableList" title="Responsable">
						<span class="collapsed-element"><img alt="" src="Assets/images/glyphicons/glyphicons-715-user-structure.png" style="background-color:white;padding:2px;border-radius:2px; width:20px;"></span>
						<span class="expanded-element">Responsable</span>
				</a></li>
			</c:when>
		</c:choose>

	</ul>
	</nav>
</body>
<script src="Assets/plugins/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="Assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="Assets/js/Sidebar.js"></script>
</html>