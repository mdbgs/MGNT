package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
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
		HomeServlet servlet = new HomeServlet();
	}
}
