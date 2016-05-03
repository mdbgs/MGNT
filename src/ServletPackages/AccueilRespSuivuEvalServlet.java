package ServletPackages;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

public class AccueilRespSuivuEvalServlet extends GetAuthorisationUsers {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DataSource dataSource;
	private java.sql.Connection connection;

	public void init() throws ServletException {
		try {
			// Get DataSource
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/Pooldb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public DataSource getDataSource() {
		return this.dataSource;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
				connection=this.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		this.doGet(req, resp,"responsable_Suivi_Evaluation","AccueilRespSuivuEval.jsp",connection);
	}
  
}
