package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.PublicationBean;
import BeanPackage.StudentBean;
import ModelPackage.Publication;
import ModelPackage.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/PublicationListServlet")
public class PublicationListServlet extends GetAuthorisationUsers {
	//
	// FIELDS
	//
	private Connection connection;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
        this.doGet(req, resp, "responsable_Suivi_Evaluation","publicationList.jsp", connection);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PublicationBean publication = new PublicationBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Publication", connection);
			while (result.next()) {
				publication.addPublicationInList(new Publication(result.getInt(1), result.getInt(2),result.getString(3), Integer.toString(result.getInt(4)), result.getString(5), result.getString(6),
						result.getString(7), result.getString(8), result.getString(9)));
			}
			System.out.println("Taille de la liste : "+publication.getPublicationList().size());
			req.setAttribute("publicationRecu", publication);
		} catch (SQLException e){
			
			e.printStackTrace();
		}

	}
}
