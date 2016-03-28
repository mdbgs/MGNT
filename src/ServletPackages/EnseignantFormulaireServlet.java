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
 * Servlet implementation class EnseignantFormulaireServlet
 */
@WebServlet("/EnseignantFormulaireServlet")
public class EnseignantFormulaireServlet extends ConnexionServlet implements  NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Enseignant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;

		Map<String, String> erreurs = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */

		String numeroEnseignant=request.getParameter(TEACHERNUMBER);
		String prenom = request.getParameter(FIRSTNAME);
		String nom = request.getParameter(LASTNAME);
		String email = request.getParameter(MAIL);
		String telephone=request.getParameter(PHONE);
		String niveau= request.getParameter(LEVEL);
		String programme= request.getParameter(PROGRAM);
		String sexe= request.getParameter(GENDER);
		String nationalite= request.getParameter(NATIONALITY);
		String adresse= request.getParameter(ADRESS);
		String boitePostale=request.getParameter(BP);
		String affliationIns=request.getParameter(INSTITUTIONAFFILIATION);
		
		Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String dateNow = dateFormat.format(date);
		 String pseudo = "'"+nom+"."+prenom;
		String valueEnseignant="%'ceamitic2016'%"+dateNow+"%'Enseignant'%'Inconnue'";
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertDatabase(pseudo+valueEnseignant, "compte",connection);
			int number = 0;
			while(rs==0){
				number++;
				pseudo+=number;
				rs = ComputeQueryBean.insertDatabase(pseudo+valueEnseignant, "compte",connection);
			}
			valueEnseignant=pseudo+"%" + "'"+nom+"'%" + "'"+prenom+"'%" + "'"+niveau+"'%" + "'"+nationalite+"'%"
					 + "'"+adresse+"'%" + "'"+email+"'%" + "'"+telephone+"'%" +
					 "'"+boitePostale+"'%" + ""+sexe+"%" +"'"+affliationIns+"'%";
			rs= ComputeQueryBean.insertDatabase(valueEnseignant, "Enseignant",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		/* Validation du champ prenom. */
		try {

			validationPrenom(prenom);

		} catch (Exception e) {

			erreurs.put(FIRSTNAME, e.getMessage());

		}
		
		/* Validation du champ nom. */
		try {

			validationNom(nom);

		} catch (Exception e) {

			erreurs.put(LASTNAME, e.getMessage());

		}
		/* Validation du champ nom. */
		try {

			validationNumEnseignant(numeroEnseignant);

		} catch (Exception e) {

			erreurs.put(TEACHERNUMBER, e.getMessage());

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
		
		try {

			validationNiveau(niveau);

		} catch (Exception e) {

			erreurs.put(LEVEL, e.getMessage());

		}
		
		try {

			validationProgramme(programme);

		} catch (Exception e) {

			erreurs.put(PROGRAM, e.getMessage());

		}
	

		try {

			validationNationalite(nationalite);

		} catch (Exception e) {

			erreurs.put(NATIONALITY, e.getMessage());

		}
		
		try {

			validationAdresse(adresse);

		} catch (Exception e) {

			erreurs.put(adresse, e.getMessage());

		}
		
		try {

			validationBoitePostale(boitePostale);

		} catch (Exception e) {

			erreurs.put(BP, e.getMessage());

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

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Enseignant.jsp").forward(request, response);

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
	
	public void validationNumEnseignant(String numeroEnseignant){
		
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
	
	
	public void validationNiveau(String niveau){
		
	}
	
	public void validationProgramme(String programme){
		
	}
	private void validationRegion(String region) {
		
	}

	private void validationNationalite(String nationalite) {
		
	}

	private void validationProgrammeLieuDeNaissance(String programme) {
		
	}
	
	private void validationSemestre(String semestre) {
	}
	
	private void validationAdresse(String adresse) {
		
	}
	
	private void validationBoitePostale(String boitePostale) {
		
	}
	


}
