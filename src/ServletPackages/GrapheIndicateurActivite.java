package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ActiviteBean;
import BeanPackage.ComputeQueryBean;
import BeanPackage.IndicateurBean;
import ModelPackage.Activite;
import ModelPackage.Indicateur;

/**
 * Servlet implementation class GrapheIndicateurActivite
 */
@WebServlet("/GrapheIndicateurActivite")
public class GrapheIndicateurActivite extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/GrapheIndicateurActivite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActiviteBean activite = new ActiviteBean();
		IndicateurBean listIndicateur = new IndicateurBean();
		Indicateur indicateur=null;
		String indic=req.getParameter("sendIndicateur");
		int myID=Integer.parseInt(indic);
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("activite", connection);
			String[] value;
			//Activite
			while (result.next()) {
				value = result.getString(9).split("%");
				indic ="indicateur "+myID;
				System.out.println(indic+" this is my value!!!!!!!!!!");
				if (value[0].equals(indic)){
					activite.addActiviteinList(new Activite(result.getInt(1), result.getString(2),
							Integer.toString(result.getInt(3)), result.getString(4), result.getString(5),
							result.getString(6), result.getString(7), result.getString(8), result.getString(9),
							result.getString(10), result.getString(11), result.getString(12), result.getString(13)));
				}
			}
			req.setAttribute("activiteRecu", activite);
			//Indicateur
			result = ComputeQueryBean.selectIndicateurByNumero( myID, connection);
			while (result.next()) {
				indicateur= new Indicateur(result.getInt(1), result.getInt(2), result.getString(3),
						result.getString(4), result.getString(5));
			}
			req.setAttribute("indicateurRecu", indicateur);
			//Liste des indicateurs
			result = ComputeQueryBean.selectAll("indicateur", connection);
			while (result.next()) {
				listIndicateur.addIndicateurInList( new Indicateur(result.getInt(1), result.getInt(2), result.getString(3),
						result.getString(4), result.getString(5)));
			}
			req.setAttribute("listIndicateur", listIndicateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
