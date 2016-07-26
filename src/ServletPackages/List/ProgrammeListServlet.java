package ServletPackages.List;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.ProgrammeBean;
import ModelPackage.Programme;
import ServletPackages.GetAuthorisationUsers;

public class ProgrammeListServlet extends GetAuthorisationUsers {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		this.doGet(request, response, "responsable_Suivi_Evaluation", "List/programmeList.jsp", connection);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProgrammeBean programme = new ProgrammeBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Programmecea", connection);
			while (result.next()) {
				programme.addProgramInList(new Programme(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getString(8), result.getString(9),Integer.toString(result.getInt(10)),Integer.toString(result.getInt(11)),
						result.getString(12), result.getString(13), result.getString(14), Integer.toString(result.getInt(15))));
			}
			System.out.println("Taille de la liste : " + programme.getProgramList().size());
			request.setAttribute("programRecu", programme);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
