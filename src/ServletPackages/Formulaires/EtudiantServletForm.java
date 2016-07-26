package ServletPackages.Formulaires;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;
import Enumeration.EnumNiveau;
import ModelPackage.Student;
import ServletPackages.GetAuthorisationUsers;

public class EtudiantServletForm extends GetAuthorisationUsers implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public static final String VUE = "/WEB-INF/jsp/Formulaire/EtudiantFormulaire.jsp";

	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FICHIER = "fichier";

	public static final String CHEMIN = "chemin";
	public static final int TAILLE_TAMPON = 10240; // 10
													// ko

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			connection = this.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String role= (String) request.getParameter("role");
		if(role!=null && !role.equals("rse")){
			Student student=null;
			ResultSet result = ComputeQueryBean.selectAllByPseudo("etudiant", role, connection);
			try {
				while (result.next()) {
					student= new Student(result.getInt(1), result.getString(2),result.getString(3), result.getString(4), Integer.toString(result.getInt(5)), result.getString(6),
							result.getString(7), result.getString(8), result.getString(9), result.getString(10),
							result.getString(11), result.getString(12), Integer.toString(result.getInt(13)), result.getString(14), result.getString(15),
							result.getString(16), result.getString(17), result.getString(18), result.getString(19), result.getString(20), result.getString(21));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("etudiantRecu", student);
			String level = student.getLevel();
			List<String> listNiveau= new ArrayList<>();
			List<String> listNiveauWhitout= new ArrayList<>();
			for(EnumNiveau niveau:EnumNiveau.values()){
				if(!level.equals(niveau))
					listNiveauWhitout.add(niveau.toString());
				listNiveau.add(niveau.toString());
			}
			request.setAttribute("listNiveau", listNiveau);
			request.setAttribute("listNiveauWhitout", listNiveauWhitout);
			this.doGet(request, response, "etudiant", "Formulaire/EtudiantFormulaire.jsp", connection);
		}
		else 
			if(role.equals("rse"))
				this.doGet(request, response, "responsable_Suivi_Evaluation", "Formulaire/EtudiantFormulaire.jsp", connection);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */
		String resultat;
		Map<String, String> errors = new HashMap<String, String>();
		String chemin = this.getServletConfig().getInitParameter(CHEMIN);
		Part part = request.getPart(CHAMP_FICHIER);
		/* Récupération du contenu du champ de description */
		String description = request.getParameter(CHAMP_DESCRIPTION);
		request.setAttribute(CHAMP_DESCRIPTION, description);
		String numeroEtudiant = "null";
		if (request.getParameter(STUDENTNUMBER) != "") {
			numeroEtudiant = request.getParameter(STUDENTNUMBER);
		}
		String prenom = "null";
		String nom = "null";
		String dateN = "null";
		String phonePAC = "null";
		String adressePAC = "null";
		String niveau = "null";
		String adresse = "null";
		String programme = "null";
		String semestre = "null";
		String sexe = "null";
		String lieuDeNaiss = "null";
		String nationalite = "null";
		String boitePostale = "null";
		String email = "null";
		String telephone = "null";
		String nomPAC = "null";
		String prenomPAC = "null";
		String fichier = "null";
		
       
        
		if (request.getParameter(FIRSTNAME) != "") {
			prenom = request.getParameter(FIRSTNAME);
		}
		if (request.getParameter(LASTNAME) != "") {
			nom = request.getParameter(LASTNAME);
		}
		if (request.getParameter(BIRTHDAY) != "") {
			dateN = request.getParameter(BIRTHDAY);
		}
		if (request.getParameter(MAIL) != "") {
			email = request.getParameter(MAIL);
		}
		if (request.getParameter(PHONE) != "") {
			telephone = request.getParameter(PHONE);
		}
		if (request.getParameter(PacLASTNAME) != "") {
			nomPAC = request.getParameter(PacLASTNAME);
		}
		if (request.getParameter(PacFIRSTNAME) != "") {
			prenomPAC = request.getParameter(PacFIRSTNAME);
		}
		if (request.getParameter(PacPHONE) != "") {
			phonePAC = request.getParameter(PacPHONE);
		}
		if (request.getParameter(PacADRESS) != "") {
			adressePAC = request.getParameter(PacADRESS);
		}
		if (request.getParameter(LEVEL) != "") {
			niveau = request.getParameter(LEVEL);
		}
		if (request.getParameter(ADRESS) != "") {
			adresse = request.getParameter(ADRESS);
		}
		if (request.getParameter(PROGRAM) != "") {
			programme = request.getParameter(PROGRAM);
		}
		if (request.getParameter(SEMESTER) != "") {
			semestre = request.getParameter(SEMESTER);
		}
		if (request.getParameter(GENDER) != "") {
			sexe = request.getParameter(GENDER);
		}
		if (request.getParameter(COUNTRYOFBIRTH) != "") {
			lieuDeNaiss = request.getParameter(COUNTRYOFBIRTH);
		}
		if (request.getParameter(NATIONALITY) != "") {
			nationalite = request.getParameter(NATIONALITY);
		}
		if (request.getParameter(BP) != "") {
			boitePostale = request.getParameter(BP);
			System.out.println();
		}
		
		fichier = getNomFichier(part);

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateNow = dateFormat.format(date);
		String pseudo = ("'" + nom + "." + prenom).replaceAll("\\s", "_");
		System.out.println(pseudo);

		String password = "ceamitic2016";
		Vernam passCrypt = new Vernam(password);
		password = passCrypt.encry();
		String valueEtudiant = "'%'" + password + "'%" + dateNow + "%'" + fichier + "'";
		System.out.println(valueEtudiant);
		try {
			System.out.println();
			connection = this.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertInAllTable(pseudo + valueEtudiant, "compte", connection);
			date = dateFormat.parse(dateN);
			valueEtudiant = "%" + pseudo + "'%" + "'" + nom + "'%'" + prenom + "'%" + dateFormat.format(date) + "%'"
					+ lieuDeNaiss + "'%'" + niveau + "'%'" + nationalite + "'%'" + adresse + "'%'" + email + "'%'"
					+ telephone + "'%'" + boitePostale + "'%" + sexe + "%" + "'" + numeroEtudiant + "'%" + "'" + nomPAC
					+ "'%" + "'" + prenomPAC + "'%'" + phonePAC + "'%'" + adressePAC + "'%'" + programme + "'%'"
					+ semestre + "'";
			if (rs == 1) { // si la création de compte a reussi alors insérer
							// l'étudiant et users_roles
				rs = ComputeQueryBean.insertInAllTable(valueEtudiant, "Etudiant", connection);
				valueEtudiant = pseudo + "'%" + "'etudiant'";
				rs = ComputeQueryBean.insertUsersRoles(valueEtudiant, "users_roles", connection);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		// validation photo
		try {
			validationPhoto(part);

		} catch (Exception g) {

			errors.put(FICHIER, g.getMessage());
		}
		/* Validation du champ prenom. */
		try {
			validationPrenom(prenom);

		} catch (Exception e) {

			errors.put(FIRSTNAME, e.getMessage());

		}

		/* Validation du champ nom. */
		try {

			validationNom(nom);

		} catch (Exception e) {

			errors.put(LASTNAME, e.getMessage());

		}
		/* Validation du champ numero etudiant. */
		try {

			validationNumEtudiant(numeroEtudiant);

		} catch (Exception e) {

			errors.put(STUDENTNUMBER, e.getMessage());

		}
		/* Validation du champ email. */
		try {

			validationEmail(email);

		} catch (Exception e) {

			errors.put(MAIL, e.getMessage());

		}
		/* Validation du champ téléphone */
		try {
			validationTelephone(telephone);

		} catch (Exception e) {

			errors.put(PHONE, e.getMessage());
		}
		/* Validation du champ niveau. */

		try {

			validationNiveau(niveau);

		} catch (Exception e) {

			errors.put(LEVEL, e.getMessage());

		}

		try {

			validationProgramme(programme);

		} catch (Exception e) {

			errors.put(PROGRAM, e.getMessage());

		}
		try {

			validationSemestre(semestre);

		} catch (Exception e) {

			errors.put(SEMESTER, e.getMessage());

		}
		try {

			validationLieuDeNaissance(lieuDeNaiss);

		} catch (Exception e) {

			errors.put(COUNTRYOFBIRTH, e.getMessage());

		}
		try {

			validationNationalite(nationalite);

		} catch (Exception e) {

			errors.put(NATIONALITY, e.getMessage());

		}

		if (errors.isEmpty()) {

			resultat = "Succès de l'inscription.";

		} else {

			resultat = "Échec de l'inscription.";

		}
		/* Stockage du résultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, errors);

		request.setAttribute(RESULT, resultat);

		/*
		 * Il faut déterminer s'il s'agit d'un champ classique ou d'un champ de
		 * type fichier : on délègue cette opération à la méthode utilitaire
		 * getNomFichier().
		 */
		String nomFichier = getNomFichier(part);

		/*
		 * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ de
		 * type fichier (input type="file").
		 */
		if (nomFichier != null && !nomFichier.isEmpty()) {
			String nomChamp = part.getName();

			/*
			 * Antibug pour Internet Explorer, qui transmet pour une raison
			 * mystique le chemin du fichier local à la machine du client...
			 * 
			 * Ex : C:/dossier/sous-dossier/fichier.ext
			 * 
			 * On doit donc faire en sorte de ne sélectionner que le nom et
			 * l'extension du fichier, et de se débarrasser du superflu.
			 */
			nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
					.substring(nomFichier.lastIndexOf('\\') + 1);

			/* Écriture du fichier sur le disque */
			ecrireFichier(part, nomFichier, chemin);

			request.setAttribute(nomChamp, nomFichier);
		}
 
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	private void validationPhoto(Part part) throws Exception {
		if (!part.getContentType().substring(0, 5).equals("image")) {
			throw new Exception("format invalide :veuillez choisir une image");

		}
	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom.trim().length() == 0)
			throw new Exception("Veuillez saisir le prénom svp");
		else if (prenom != null) {
			if (!prenom.matches("^\\D+$"))
				throw new Exception("Le prenom doit uniquement contenir des lettres");

		}

	}

	private void validationNom(String nom) throws Exception {
		if (nom.trim().length() == 0)
			throw new Exception("Veuillez saisir le nom svp");
		else if (nom != null) {
			if (!nom.matches("^\\D+$"))
				throw new Exception("Le nom doit uniquement contenir des lettres");

		}

	}

	private void validationNumEtudiant(String numeroEtudiant) {

	}

	private void validationEmail(String email) throws Exception {

		if (email != null && email.trim().length() != 0) {

			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

				throw new Exception("Merci de saisir une adresse mail valide.");

			}

		} else {

			throw new Exception("Merci de saisir une adresse mail.");

		}

	}

	private void validationTelephone(String telephone) throws Exception {
		if (telephone != null) {

			if (!telephone.matches("^\\d+$")) {

				throw new Exception("Le numéro de téléphone est incorrect.");

			} else if (telephone.length() < 9) {
				throw new Exception("Le numéro de téléphone doit contenir au moins 9 chiffres.");

			}

		} else {

			throw new Exception("Merci d'entrer un numéro de téléphone.");
		}

	}

	private void validationNiveau(String niveau) throws Exception {
		if (niveau.trim().length() == 0)
			throw new Exception("Veuillez saisir le niveau svp");

	}

	private void validationProgramme(String programme) throws Exception {
		if (programme.trim().length() == 0)
			throw new Exception("Veuillez saisir le programme svp");

	}

	private void validationNationalite(String nationalite) throws Exception {
		if (nationalite.trim().length() == 0)
			throw new Exception("Veuillez saisir la nationalité svp");

	}

	private void validationLieuDeNaissance(String lieuDeNaiss) throws Exception {
		if (lieuDeNaiss.trim().length() == 0)
			throw new Exception("Veuillez saisir le lieu de naissance svp");
	}

	private void validationSemestre(String semestre) throws Exception {
		if (semestre.trim().length() == 0)
			throw new Exception("Veuillez saisir le semestre svp");
	}

	public String getNomFichier(Part part) {
		/*
		 * Boucle sur chacun des paramètres de l'en-tête "content-disposition".
		 */
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			/* Recherche de l'éventuelle présence du paramètre "filename". */
			if (contentDisposition.trim().startsWith("filename")) {
				/*
				 * Si "filename" est présent, alors renvoi de sa valeur,
				 * c'est-à-dire du nom de fichier sans guillemets.
				 */
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		/* Et pour terminer, si rien n'a été trouvé... */
		return null;
	}

	/*
	 * Méthode utilitaire qui a pour unique but de lire l'InputStream contenu
	 * dans l'objet part, et de le convertir en une banale chaîne de caractères.
	 */
	// public String getValeur( Part part ) throws IOException {
	// BufferedReader reader = new BufferedReader( new InputStreamReader(
	// part.getInputStream(), "UTF-8" ) );
	// StringBuilder valeur = new StringBuilder();
	// char[] buffer = new char[1024];
	// int longueur = 0;
	// while ( ( longueur = reader.read( buffer ) ) > 0 ) {
	// valeur.append( buffer, 0, longueur );
	// }
	// return valeur.toString();
	// }

	/*
	 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
	 * sur le disque, dans le répertoire donné et avec le nom donné.
	 */
	public void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
		/* Prépare les flux. */
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
			/* Ouvre les flux. */
			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

			/*
			 * Lit le fichier reçu et écrit son contenu dans un fichier sur le
			 * disque.
			 */
			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} catch (IOException ignore) {
			ignore.printStackTrace();
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {
			}
			try {
				entree.close();
			} catch (IOException ignore) {
			}
		}
	}
}