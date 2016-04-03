package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import BeanPackage.ComputeQueryBean;
import ModelPackage.User;

public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//
	// FIELDS
	//
	private String pseudo;
	private String password;
	private Statement statement;
	private Connection connection;
	private static DataSource dataSource;
	//
	// METHODS
	//
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connection.jsp").forward(request, response);
	}
	/** Verify the pseudo and password of the user */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultSet resultSet = null;
		try {
			String role = "";
			// Get Connection and Statement
			connection = this.getDataSource().getConnection();
			pseudo = request.getParameter("j_username");
			password = request.getParameter("j_password");
			System.out.println("ConnexionServlet.doPost()");
			if (ComputeQueryBean.isUser(pseudo, password, connection)) {
				resultSet = ComputeQueryBean.userRole(pseudo, connection);
				while (resultSet.next()) {
					role = resultSet.getString("rolename");
				}
			}
			request.getSession().setAttribute("user", new User(pseudo, password));
			request.getSession().setAttribute("rolename", role);
			switch (role) {
			case "admin": {
				response.sendRedirect("administrator");
			}
				break;
			case "etudiant": {
				response.sendRedirect("etudiant");
			}
				break;
			case "enseignat": {
				response.sendRedirect("enseignant");
			}
				break;
			case "coordonnateur": {
				response.sendRedirect("coordonnateur");

			}
				break;
			case "responsable_Suivi_Evaluation": {
				response.sendRedirect("responsable_Suivi_Evaluation");
			}
				break;
			case "responsable_Saisie": {
				response.sendRedirect("responsable_Saisie");
			}
				break;
			case "responsable_Controle": {
				response.sendRedirect("responsable_Controle");
			}
				break;
			case "partenaire": {
				response.sendRedirect("partenaire");
			}
				break;
			case "BanqueMondial": {
				response.sendRedirect("BanqueMondial");
			}
				break;
			case "viceCoordonnateur": {
				response.sendRedirect("viceCoordonnateur");
			}
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != resultSet)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != statement)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/** Called to get existing datasource */
	public DataSource getDataSource() {
		return dataSource;
	}
}
