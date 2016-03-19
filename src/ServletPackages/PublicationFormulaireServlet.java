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
 * Servlet implementation class PubllicationFromulaireServlet
 */
@WebServlet("/PubllicationFromulaireServlet")
public class PublicationFormulaireServlet extends ConnexionServlet implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Publication.jsp").forward(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		
		Map<String, String> erreurs = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
		String titre = request.getParameter(TITLE);
		String datePub = request.getParameter(DATEPUB);
		String nomJournal = request.getParameter(NOMJOURNAL);
		String auteur=request.getParameter(AUTHOR);
		String facteurImpact=request.getParameter(IMPACTFACTOR);
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			date = dateFormat.parse(datePub);
			String valuePublication="'"+titre+"'%'"+dateFormat.format(date)+"'%"+"%'"+nomJournal+"'%'"+facteurImpact+"'%'";
			int rs= ComputeQueryBean.insertDatabase(valuePublication, "Etudiant",connection);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
	}
}

