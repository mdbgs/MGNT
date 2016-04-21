package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connection.jsp").forward(request, response);
	}

	/** Verify the pseudo and password of the user */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String role = "";
			// Get Connection and Statement
			connection = this.getDataSource().getConnection();
			Boolean connectionError = true;
			pseudo = request.getParameter("j_username");
			password = request.getParameter("j_password");
			System.out.println("ConnexionServlet.doPost()");
			if (ComputeQueryBean.isUser(pseudo, password, connection)) {
				role = ComputeQueryBean.userRole(pseudo, connection);
				if(!role.isEmpty()){
						request.getSession().setAttribute("user", new User(pseudo, password));
						request.getSession().setAttribute("rolename", role);
						switch (role) {
						case "admin": 
							response.sendRedirect("adminHome");
						break;
						case "etudiant": 
							response.sendRedirect("studentHome");
						break;
						case "enseignat": 
							response.sendRedirect("teacherHome");
						break;
						case "coordonnateur": 
							response.sendRedirect("coordonatorHome");
						break;
						case "responsable_Suivi_Evaluation": 
							response.sendRedirect("RSEHome");
						break;
						case "responsable_Saisie": 
							response.sendRedirect("RSHome");
						break;
						case "responsable_Controle": 
							response.sendRedirect("RCHome");
						break;
						case "partenaire": 
							response.sendRedirect("partenerHome");
						break;
						case "BanqueMondial": 
							response.sendRedirect("worldBankHome");
						break;
						case "viceCoordonnateur": 
							response.sendRedirect("viceCoordonatorHome");
						break;
					}
				}
				connectionError = false;
					
			} else {
				response.sendRedirect("connexion");
				request.getSession().setAttribute("connectionError", connectionError);
			}

		} catch (SQLException e) {
			System.out.println("ConnexionServlet.doPost() : Erreur pour l'admin");
		} finally {
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
