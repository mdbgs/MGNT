package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.AnimateurRelecteurBean;
import BeanPackage.ComputeQueryBean;
import BeanPackage.ProgrammeBean;
import ModelPackage.AnimateurRelecteur;
import ModelPackage.Programme;

public class AnimateurListServlet extends GetAuthorisationUsers {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		this.doGet(request, response, "responsable_Suivi_Evaluation", "animateurList.jsp", connection);
	}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	AnimateurRelecteurBean animateur = new AnimateurRelecteurBean();
	try {
		connection = this.getDataSource().getConnection();
		ResultSet result = ComputeQueryBean.selectAll("animateur_relecteur", connection);
		while (result.next()) {
			animateur.addAnimateurRelecteurInlist(new AnimateurRelecteur(result.getInt(1), result.getInt(2), result.getString(3),
					result.getString(4), result.getString(5), result.getString(6), result.getString(7),
					result.getString(8), result.getString(9)));
		}
		System.out.println("Taille de la liste : " + animateur.getAnimateurRelecteurList().size());
		request.setAttribute("programRecu", animateur);
	} catch (SQLException e) {

		e.printStackTrace();
	}
}
}
