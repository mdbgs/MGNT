package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AdminHomeServlet extends GetAuthorisationUsers{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   try {
			connection=this.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.doGet(req, resp, "admin","AdminHome.jsp", connection);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
