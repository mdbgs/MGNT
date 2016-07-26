package ServletPackages.List;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.FormationBean;
import ModelPackage.Formation;
import ServletPackages.GetAuthorisationUsers;

/**
 * Servlet implementation class FormationListServlet
 */
@WebServlet("/FormationListServlet")
public class FormationListServlet extends GetAuthorisationUsers {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection connection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormationListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		this.doGet(request, response, "responsable_Suivi_Evaluation", "List/formationList.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FormationBean formation = new FormationBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Formation", connection);
			while (result.next()) {
				formation.addFormationInList(new Formation(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5)));
			}
			System.out.println("Taille de la liste : " + formation.getFormationList().size());
			request.setAttribute("FormationRecu", formation);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
