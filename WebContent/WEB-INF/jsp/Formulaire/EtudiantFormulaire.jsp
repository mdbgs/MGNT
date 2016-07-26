<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
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
				<c:set scope="session" var="student" value="${etudiantRecu}"></c:set>
				<c:if test="${student!='null'}">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire d'inscription Pédagogique Etudiant</h2>
								</div>
								<form action="studentForm" method="post"
									enctype="multipart/form-data" class="myForm">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<div class="fileupload-preview thumbnail"><img alt="" src=""></div>
										<input type="file" id="fichier" name="fichier" /> <span
											class="erreur">${errors['fichier']}</span>
										<div class="row">
											<div class="col-xs-5" id="formGauche">
												<div class="row ">
													<label>Nom <span>*</span></label>
												</div>
												<div class="row">
													<input class="form-control" type="text" id="lastName"
														name="lastName" value="${student.lastName}"
														placeholder="nom" />
												</div>
												<span class="erreur">${errors['lastName']}</span>
											</div>
											<div class="formDroite col-xs-5">
												<div class="row">
													<label>Prénom<span>*</span></label>
												</div>
												<div class="row">
													<input class="form-control" type="text" id="firstName"
														name="firstName" value="${student.firstName}"
														placeholder="Prénom" />
												</div>
												<span class="erreur">${errors['firstName']}</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Date de naissance <span>*</span></label>
											</div>
											<div class="row date">
												<input class="form-control dateShow" type="text"
													id="birthday" name="birthday" value="${student.birthday}"
													placeholder="Date de naissance" />
											</div>
											<span class="erreur">${errors['birthday']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row ">
												<label>Lieu de naissance<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="countryOfBirth"
													name="countryOfBirth" value="${student.countryOfBirth}"
													placeholder="Lieu de naissance" />
											</div>
											<span class="erreur">${errors['countryOfBirth']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Email <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="email" id="mail"
													name="mail" value="${student.mail}" placeholder="Email" />
											</div>
											<span class="erreur">${errors['mail']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Adresse <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="adress"
													name="adress" value="${student.adress}" placeholder="Adresse" />
											</div>
											<span class="erreur">${errors['adress']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Numéro Etudiant <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="studentNumber"
													name="studentNumber" value="${student.studentNumber}"
													placeholder="Ex: P2612" />
											</div>
											<span class="erreur">${errors['studentNumber']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Téléphone <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phone"
													name="phone" value="${student.phone}" placeholder="Téléphone" />
											</div>
											<span class="erreur">${errors['phone']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Sexe<span>*</span></label>
											</div>
											<div class="row">
												<select id="sexe"
													<input class="form-control" type="text" name="gender" value=getValueOption(gender) />>
													<option value="" disabled>sexe</option>
													<c:if test="${student.gender==0}">
														<option value="1" selected>Féminin</option>
														<option value="0">Masculin</option>
													</c:if>
													<c:if test="${student.gender==1}">
														<option value="1">Féminin</option>
														<option value="0" selected>Masculin</option>
													</c:if>
												</select>
											</div>
											<span class="erreur">${errors['gender']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nationalité <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="nationality"
													name="nationality" value="${student.nationality}"
													placeholder="Nationalité" />
											</div>
											<span class="erreur">${errors['nationality']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Niveau<span>*</span></label>
											</div>
											<div class="row">
												<select id="level"
													<input class="form-control" type="text" name="level" />>
													<option disabled>Choisir le niveau</option>
													<c:forEach items="${listNiveau}" var="niveau">
														<c:if test="${niveau!=student.level}">
															<option>${niveau}</option></c:if>
														<c:if test="${niveau ==student.level}">
															<option selected>${niveau}</option></c:if>
													</c:forEach>
												</select>
											</div>
											<span class="erreur">${errors['level']}</span>
											
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Programme<span>*</span></label>
											</div>
											<div class="row">
												<select id="program"
													<input class="form-control" type="text" name="program" value="${student.program}" />>
													<option value="" disabled selected>Choisir le
														programme</option>
													<option>M2ITIC/FOAD</option>
													<option>Algébre Appliquée</option>
													<option>DIETEL</option>
													<option>Energie Renouvelable</option>
													<option>Informatique</option>
													<option>MaDSI</option>
													<option>MAI</option>
													<option>MAIF</option>
													<option>MaRT</option>
													<option>Maths Appliquée</option>
													<option>MMAF</option>
													<option>MMSCI</option>
													<option>MMSTOCH</option>
													<option>Physique Appliquée</option>
													<option>Physique A Statistique Appliquée</option>
												</select>
											</div>
											<span class="erreur">${errors['program']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Semestre<span>*</span></label>
											</div>
											<div class="row">
												<select id="semester"
													<input class="form-control" type="text" name="semester" value="${student.semester}" />>
													<option value="" disabled selected>choisir le
														semestre</option>
													<option>Semestre 1</option>
													<option>Semestre 2</option>
													<option>Autre</option>
												</select>
											</div>
											<span class="erreur">${errors['semester']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Boite Postale</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="bp" name="bp"
													value="${student.bp}" placeholder="Boite postale" />
											</div>
											<span class="erreur">${errors['bp']}</span>
										</div>
									</div>
									<h3>Personne à contacter</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label> Nom </label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="lastNamePAC"
													name="lastNamePAC" value="${student.lastNamePAC}"
													placeholder="Nom" />
											</div>
											<span class="erreur">${errors['lastNamePAC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label> Prenom</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="firstNamePAC"
													name="firstNamePAC" value="${student.firstNamePAC}"
													placeholder="Prénom" />
											</div>
											<span class="erreur">${errors['firstNamePAC']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label> Telephone</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phonePAC"
													name="phonePAC" value="${student.phonePAC}"
													placeholder="Telephone" />
											</div>
											<span class="erreur">${errors['phonePAC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label> Adresse</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="adressPAC"
													name="adressPAC" value="${student.adressPAC}"
													placeholder="Adresse" />
											</div>
											<span class="erreur">${errors['adressPAC']}</span>
										</div>
									</div>
									<!--      <input type="submit" value="Envoyer"class="sansLabel" />                   -->
									<div class="row myBtn">
										<input class="btn btn-danger myBtnDetail" style="margin-bottom: 10px;" onclick="location.href = 'studentHome';"
								value="Annuler" />
										<input class="btn btn-info " type="submit" value="Valider" />

									</div>
								</form>
								<div class="fix scroll_to_top">
									<a href="#scroll_top" class="floatright">Remonter </a>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				
				<c:if test="${student=='null'}">
					<div class="inner">
						<div class="row">
							<div class="myPanel panel-default">
								<div class="panel-heading">
									<h2>Formulaire d'inscription Etudiant</h2>
								</div>
								<form action="studentForm" method="post"
									enctype="multipart/form-data" class="myForm">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<div class="fileupload-preview thumbnail"></div>
										<input type="file" id="fichier" name="fichier" /> <span
											class="erreur">${errors['fichier']}</span>
										<div class="row">
											<div class="col-xs-5" id="formGauche">
												<div class="row ">
													<label>Nom <span>*</span></label>
												</div>
												<div class="row">
													<input class="form-control" type="text" id="lastName"
														name="lastName" value="${student.lastName}"
														placeholder="Nom" />
												</div>
												<span class="erreur">${errors['lastName']}</span>
											</div>
											<div class="formDroite col-xs-5">
												<div class="row">
													<label>Prénom<span>*</span></label>
												</div>
												<div class="row">
													<input class="form-control" type="text" id="firstName"
														name="firstName" value="${student.firstName}"
														placeholder="Prénom" />
												</div>
												<span class="erreur">${errors['firstName']}</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Date de naissance <span>*</span></label>
											</div>
											<div class="row date">
												<input class="form-control dateShow" type="text"
													id="birthday" name="birthday" value="${student.birthday}"
													placeholder="Date de naissance" />
											</div>
											<span class="erreur">${errors['birthday']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row ">
												<label>Lieu de naissance<span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="countryOfBirth"
													name="countryOfBirth" value="${student.countryOfBirth}"
													placeholder="Lieu de naissance" />
											</div>
											<span class="erreur">${errors['countryOfBirth']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Email <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="email" id="mail"
													name="mail" value="${student.mail}" placeholder="Email" />
											</div>
											<span class="erreur">${errors['mail']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Adresse <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="adress"
													name="adress" value="${student.adress}" placeholder="Adresse" />
											</div>
											<span class="erreur">${errors['adress']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Numéro Etudiant <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="studentNumber"
													name="studentNumber" value="${student.studentNumber}"
													placeholder="Ex: P2612" />
											</div>
											<span class="erreur">${errors['studentNumber']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Téléphone <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phone"
													name="phone" value="${student.phone}" placeholder="Téléphone" />
											</div>
											<span class="erreur">${errors['phone']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Sexe<span>*</span></label>
											</div>
											<div class="row">
												<select id="sexe"
													<input class="form-control" type="text" name="gender" value=getValueOption(gender) />>
													<option value="" disabled selected>sexe</option>
													<option value="0">Masculin</option>
													<option value="1">Féminin</option>
												</select>
											</div>
											<span class="erreur">${errors['gender']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Nationalité <span>*</span></label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="nationality"
													name="nationality" value="${student.nationality}"
													placeholder="Nationalité" />
											</div>
											<span class="erreur">${errors['nationality']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label>Niveau<span>*</span></label>
											</div>
											<div class="row">
												<select id="level"
													<input class="form-control" type="text" name="level" value="${student.level}" />>
													<option value="" disabled selected>Choisir le
														niveau</option>
													<option>Master 1</option>
													<option>Master 2</option>
													<option>1er Année</option>
													<option>2ième Année</option>
													<option>3ième Année</option>
													<option>Maitrîse</option>
													<option>Doctorat</option>
												</select>
											</div>
											<span class="erreur">${errors['level']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Programme<span>*</span></label>
											</div>
											<div class="row">
												<select id="program"
													<input class="form-control" type="text" name="program" value="${student.program}" />>
													<option value="" disabled selected>Choisir le
														programme</option>
													<option>M2ITIC/FOAD</option>
													<option>Algébre Appliquée</option>
													<option>DIETEL</option>
													<option>Energie Renouvelable</option>
													<option>Informatique</option>
													<option>MaDSI</option>
													<option>MAI</option>
													<option>MAIF</option>
													<option>MaRT</option>
													<option>Maths Appliquée</option>
													<option>MMAF</option>
													<option>MMSCI</option>
													<option>MMSTOCH</option>
													<option>Physique Appliquée</option>
													<option>Physique A Statistique Appliquée</option>
												</select>
											</div>
											<span class="erreur">${errors['program']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row">
												<label>Semestre<span>*</span></label>
											</div>
											<div class="row">
												<select id="semester"
													<input class="form-control" type="text" name="semester" value="${student.semester}" />>
													<option value="" disabled selected>choisir le
														semestre</option>
													<option>Semestre 1</option>
													<option>Semestre 2</option>
													<option>Autre</option>
												</select>
											</div>
											<span class="erreur">${errors['semester']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label>Boite Postale</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="bp" name="bp"
													value="${student.bp}" placeholder="Boite postale" />
											</div>
											<span class="erreur">${errors['bp']}</span>
										</div>
									</div>
									<h3>Personne à contacter</h3>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label> Nom </label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="lastNamePAC"
													name="lastNamePAC" value="${student.lastNamePAC}"
													placeholder="Nom" />
											</div>
											<span class="erreur">${errors['lastNamePAC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label> Prenom</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="firstNamePAC"
													name="firstNamePAC" value="${student.firstNamePAC}"
													placeholder="Prénom" />
											</div>
											<span class="erreur">${errors['firstNamePAC']}</span>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-5" id="formGauche">
											<div class="row ">
												<label> Telephone</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="phonePAC"
													name="phonePAC" value="${student.phonePAC}"
													placeholder="Telephone" />
											</div>
											<span class="erreur">${errors['phonePAC']}</span>
										</div>
										<div class="formDroite col-xs-5">
											<div class="row">
												<label> Adresse</label>
											</div>
											<div class="row">
												<input class="form-control" type="text" id="adressPAC"
													name="adressPAC" value="${student.adressPAC}"
													placeholder="Adresse" />
											</div>
											<span class="erreur">${errors['adressPAC']}</span>
										</div>
									</div>
									<!--      <input type="submit" value="Envoyer"class="sansLabel" />                   -->
									<div class="row myBtn">
										<input class="btn btn-danger " type="reset" value="Annuler" />
										<input class="btn btn-info " type="submit" value="Inscription" />

									</div>
								</form>
								<div class="fix scroll_to_top">
									<a href="#scroll_top" class="floatright">Remonter </a>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				</div>
			
			</div>
		</div>
	</div>
	<div class="col-sm-12 col-md-12 col-xs-12 footerContent">
		<c:import url="../Footer.jsp"></c:import>
	</div>
</body>
<script>
	$(function() {
		$("#overlay").click(function() {
			$("#cadre").fadeOut();
			$("#overlay").fadeOut();
		});
	});
</script>
<script type="text/javascript">
	$(function getValueOption(valueOption) {
		var selectedanswer = document.getElementById(valueOption).selectedIndex;
		return document.getElementsByTagName("option")[selectedanswer].value;
	});
</script>
</html>