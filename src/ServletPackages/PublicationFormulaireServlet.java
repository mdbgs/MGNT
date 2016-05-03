package ServletPackages;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;
import ModelPackage.User;

/**
 * Servlet implementation class PubllicationFromulaireServlet
 */
@WebServlet("/PubllicationFromulaireServlet")
public class PublicationFormulaireServlet extends GetAuthorisationUsers implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_FICHIER = "fichier";
	private Connection connection;
	public static final String CHEMIN = "chemin";
	public static final int TAILLE_TAMPON = 10240;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			connection=this.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    this.doGet(req, resp, "responsable_Suivi_Evaluation", "Publication.jsp", connection);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		User user = (User) request.getSession().getAttribute("user");
		Map<String, String> errors = new HashMap<String, String>();
		Part part = request.getPart(CHAMP_FICHIER);
		String chemin = this.getServletConfig().getInitParameter(CHEMIN);
		/* Récupération des champs du formulaire. */
		String responsable=request.getParameter(RESPONSABLE);
		responsable=user.getPseudo();
		int id=1;
		String titre = request.getParameter(TITLE);
		String datePub = request.getParameter(DATEPUB);
		String nomJournal = request.getParameter(NOMJOURNAL);
		String auteur=request.getParameter(AUTHOR);
		String facteurImpact=request.getParameter(IMPACTFACTOR);
		String type=request.getParameter(MONTYPE);
		System.out.println(titre+"kk ");
		String fileupload=getNomFichier(part);
         System.out.println(getNomFichier(part)+"kk ");		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			connection = this.getDataSource().getConnection();
			date = dateFormat.parse(datePub);
			String valuePublication="%'"+id+"'%"+"'"+titre+"'%"+dateFormat.format(date)+"%'"+nomJournal+"'%"+"'"+auteur+"'%'"+facteurImpact+"'%'"+type+"'%'"+fileupload+"'";
			int rs= ComputeQueryBean.insertDatabase(valuePublication, "Publication",connection);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
		
		/* Validation du champ titre. */
		try {

			validationTitre(titre);

		} catch (Exception e) {

			errors.put(TITLE, e.getMessage());

		}
				
		/* Validation du champ nom journal. */
		try {

			validationNomJournal(nomJournal);

		} catch (Exception e) {

			errors.put(NOMJOURNAL, e.getMessage());

		}
		
		/* Validation du champ nom journal. */
		try {

			validationAuteur(auteur);

		} catch (Exception e) {

			errors.put(AUTHOR, e.getMessage());

		}
		if (errors.isEmpty()) {

			resultat = "Succès de l'inscription.";

		} else {

			resultat = "Échec de l'inscription.";

		}
		/* Stockage du résultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, errors);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response à notre JSP */

		//request.getRequestDispatcher("/WEB-INF/jsp/Publication.jsp").forward(request, response);

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

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Publication.jsp").forward(request, response);
	}

	public String getNomFichier(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			/* Recherche de l'éventuelle présence du paramètre "filename". */
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
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
	
	private void validationTitre(String titre) throws Exception{
		if(titre.trim().length()==0)
			throw new Exception("Veuillez saisir le titre svp");
		
	}
	
	private void validationNomJournal(String nomJournal) throws Exception{
		if(nomJournal.trim().length()==0)
			throw new Exception("Veuillez saisir le nom du journal svp");
		
	}
	

	private void validationAuteur(String auteur) throws Exception{
		if(auteur.trim().length()==0)
			throw new Exception("Veuillez saisir l'auteur svp");
		
	}
	
}

