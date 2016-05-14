package ServletPackages;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import BeanPackage.ComputeQueryBean;
import BeanPackage.PartenaireBean;
import BeanPackage.ProgrammeBean;
import ModelPackage.Partenaire;
import ModelPackage.Programme;

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
		 doPost(request, response);
		this.doGet(request, response, "responsable_Suivi_Evaluation", "partenaireList.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartenaireBean partner = new PartenaireBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Partenaires", connection);
			while (result.next()) {
				partner.addPartnerInList(new Partenaire(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getString(8), result.getString(9),result.getString(10), Integer.toString(result.getInt(11)),
						result.getString(12), result.getString(13), result.getString(14)));
			}
			System.out.println("Taille de la liste : " + partner.getPartnerList().size());
			request.setAttribute("partnerRecu", partner);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
