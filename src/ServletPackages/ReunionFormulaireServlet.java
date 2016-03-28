package ServletPackages;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.NumericConstant;

/**
 * Servlet implementation class ReunionFormlaireServlet
 */
public class ReunionFormulaireServlet extends ConnexionServlet implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Reunion.jsp").forward(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération des champs du formulaire. */
		String type = request.getParameter(TYPE);
		String dateDeb = request.getParameter(DATEDEB);
		String dateFin = request.getParameter(DATEFIN);
		String objet=request.getParameter(OBJECT);
		String nbreParticipant=request.getParameter(PARTICIPNUMBER);
		String lieu=request.getParameter(LIEU);
		String compteRendu=request.getParameter(COMPTERENDU);
		String pieceJustificatif= request.getParameter(PIECEJUSTIFICATIF);
	}
}
