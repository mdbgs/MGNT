package ServletPackages.Home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletPackages.Formulaires.ConnexionServlet;

/**
 * Servlet implementation class EnseignantHomeServlet
 */
@WebServlet("/EnseignantHomeServlet")

	public class EnseignantHomeServlet extends ConnexionServlet {
		private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Home/TeacherHome.jsp").forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		}
	}

