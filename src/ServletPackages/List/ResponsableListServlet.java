package ServletPackages.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.ResponsableBean;
import ModelPackage.Responsable;
import ServletPackages.Formulaires.ConnexionServlet;

/**
 * Servlet implementation class ResponsableListServlet
 */
public class ResponsableListServlet extends ConnexionServlet {
	//
	// FIELDS
	//
	private Connection connection;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/List/ListResponsable.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResponsableBean responsable=new ResponsableBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Responsable", connection);
			while (result.next()) {
					responsable.AddResponsable(new Responsable(result.getInt(1), result.getString(2), result.getString(3),result.getString(4), result.getString(5), result.getString(6), result.getString(7),
							Integer.toString(result.getInt(8)), result.getString(9)));
			}
			System.out.println("Taille de la liste : "+responsable.getResponsableList().size());
			req.setAttribute("responsableRecu", responsable);
		} catch (SQLException e){
			
			e.printStackTrace();
		}

	}
}
