package ServletPackages.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ActiviteBean;
import BeanPackage.ComputeQueryBean;
import ModelPackage.Activite;
import ServletPackages.GetAuthorisationUsers;

public class ActiviteServlet extends GetAuthorisationUsers {
	//
	// FIELDS
	//
	private Connection connection;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.doGet(req, resp,"responsable_Suivi_Evaluation","List/Activite.jsp",connection);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActiviteBean activite = new ActiviteBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("activite", connection);
			while (result.next()) {
				activite.addActiviteinList(new Activite(result.getInt(1), result.getString(2),
						Integer.toString(result.getInt(3)), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7), result.getString(8), result.getString(9),
						result.getString(10), result.getString(11), result.getString(12), result.getString(13)));
			}
			System.out.println("Taille de la liste : " + activite.getActiveList().size());
			req.setAttribute("activiteRecu", activite);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
