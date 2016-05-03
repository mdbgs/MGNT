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
public class PartenaireFormulaireServlet extends GetAuthorisationUsers implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection ;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				connection=this.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		this.doGet(request, response, "responsable_Suivi_Evaluation", "Partenaire.jsp", connection);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;

		Map<String, String> errors = new HashMap<String, String>();

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
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String dateNow = dateFormat.format(date);
		 String pseudo = "'"+nom;
		 String valuePartenaire="'%'ceamitic2016'%"+dateNow+"%'inconnu'%";
		//ConnexionServlet servlet = new ConnexionServlet();
		try {
			connection = this.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertDatabase(pseudo+valuePartenaire,"compte",connection);
//			int number = 0;
//			while(rs==0){
//				number++;
//				pseudo+=number;
//				rs = ComputeQueryBean.insertDatabase(pseudo+valuePartenaire, "compte",connection);
//			}
			date = dateFormat.parse(dateDeSignature);
			date=dateFormat.parse(expirationDeLaccord);
			valuePartenaire="%"+pseudo+"'%" + "'"+nom+"'%" + "'"+type+"'%" + "'"+adresse+"'%" + "'"+telephone+"'%"
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

			errors.put(NAME, e.getMessage());

		}
		 
		/* Validation du champ type. */
		try {

			validationType(type);

		} catch (Exception e) {

			errors.put(TYPE, e.getMessage());

		}
 
		
		/* Validation du champ email. */
		try {

			validationEmail(email);

		} catch (Exception e) {

			errors.put(MAIL, e.getMessage());

		}
		/* Validation du champ téléphone*/
		try{
			validationTelephone(telephone);
			
		} catch(Exception e){
			
			errors.put(PHONE, e.getMessage());
		}
	
		/* Validation du champ adresse*/
		
		
		try {

			validationAdresse(adresse);

		} catch (Exception e) {

			errors.put(adresse, e.getMessage());

		}
		/* Validation du champ boite postale*/
		try {

			validationBoitePostale(boitePostale);

		} catch (Exception e) {

			errors.put(BP, e.getMessage());

		}
		
		/* Validation du champ titre de l'accord*/
		try {

			validationTitre(titreAcc);

		} catch (Exception e) {

			errors.put(ACC_TITLE, e.getMessage());

		}
		
		/* Validation du champ domaine de collaboration*/
		try {

			validationDomaineCollaboration(domaineDeCollaboration);

		} catch (Exception e) {

			errors.put(COLLABORATION_D, e.getMessage());

		}
		
		/* Validation du champ date de signature*/
		try {

			validationDateSignature(dateDeSignature);

		} catch (Exception e) {

			errors.put(SIGNDATE, e.getMessage());

		}
		
		/* Validation du champ Expiration de l'accord*/
		try {

			validationExpirationDeLaccord(expirationDeLaccord);

		} catch (Exception e) {

			errors.put(ACC_EXPIRATION, e.getMessage());

		}
		
		/* Validation du champ resultat attendu*/
		try {

			validationResultatAttendu(resultatAttendu);

		} catch (Exception e) {

			errors.put(ATT_RESULT, e.getMessage());

		}
		
		/* Validation du champ projet conjoint*/
		try {

			validationProjetConjoint(projetConjoint);

		} catch (Exception e) {

			errors.put(CONJOINTPROJECT, e.getMessage());

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

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Partenaire.jsp").forward(request, response);

	}
	
	private void validationNom(String nom) throws Exception {
		if(nom.trim().length()==0)
			throw new Exception("Veuillez saisir le nom svp");
			

	}
	
	private void validationType(String type) throws Exception {
		if(type.trim().length()==0)
			throw new Exception("Veuillez saisir le type svp");
		
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
	
	
	private void validationAdresse(String adresse) throws Exception{
		
		if(adresse.trim().length()==0)
			throw new Exception("Veuillez saisir l'adresse svp");
	}
	
	private void validationBoitePostale(String boitePostale) throws Exception{
		if(boitePostale.trim().length()==0)
			throw new Exception("Veuillez saisir la boite postale svp");
	}
	
	private void validationTitre(String titreAcc) throws Exception{
		if(titreAcc.trim().length()==0)
			throw new Exception("Veuillez saisir le titre svp");
		
	}
	
	private void validationExpirationDeLaccord(String expirationDeLaccord) throws Exception{
		if(expirationDeLaccord.trim().length()==0)
			throw new Exception("Veuillez saisir l'expiration de l'accord svp");
		
	}
	private void validationDomaineCollaboration(String domaineDeCollaboration) throws Exception{
		if(domaineDeCollaboration.trim().length()==0)
			throw new Exception("Veuillez saisir le domaine de collaboration svp");
		
	}
	private void validationDateSignature(String dateDeSignature) throws Exception{
		if(dateDeSignature.trim().length()==0)
			throw new Exception("Veuillez saisir la date de signature svp");
		
	}
	private void validationResultatAttendu(String resultatAttendu) throws Exception {
		if(resultatAttendu.trim().length()==0)
			throw new Exception("Veuillez saisir le resultat attendu svp");
		
	}
	
	private void validationProjetConjoint(String projetConjoint) throws Exception{
		if(projetConjoint.trim().length()==0)
			throw new Exception("Veuillez saisir le projet conjoint svp");
		
	}

}
