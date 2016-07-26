package ServletPackages.OutPut;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletPackages.Formulaires.ConnexionServlet;

/**
 * Servlet implementation class GrapheServlet
 */
@WebServlet("/GrapheServlet")
public class GrapheServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/OutPut/GrapheIndicateur.jsp").forward(req, resp);
	}
}
