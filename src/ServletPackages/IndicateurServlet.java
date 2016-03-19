package ServletPackages;

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

public class IndicateurServlet extends ConnexionServlet {

	private Connection connection;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Indicateur.jsp").forward(req, resp);
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
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
