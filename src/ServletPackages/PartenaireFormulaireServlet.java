package ServletPackages;

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

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;

/**
 * Servlet implementation class PartenaireFormulaire
 */
@WebServlet("/PartenaireFormulaireServelet")
public class PartenaireFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Partenaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;

		Map<String, String> erreurs = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */

		String nom = request.getParameter(NAME);
		String type=request.getParameter(TYPE);
		String email = request.getParameter(MAIL);
		String telephone=request.getParameter(PHONE);
		String adresse= request.getParameter(ADRESS);
		String boitePostale=request.getParameter(BP);
		String titreAcc=request.getParameter(ACC_TITLE);
		String domaineDeCollaboration=request.getParameter(COLLABORATION_D);
		String dateDeSignature=request.getParameter(SIGNDATE);
		String expirationDeLaccord=request.getParameter(ACC_EXPIRATION);
		String resultatAttendu=request.getParameter(ATT_RESULT);
		String projetConjoint=request.getParameter(CONJOINTPROJECT);
		
		Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD");
		 String dateNow = dateFormat.format(date);
		 String pseudo = "'"+nom;
		String valuePartenaire= "'%'ceamitic2016'%'"+dateNow+"'%'Partenaires'%'Inconnue'";
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertDatabase(pseudo+valuePartenaire, "compte",connection);
			int number = 0;
			while(rs==0){
				number++;
				pseudo+=number;
				rs = ComputeQueryBean.insertDatabase(pseudo+valuePartenaire, "compte",connection);
			}
			date = dateFormat.parse(dateDeSignature);
			date=dateFormat.parse(expirationDeLaccord);
			valuePartenaire=pseudo+"%" + "'"+nom+"'%" + "'"+type+"'%" + "'"+adresse+"'%" + "'"+telephone+"'%"
					 + "'"+email+"'%" + "'"+boitePostale+"'%" + "'"+titreAcc+"'%" +
					 "'"+domaineDeCollaboration+"'%" + dateFormat.format(date)+"%" +dateFormat.format(date)+"%"+"'"+resultatAttendu+"'%" +"'"+projetConjoint+"'%";
			rs= ComputeQueryBean.insertDatabase(valuePartenaire, "Partenaires",connection);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
		
		/* Validation du champ nom. */
		try {

			validationNom(nom);

		} catch (Exception e) {

			erreurs.put(NAME, e.getMessage());

		}
		 
		/* Validation du champ email. */
		try {

			validationType(type);

		} catch (Exception e) {

			erreurs.put(TYPE, e.getMessage());

		}
 
		
		/* Validation du champ email. */
		try {

			validationEmail(email);

		} catch (Exception e) {

			erreurs.put(MAIL, e.getMessage());

		}
		/* Validation du champ téléphone*/
		try{
			validationTelephone(telephone);
			
		} catch(Exception e){
			
			erreurs.put(PHONE, e.getMessage());
		}
	
		/* Validation du champ adresse*/
		
		
		try {

			validationAdresse(adresse);

		} catch (Exception e) {

			erreurs.put(adresse, e.getMessage());

		}
		/* Validation du champ boite postale*/
		try {

			validationBoitePostale(boitePostale);

		} catch (Exception e) {

			erreurs.put(BP, e.getMessage());

		}
		
		/* Validation du champ titre de l'accord*/
		try {

			validationTitre(titreAcc);

		} catch (Exception e) {

			erreurs.put(ACC_TITLE, e.getMessage());

		}
		
		/* Validation du champ domaine de collaboration*/
		try {

			validationDomaineCollaboration(domaineDeCollaboration);

		} catch (Exception e) {

			erreurs.put(COLLABORATION_D, e.getMessage());

		}
		
		/* Validation du champ date de signature*/
		try {

			validationDateSignature(dateDeSignature);

		} catch (Exception e) {

			erreurs.put(SIGNDATE, e.getMessage());

		}
		
		/* Validation du champ Expiration de l'accord*/
		try {

			validationExpirationDeLaccord(expirationDeLaccord);

		} catch (Exception e) {

			erreurs.put(ACC_EXPIRATION, e.getMessage());

		}
		
		/* Validation du champ resultat attendu*/
		try {

			validationResultatAttendu(domaineDeCollaboration);

		} catch (Exception e) {

			erreurs.put(RESULT, e.getMessage());

		}
		
		/* Validation du champ projet conjoint*/
		try {

			validationProjetConjoint(projetConjoint);

		} catch (Exception e) {

			erreurs.put(CONJOINTPROJECT, e.getMessage());

		}

		
		if (erreurs.isEmpty()) {

			resultat = "Succès de l'inscription.";

		} else {

			resultat = "Échec de l'inscription.";

		}
		/* Stockage du résultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, erreurs);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response à notre JSP */

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Partenaire.jsp").forward(request, response);

	}
	
	
	private void validationPartener(String numeroPartenaire) throws Exception {
		 
			
		
		
	}

	private void validationNom(String nom) throws Exception {
		if(nom.trim().length()==0)
			throw new Exception("Veuillez saisir le nom svp");
			else
				if (nom != null) {
					if(!nom.matches("^\\D+$" ))
						throw new Exception("Le nom doit uniquement contenir des lettres");

		}

	}
	
	private void validationType(String type) {
		
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
	public void validationTelephone(String telephone) throws Exception{
		if ( telephone != null ) {

            if ( !telephone.matches( "^\\d+$" ) ) {

                throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );

            } else if ( telephone.length() < 9 ) {

                throw new Exception( "Le numéro de téléphone doit contenir au moins 9 chiffres." );

            }

        } else {

            throw new Exception( "Merci d'entrer un numéro de téléphone." );
        }
		
	}
	
	
	private void validationAdresse(String adresse) {
		
	}
	
	private void validationBoitePostale(String boitePostale) {
	}
	
	private void validationTitre(String titreAcc) {
		
	}
	
	private void validationExpirationDeLaccord(String expirationDeLaccord) {
		
	}
	private void validationDomaineCollaboration(String domaineDeCollaboration) {
		
	}
	private void validationDateSignature(String dateDeSignature) {
		
	}
	private void validationResultatAttendu(String domaineDeCollaboration) {
		
	}
	
	private void validationProjetConjoint(String projetConjoint) {
		
	}

}
