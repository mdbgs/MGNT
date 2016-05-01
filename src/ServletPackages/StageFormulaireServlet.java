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
 * Servlet implementation class StageFormulaireServlet
 */
@WebServlet("/StageFormulaireServlet")
public class StageFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Stage.jsp").forward(req, resp);
	}
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		
		Map<String, String> errors = new HashMap<String, String>();
		/* Récupération des champs du formulaire. */
		String programmeDpt = request.getParameter(PROGRAMDEPARTMENT);
		String dateDeb = request.getParameter(DATEDEB);
		String dateFin = request.getParameter(DATEFIN);
		String certificat=request.getParameter(CERTIFICAT);
		String nomIns = request.getParameter(INSTITUTIONNAME);
		String statutIns = request.getParameter(INSTITUTIONSTATUT);
		String nomDirect = request.getParameter(DIERCTORLASTNAME);
		String prenomDirect=request.getParameter(DIRECTORFIRSTNAME);
		String emailDirect=request.getParameter(DIRECTORMAIL);
		String telDirect=request.getParameter(DIRECTORPHONE);
		
		 Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		 dateDeb=dateFormat.format(date);
		try {
			connection = this.getDataSource().getConnection();
			//date = dateFormat.parse(dateN);
			String valueFormation="%"+null+"%"+null+"%"+null+"%'"+programmeDpt+"'%"+dateDeb+"%"+dateFin+"%'"+certificat+"'%'"+
			nomIns+"'%'"+statutIns+"'%'"+nomDirect+"'%'"+prenomDirect+"'%'"+emailDirect+"'%'"+telDirect+"'";
			int rs= ComputeQueryBean.insertDatabase(valueFormation, "Stage",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* Validation du champ programme département. */
		try {

			validationProgramme(programmeDpt);

		} catch (Exception e) {

			errors.put(PROGRAMDEPARTMENT, e.getMessage());

		}
		
		/* Validation du champ programme certificat. */
		try {

			validationCertificat(certificat);

		} catch (Exception e) {

			errors.put(CERTIFICAT, e.getMessage());

		}
		try {

			validationInstitution(nomIns);

		} catch (Exception e) {

			errors.put(INSTITUTIONNAME, e.getMessage());

		}
		
		try {

			validationInstitutionStatut(statutIns);

		} catch (Exception e) {

			errors.put(INSTITUTIONSTATUT, e.getMessage());

		}
		
		try {

			validationNomDirecteur(nomDirect);

		} catch (Exception e) {

			errors.put(DIERCTORLASTNAME, e.getMessage());

		}
		
		try {

			validationPrénomDirecteur(prenomDirect);

		} catch (Exception e) {

			errors.put(DIRECTORFIRSTNAME, e.getMessage());

		}
		
		try {

			validationMail(emailDirect);

		} catch (Exception e) {

			errors.put(DIRECTORMAIL, e.getMessage());

		}
		
		try {

			validationTelephone(telDirect);

		} catch (Exception e) {

			errors.put(DIRECTORPHONE, e.getMessage());

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

		request.getRequestDispatcher("/WEB-INF/jsp/Stage.jsp").forward(request, response);
	}

	private void validationProgramme(String programmeDpt) throws Exception{
		if(programmeDpt.trim().length()==0)
			throw new Exception("Veuillez saisir le programme svp");
		
	}
		private void validationCertificat(String certificat) throws Exception{
			if(certificat.trim().length()==0)
				throw new Exception("Veuillez saisir le certificat svp");
			
		}
		

		private void validationInstitution(String nomIns) throws Exception{
			if(nomIns.trim().length()==0)
				throw new Exception("Veuillez saisir le nom de l'institution svp");
		
	}

		private void validationInstitutionStatut(String statutIns) throws Exception{
			if(statutIns.trim().length()==0)
				throw new Exception("Veuillez saisir le statut de l'institution svp");
		
	}
		private void validationNomDirecteur(String nomDirect) throws Exception{
			if(nomDirect.trim().length()==0)
				throw new Exception("Veuillez saisir le nom du directeur svp");
			
		}
		

		private void validationPrénomDirecteur(String prenomDirect) throws Exception{
			if(prenomDirect.trim().length()==0)
				throw new Exception("Veuillez saisir le prénom du directeur svp");
			
		}

		private void validationMail(String emailDirect) throws Exception{
			if (emailDirect != null && emailDirect.trim().length() != 0) {

				if (!emailDirect.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

					throw new Exception("Merci de saisir une adresse mail valide.");

				}

			} else {

				throw new Exception("Merci de saisir une adresse mail.");

			}
			
		}
		

		private void validationTelephone(String telDirect) throws Exception{
			if ( telDirect!= null ) {

	            if ( !telDirect.matches( "^\\d+$" ) ) {

	                throw new Exception( "Le numéro de téléphone est incorrect." );

	            } else if ( telDirect.length() < 9 ) {
	                throw new Exception( "Le numéro de téléphone doit contenir au moins 9 chiffres." );

	            }

	        } else {

	            throw new Exception( "Merci d'entrer un numéro de téléphone." );
	            }
			
		}


	
		
}
