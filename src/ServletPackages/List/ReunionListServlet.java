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
import BeanPackage.ReunionBean;
import ModelPackage.Reunion;
import ServletPackages.GetAuthorisationUsers;

/**
 * Servlet implementation class ReunionListServlet
 */
@WebServlet("/ReunionListServlet")
public class ReunionListServlet extends GetAuthorisationUsers {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection connection;

	public ReunionListServlet() {
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
		this.doGet(request, response, "responsable_Suivi_Evaluation", "List/reunionList.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReunionBean reunion=new ReunionBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Reunion", connection);
			while (result.next()) {
				reunion.addReunionInList(new Reunion(result.getInt(1), result.getInt(2), result.getString(3),
						Integer.toString(result.getInt(4)), Integer.toString(result.getInt(4)),result.getString(6),result.getInt(7),result.getString(8),result.getString(9),result.getString(10)));
			}
			System.out.println("Taille de la liste : "+reunion.getReunionList().size());
			request.setAttribute("ReunionRecu", reunion);
		} catch (SQLException e){
			
			e.printStackTrace();
		}
	}

}
