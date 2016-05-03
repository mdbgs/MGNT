package ServletPackages;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class HomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DataSource dataSource;

	

	public DataSource getDataSource() {
		return this.dataSource;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getSession().invalidate();
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(req, resp);
	   req.getSession().invalidate();
	}

}
