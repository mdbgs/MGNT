package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Map<String, String> erreurs = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
		String nom = request.getParameter(LASTNAME);
		String prenom = request.getParameter(FIRSTNAME);
		String email = request.getParameter(MAIL);
		String telephone=request.getParameter(PHONE);
		String boitePostal=request.getParameter(BP);
		String affliationInstitutionnelle=request.getParameter(INSTITUTIONAFFILIATION);
		String type=request.getParameter(TYPE);
		
		 /*Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			//date = dateFormat.parse(dateN);
			String valueFormation="'"+titre+"'%'"+institution+"'%"+"%'"+position+"'%'"+contenu+"'%'";
			int rs= ComputeQueryBean.insertDatabase(valueFormation, "Etudiant",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}*/
}
}
