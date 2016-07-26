package ServletPackages.Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletPackages.GetAuthorisationUsers;

public class AccueilRespSuivuEvalServlet extends GetAuthorisationUsers {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.sql.Connection connection;

	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
				connection=this.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		this.doGet(req, resp,"responsable_Suivi_Evaluation","Home/AccueilRespSuivuEval.jsp",connection);
	}
  
}
