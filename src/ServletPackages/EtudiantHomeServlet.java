package ServletPackages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EtudiantHomeServlet extends ConnexionServlet{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/EtudiantHome.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
	}
}
