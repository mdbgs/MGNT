package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
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
 * Servlet implementation class Animateur_RelecteurFormulaireServlet
 */
@WebServlet("/Animateur_RelecteurFormulaireServlet")
public class Animateur_RelecteurFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
private Connection connection;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Animateur_Relecteur.jsp").forward(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		
		Map<String, String> errors = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
		String nom = request.getParameter(LASTNAME);
		String prenom = request.getParameter(FIRSTNAME);
		String email = request.getParameter(MAIL);
		String telephone=request.getParameter(PHONE);
		String boitePostal=request.getParameter(BP);
		String affliationInstitutionnelle=request.getParameter(INSTITUTIONAFFILIATION);
		String type=request.getParameter(TYPE);
		
		Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			//date = dateFormat.parse(dateN);
			String valueFormation="'"+nom+"'%'"+prenom+"'%"+"%'"+email+"'%'"+telephone+"'%'"+ "'"+boitePostal+"'%" + "'"+affliationInstitutionnelle+"'%" + "'"+type+"'%";
			int rs= ComputeQueryBean.insertDatabase(valueFormation, "Animateur_Relecteur",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
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
		
		try {

			validationBoitePostale(boitePostal);

		} catch (Exception e) {

			errors.put(BP, e.getMessage());

		}
		try {

			validationAffiliationIns(affliationInstitutionnelle);

		} catch (Exception e) {

			errors.put(INSTITUTIONAFFILIATION, e.getMessage());

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

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Animateur_Relecteur.jsp").forward(request, response);

	}
	
	private void validationPrenom(String prenom) throws Exception {
		if(prenom.trim().length()==0)
			throw new Exception("Veuillez saisir le prénom svp");
			else
				if (prenom != null) {
					if(!prenom.matches("^\\D+$" ))
						throw new Exception("Le prenom doit uniquement contenir des lettres");
				
			}
		
		
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
	
	
	private void validationEmail(String email) throws Exception {

		if (email != null && email.trim().length() != 0) {

			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

				throw new Exception("Merci de saisir une adresse mail valide.");

			}

		} else {

			throw new Exception("Merci de saisir une adresse mail.");

		}

	}
	private void validationTelephone(String telephone) throws Exception{
		if ( telephone != null ) {

            if ( !telephone.matches( "^\\d+$" ) ) {

                throw new Exception( "Le numéro de téléphone est incorrect." );

            } else if ( telephone.length() < 9 ) {

                throw new Exception( "Le numéro de téléphone doit contenir au moins 9 chiffres." );

            }

       } else 
            throw new Exception( "Merci d'entrer un numéro de téléphone." );
        
		
	}

	private void validationAffiliationIns(String affliationIns) throws Exception{
		if(affliationIns.trim().length()==0)
			throw new Exception("Veuillez saisir l'affiliation institutionnelle svp");
		
	}
	
	private void validationBoitePostale(String boitePostale) throws Exception{
		if(boitePostale.trim().length()==0)
			throw new Exception("Veuillez saisir la boite postale svp");
		
	}
	
}
