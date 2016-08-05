package ServletPackages.Formulaires;

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
import Enumeration.NumericConstant;
import ServletPackages.GetAuthorisationUsers;

/**
 * Servlet implementation class EnseignantFormulaireServlet
 */
@WebServlet("/EnseignantFormulaireServlet")
public class EnseignantFormulaireServlet extends GetAuthorisationUsers implements  NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				connection=this.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		this.doGet(request, response, "responsable_Suivi_Evaluation", "Formulaire/Enseignant.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;

		Map<String, String> errors = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
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
		 String pseudo = "'"+nom+"."+prenom+"'";
		 String passwd;
		 Vernam passCrypt=new Vernam("ceamitic2016");
			passwd = passCrypt.encry();
		String valueEnseignant="%'"+passwd+"'%"+dateNow+"%'inconnu'%";
		ConnexionServlet servlet = new ConnexionServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertInAllTable(pseudo+valueEnseignant, "compte",connection);
//			int number = 0;
//			while(rs==0){
//				number++;
//				pseudo+=number;
//				rs = ComputeQueryBean.insertDatabase(pseudo+valueEnseignant, "compte",connection);
//			}
			valueEnseignant="%"+pseudo+"%" + "'"+nom+"'%" + "'"+prenom+"'%" + "'"+niveau+"'%" + "'"+nationalite+"'%"
					 + "'"+adresse+"'%" + "'"+email+"'%" + "'"+telephone+"'%" +
					 "'"+boitePostale+"'%" + ""+sexe+"%" +"'"+affliationIns+"'%";
			if(rs==1)
			{ //si la création de compte a reussi alors insérer l'étudiant et users_roles
				rs= ComputeQueryBean.insertInAllTable(valueEnseignant, "Enseignant",connection);
				valueEnseignant=pseudo + "%" + "'enseignant'";
				rs = ComputeQueryBean.insertUsersRoles(valueEnseignant,"users_roles", connection);
			}
		
			
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

			validationNiveau(niveau);

		} catch (Exception e) {

			errors.put(LEVEL, e.getMessage());

		}
		
		try {

			validationSexe(sexe);

		} catch (Exception e) {

			errors.put(GENDER, e.getMessage());

		}
	

		try {

			validationNationalite(nationalite);

		} catch (Exception e) {

			errors.put(NATIONALITY, e.getMessage());

		}
		
		try {

			validationAdresse(adresse);

		} catch (Exception e) {

			errors.put(ADRESS, e.getMessage());

		}
		
		try {

			validationBoitePostale(boitePostale);

		} catch (Exception e) {

			errors.put(BP, e.getMessage());

		}
		try {

			validationAffiliationIns(affliationIns);

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

	private void validationSexe(String sexe) throws Exception{
		if(sexe.trim().length()==0)
			throw new Exception("Veuillez saisir le sexe svp");
			
		
	}

	private void validationAffiliationIns(String affliationIns) throws Exception{
		if(affliationIns.trim().length()==0)
			throw new Exception("Veuillez saisir l'affiliation institutionnelle svp");
		
	}
	
	
	private void validationNiveau(String niveau) throws Exception{
		if(niveau.trim().length()==0)
			throw new Exception("Veuillez saisir le niveau svp");
		
	}
	
	private void validationNationalite(String nationalite)throws Exception {
		if(nationalite.trim().length()==0)
			throw new Exception("Veuillez saisir la nationalité svp");
		
	}

	
	
	private void validationAdresse(String adresse)throws Exception {
		if(adresse.trim().length()==0)
			throw new Exception("Veuillez saisir  une adresse svp");
		
	}
	
	private void validationBoitePostale(String boitePostale) throws Exception{
		if(boitePostale.trim().length()==0)
			throw new Exception("Veuillez saisir la boite postale svp");
		
	}
	


}
