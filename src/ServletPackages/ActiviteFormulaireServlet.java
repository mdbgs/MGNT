package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;

/**
 * Servlet implementation class ActiviteFormulaire
 */
@WebServlet("/ActiviteFormulaireServlet")
public class ActiviteFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ActiviteFormulaire.jsp").forward(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		String libelle = request.getParameter(LIBELLE);
		String periode = request.getParameter(PERIODE);
		String echeancePrevu = request.getParameter(ECHEANCEPREVU);
		String echeanceRealise=request.getParameter(ECHEANCEREALISE);
		String statutActivite=request.getParameter(STATUTACTIVITE);
		String natureIndicateur=request.getParameter(NATUREINDICATEUR);
		String libelleIndicateur=request.getParameter(LIBELLEINDICATEUR);
		String referenceTabSaisie=request.getParameter(REFERENCETABSAISIE);
		String pieceJustificatif= request.getParameter(PIECEJUSTIFICATIF);
		String composant= request.getParameter(COMPOSANT);
		String objectif= request.getParameter(OBJECTIF);
		String resultatAttendu= request.getParameter(RESULTATATTENDU);
		
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		HomeServlet servlet = new HomeServlet();
		try {
			
			connection = servlet.getDataSource().getConnection();
			date = dateFormat.parse(periode);
			String valueActivite="'"+libelle+"'%'"+dateFormat.format(date)+"'%'"+echeancePrevu+"'%'"+echeanceRealise+"'%'"+statutActivite+"'%'" +natureIndicateur+"'%'"+libelleIndicateur+"'%'" +referenceTabSaisie+"'%'" +pieceJustificatif+"'%'" +composant+"'%'"+objectif+"'%"
			+ "'"+resultatAttendu+"'%"; 
			int rs= ComputeQueryBean.insertDatabase(valueActivite, "Activite",connection);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
	}
}
