package ServletPackages;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class PartenaireListServlet
 */
@WebServlet("/PartenaireListServlet")
public class PartenaireListServlet extends GetAuthorisationUsers {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection connection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartenaireListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				connection=this.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		this.doGet(request, response, "responsable_Suivi_Evaluation", "partenaireList.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
