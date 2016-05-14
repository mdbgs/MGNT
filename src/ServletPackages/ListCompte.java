package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.CompteBean;
import BeanPackage.ComputeQueryBean;
import ModelPackage.Compte;

public class ListCompte extends GetAuthorisationUsers {
	//
	// FIELDS
	//
	private Connection connection;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.doGet(req, resp, "admin", "Listcompte.jsp", connection);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompteBean compte = new CompteBean();
		String pseudoRecu = req.getParameter("actionButton");
		//doGet(req, resp);
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Compte", connection);
			while (result.next()) {
				ResultSet result1 = ComputeQueryBean.selectNomPrenom(connection, result.getString(1), pseudoRecu);
				if (result1.first()) {
					compte.addInListCompte(new Compte(result.getString(1), result.getString(2),
							Integer.toString(result.getInt(3)), result.getString(4), result.getString(5),
							result1.getString(1), result1.getString(2)));
				}
			}
			System.out.println("Taille de la liste : " + compte.getCompteList().size());
			req.setAttribute("CompteRecu", compte);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
