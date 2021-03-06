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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import Enumeration.NumericConstant;
import ServletPackages.GetAuthorisationUsers;

/**
 * Servlet implementation class ReunionFormlaireServlet
 */
public class ReunionFormulaireServlet extends GetAuthorisationUsers implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			connection=this.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	this.doGet(req, resp, "responsable_Suivi_Evaluation", "Formulaire/Enseignant.jsp", connection);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		
		Map<String, String> errors = new HashMap<String, String>();

		/* R�cup�ration des champs du formulaire. */
		String type = request.getParameter(TYPE);
		String dateDeb = request.getParameter(DATEDEB);
		String dateFin = request.getParameter(DATEFIN);
		String objet=request.getParameter(OBJECT);
		String nbreParticipant=request.getParameter(PARTICIPNUMBER);
		String lieu=request.getParameter(LIEU);
		String compteRendu=request.getParameter(COMPTERENDU);
		String pieceJustificatif= request.getParameter(PIECEJUSTIFICATIF);
		Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			connection = this.getDataSource().getConnection();
			//date = dateFormat.parse(dateN);
			String valueEtudiant="%"+1+"%'"+type+"'%"+dateDeb+"%"+dateFin+"%'"+objet+"'%"+nbreParticipant+"%'" +lieu+"'%'"+compteRendu+"'%'" +pieceJustificatif+"'"; 
			int rs= ComputeQueryBean.insertInAllTable(valueEtudiant, "Reunion",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/* Validation du champ type. */
		try {

			validationType(type);

		} catch (Exception e) {

			errors.put(TYPE, e.getMessage());

		}
		
		/* Validation du champ Date debut. */
		try {

			validationDateDeb(dateDeb);

		} catch (Exception e) {

			errors.put(DATEDEB, e.getMessage());

		}
		
		/* Validation du champ Date fin. */
		try {

			validationDateFin(dateFin);

		} catch (Exception e) {

			errors.put(DATEFIN, e.getMessage());

		}
		
		/* Validation du champ objet. */
		try {

			validationObjet(objet);

		} catch (Exception e) {

			errors.put(OBJECT, e.getMessage());

		}
		
		/* Validation du champ nbre participant. */
		try {

			validationNbrePartipant(nbreParticipant);

		} catch (Exception e) {

			errors.put(PARTICIPNUMBER, e.getMessage());

		}
		
		/* Validation du champ lieu. */
		try {

			validationLieu(lieu);

		} catch (Exception e) {

			errors.put(LIEU, e.getMessage());

		}
		/* Validation du champ compte rendu. */
		try {

			validationCompteRendu(compteRendu);

		} catch (Exception e) {

			errors.put(COMPTERENDU, e.getMessage());

		}
		
			
		if (errors.isEmpty()) {

			resultat = "Succ�s de l'inscription.";

		} else {

			resultat = "�chec de l'inscription.";

		}
		
		/* Stockage du r�sultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, errors);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response � notre JSP */

		request.getRequestDispatcher("/WEB-INF/jsp/Reunion.jsp").forward(request, response);
	}
	
	
	private void validationType(String type) throws Exception{
		if(type.trim().length()==0)
			throw new Exception("Veuillez saisir le type svp");
		
	}
	private void validationDateDeb(String dateDeb) throws Exception {
		if(dateDeb.trim().length()==0)
			throw new Exception("Veuillez saisir la date de d�but svp");
		
	}
	private void validationDateFin(String dateFin) throws Exception{
		if(dateFin.trim().length()==0)
			throw new Exception("Veuillez saisir la date de fin svp");
		
	}
	
	private void validationObjet(String objet) throws Exception{
		if(objet.trim().length()==0)
			throw new Exception("Veuillez saisir l'objet svp");
		
	}
	
	private void validationNbrePartipant(String nbreParticipant) throws Exception{
		if(nbreParticipant.trim().length()==0)
			throw new Exception("Veuillez saisir le nbre de participant svp");
		
	}
	

	private void validationLieu(String lieu) throws Exception{
		if(lieu.trim().length()==0)
			throw new Exception("Veuillez saisir le lieu svp");
		
	}

	private void validationCompteRendu(String compteRendu) throws Exception{
		if(compteRendu.trim().length()==0)
			throw new Exception("Veuillez saisir le compte rendu svp");
		
	}
	
}
