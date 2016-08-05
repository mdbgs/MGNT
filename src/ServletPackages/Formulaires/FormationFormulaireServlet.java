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
 * Servlet implementation class FormationFormulaireServlet
 */
@WebServlet("/FormationFormulaireServlet")
public class FormationFormulaireServlet extends GetAuthorisationUsers implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
				connection=this.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		this.doGet(req, resp, "responsable_Suivi_Evaluation", "Formulaire/Formation.jsp", connection);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		
		Map<String, String> errors = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
		String titre = request.getParameter(TITLE);
		String institution = request.getParameter(INSTITUTION);
		String position = request.getParameter(POSITION);
		String contenu=request.getParameter(CONTENU);
		
		//ConnexionServlet servlet = new ConnexionServlet();
		try {
			connection = this.getDataSource().getConnection();
			//date = dateFormat.parse(dateN);
			String valueFormation="%'"+titre+"'%'"+institution+"'%'"+position+"'%'"+contenu+"'%";
			int rs= ComputeQueryBean.insertInAllTable(valueFormation, "Formation",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/* Validation du champ titre. */
		try {

			validationTitre(titre);

		} catch (Exception e) {

			errors.put(TITLE, e.getMessage());

		}
		
		/* Validation du champ position. */
		try {

			validationPosition(position);

		} catch (Exception e) {

			errors.put(POSITION, e.getMessage());

		}
		
		/* Validation du champ institution. */
		try {

			validationInstitution(institution);

		} catch (Exception e) {

			errors.put(INSTITUTION, e.getMessage());

		}
		/* Validation du champ contenu*/
		try{
			validationContenu(contenu);
			
		} catch(Exception e){
			
			errors.put(CONTENU, e.getMessage());
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

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Formation.jsp").forward(request, response);

	}
	
	private void validationTitre(String titre) throws Exception {
		if(titre.trim().length()==0)
			throw new Exception("Veuillez saisir le titre svp");
		
	}
	
	private void validationInstitution(String institution) throws Exception{
		if(institution.trim().length()==0)
			throw new Exception("Veuillez saisir l'institution svp");
		
	}
	
	private void validationPosition(String position) throws Exception {
		if(position.trim().length()==0)
			throw new Exception("Veuillez saisir la position svp");
		
	}
	
	private void validationContenu(String contenu) throws Exception{
		if(contenu.trim().length()==0)
			throw new Exception("Veuillez saisir le contenu svp");
		
	}
	
	
}
