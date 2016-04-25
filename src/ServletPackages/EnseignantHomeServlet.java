package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import ModelPackage.Activite;
import ModelPackage.Indicateur;
import ModelPackage.Student;
import ModelPackage.Teacher;

/**
 * Servlet implementation class EnseignantHomeServlet
 */
@WebServlet("/EnseignantHomeServlet")

	public class EnseignantHomeServlet extends ConnexionServlet {
		private static final long serialVersionUID = 1L;
		private Connection connection;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/homeEnseignant.jsp").forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			

		}
	}

