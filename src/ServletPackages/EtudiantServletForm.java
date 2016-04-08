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
		 * Lecture du param�tre 'chemin' pass� � la servlet via la d�claration
		 * dans le web.xml
		 */
		String chemin = this.getServletConfig().getInitParameter(CHEMIN);

		/* R�cup�ration du contenu du champ de description */
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
		 * Les donn�es re�ues sont multipart, on doit donc utiliser la m�thode
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
		 * Il faut d�terminer s'il s'agit d'un champ classique ou d'un champ de
		 * type fichier : on d�l�gue cette op�ration � la m�thode utilitaire
		 * getNomFichier().
		 */
		String nomFichier = getNomFichier(part);

		/*
		 * Si la m�thode a renvoy� quelque chose, il s'agit donc d'un champ de
		 * type fichier (input type="file").
		 */
		if (nomFichier != null && !nomFichier.isEmpty()) {
			String nomChamp = part.getName();
			/*
			 * Antibug pour Internet Explorer, qui transmet pour une raison
			 * mystique le chemin du fichier local � la machine du client...
			 * 
			 * Ex : C:/dossier/sous-dossier/fichier.ext
			 * 
			 * On doit donc faire en sorte de ne s�lectionner que le nom et
			 * l'extension du fichier, et de se d�barrasser du superflu.
			 */
			nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
					.substring(nomFichier.lastIndexOf('\\') + 1);

			/* �criture du fichier sur le disque */
			ecrireFichier(part, nomFichier, chemin);

			request.setAttribute(nomChamp, nomFichier);
		}

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/*
	 * M�thode utilitaire qui a pour unique but d'analyser l'en-t�te
	 * "content-disposition", et de v�rifier si le param�tre "filename" y est
	 * pr�sent. Si oui, alors le champ trait� est de type File et la m�thode
	 * retourne son nom, sinon il s'agit d'un champ de formulaire classique et
	 * la m�thode retourne null.
	 */
	public String getNomFichier(Part part) {
		/*
		 * Boucle sur chacun des param�tres de l'en-t�te "content-disposition".
		 */
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			/* Recherche de l'�ventuelle pr�sence du param�tre "filename". */
			if (contentDisposition.trim().startsWith("filename")) {
				/*
				 * Si "filename" est pr�sent, alors renvoi de sa valeur,
				 * c'est-�-dire du nom de fichier sans guillemets.
				 */
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		/* Et pour terminer, si rien n'a �t� trouv�... */
		return null;
	}

	/*
	 * M�thode utilitaire qui a pour unique but de lire l'InputStream contenu
	 * dans l'objet part, et de le convertir en une banale cha�ne de caract�res.
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
	 * M�thode utilitaire qui a pour but d'�crire le fichier pass� en param�tre
	 * sur le disque, dans le r�pertoire donn� et avec le nom donn�.
	 */
	public void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
		/* Pr�pare les flux. */
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
			/* Ouvre les flux. */
			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

			/*
			 * Lit le fichier re�u et �crit son contenu dans un fichier sur le
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