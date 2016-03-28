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
 * Servlet implementation class FormationFormulaireServlet
 */
@WebServlet("/FormationFormulaireServlet")
public class FormationFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Formation.jsp").forward(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		String titre = request.getParameter(TITLE);
		String institution = request.getParameter(INSTITUTION);
		String position = request.getParameter(POSITION);
		String contenu=request.getParameter(CONTENU);
		
		ConnexionServlet servlet = new ConnexionServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			//date = dateFormat.parse(dateN);
			String valueFormation="'"+titre+"'%'"+institution+"'%'"+position+"'%'"+contenu+"'%";
			int rs= ComputeQueryBean.insertDatabase(valueFormation, "Formation",connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
