package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import BeanPackage.ComputeQueryBean;
import ModelPackage.User;
import ServletSecurity.ZaCallbackHandler;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultSet resultSet = null;
		try {
			// Get Connection and Statement
			connection = this.getDataSource().getConnection();
			pseudo = request.getParameter("j_username");
			password = request.getParameter("j_password");

			if (!pseudo.isEmpty() && !password.isEmpty()) {
				boolean authenticationFlag = true;
				ZaCallbackHandler zaCallbackHandler = new ZaCallbackHandler(pseudo, password);
				try {
					LoginContext loginContext = new LoginContext("ZaJaas", zaCallbackHandler);
					loginContext.login();
				} catch (LoginException e) {
					e.printStackTrace();
					System.out.println("LoginContext failed");
					authenticationFlag = false;
				}
				if (authenticationFlag){
					System.out.println("Authentication success ...");
					int id = ComputeQueryBean.getIDUser(pseudo, password, connection);
						resultSet = ComputeQueryBean.selectAllByID("compte", id, connection);
						while (resultSet.next()) {
							request.getSession().setAttribute("user", new User(pseudo, password, id));
							response.sendRedirect("home");
						}
				}
				else
					System.out.println("Authentication failed ...");
				response.sendRedirect("connexion");
			} else {
				response.getWriter().println(" Invalid Authentication ...");
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
	/** Called to get existing datasource*/
	public DataSource getDataSource() {
		return dataSource;
	}
	/** Used to check if the customer is a user*/
	public boolean isUser(String pseudo, String password) {
		boolean flag = false;
		try {
			connection = this.getDataSource().getConnection();
			int id = ComputeQueryBean.getIDUser(pseudo, password, connection);
			if (id != 0)
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			flag = false;
		}
		return flag;
	}
}
