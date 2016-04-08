package ServletPackages;

import java.io.BufferedInputStream;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class EtudiantServletForm extends ConnexionServlet implements NumericConstant {
	public static final String VUE = "/WEB-INF/jsp/EtudiantFormulaire.jsp";

	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FICHIER = "fichier";

	public static final String CHEMIN = "chemin";
	public static final int TAILLE_TAMPON = 10240; // 10
													// ko

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'envoi de fichiers */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */
		String chemin = this.getServletConfig().getInitParameter(CHEMIN);

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

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateNow = dateFormat.format(date);
		String pseudo = ("'" + nom + "." + prenom).replaceAll("\\s", "_");
		System.out.println(pseudo);

		Part part = request.getPart(CHAMP_FICHIER);
		// String valueEtudiant=
		// "'%'ceamitic2016'%"+dateNow+"%'Etudiant'%'Inconnue'";
		String valueEtudiant = "'%'ceamitic2016'%" + dateNow + "%'" + chemin + getNomFichier(part) + "'";
		System.out.println(valueEtudiant);
		/*
		 * Les données reçues sont multipart, on doit donc utiliser la méthode
		 * getPart() pour traiter le champ d'envoi de fichiers.
		 */

		Connection connection;
		try {

			System.out.println();
			connection = this.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertDatabase(pseudo + valueEtudiant, "compte", connection);
			// int number = 0;
			// while(rs==0){
			// number++;
			// pseudo+=number;
			// rs = ComputeQueryBean.insertDatabase(pseudo+valueEtudiant,
			// "compte",connection);
			// }
			date = dateFormat.parse(dateN);
			valueEtudiant = "%" + pseudo + "'%" + "'" + nom + "'%'" + prenom + "'%" + dateFormat.format(date) + "%'"
					+ lieuDeNaiss + "'%'" + niveau + "'%'" + nationalite + "'%'" + adresse + "'%'" + email + "'%'"
					+ telephone + "'%'" + boitePostale + "'%" + sexe + "%" + "'" + numeroEtudiant + "'%" + "'" + nomPAC
					+ "'%" + "'" + prenomPAC + "'%'" + phonePAC + "'%'" + adressePAC + "'%'" + programme + "'%'"
					+ semestre + "'";
			System.out.print(valueEtudiant);
			rs = ComputeQueryBean.insertDatabase(valueEtudiant, "Etudiant", connection);

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

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

	/*
	 * Méthode utilitaire qui a pour unique but d'analyser l'en-tête
	 * "content-disposition", et de vérifier si le paramètre "filename" y est
	 * présent. Si oui, alors le champ traité est de type File et la méthode
	 * retourne son nom, sinon il s'agit d'un champ de formulaire classique et
	 * la méthode retourne null.
	 */
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