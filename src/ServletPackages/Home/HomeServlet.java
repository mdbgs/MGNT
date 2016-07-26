package ServletPackages.Home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getSession().invalidate();
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Home/Home.jsp").forward(req, resp);
	   req.getSession().invalidate();
	}

}