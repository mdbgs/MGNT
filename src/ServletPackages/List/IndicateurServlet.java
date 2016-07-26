package ServletPackages.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.IndicateurBean;
import ModelPackage.Indicateur;
import ServletPackages.GetAuthorisationUsers;

public class IndicateurServlet extends GetAuthorisationUsers {

	private Connection connection;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);if (req.getParameter("pageNumber") == null){
			System.err.println("je suis une valeur null!!!!!");
			req.setAttribute("pageNumber", 1);}
		else{
			req.setAttribute("pageNumber", req.getParameter("pageNumber"));
			System.err.println("je suis une valeur égale à : "+req.getParameter("pageNumber"));	
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Formulaire/Indicateur.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IndicateurBean indicateur = new IndicateurBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("indicateur", connection);
			while (result.next()) {
				indicateur.addIndicateurInList(new Indicateur(result.getInt(1), result.getInt(2), result.getString(3),
						result.getString(4), result.getString(5)));
			}
			System.out.println("Taille de la liste : " + indicateur.getIndicateurList().size());
			req.setAttribute("indicateurRecu", indicateur);
			req.setAttribute("rowsCount", indicateur.getIndicateurList().size());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
