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
import ModelPackage.Activite;
import ModelPackage.Indicateur;
import ModelPackage.Student;
import ModelPackage.Teacher;

/**
 * Servlet implementation class detailActivite
 */
@WebServlet("/detailActivite")
public class DetailActivite extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Details2.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indic=req.getParameter("indicateurSending");
		int myID=0;
		String activ=req.getParameter("activiteSending");
		String std=req.getParameter("studentSending");
		String thd=req.getParameter("teacherSending");
		Student student=null;
		Activite activite =null;
		Indicateur indicateur=null;
		Teacher teacher=null;
		ResultSet result=null;
		try {
			connection = this.getDataSource().getConnection();
			//Indicateur
			if(indic!=null){
				myID=Integer.parseInt(indic);
				result = ComputeQueryBean.selectIndicateurByNumero( myID, connection);
				while (result.next()) {
					indicateur= new Indicateur(result.getInt(1), result.getInt(2), result.getString(3),
							result.getString(4), result.getString(5));
				}
				req.setAttribute("indicateurRecu", indicateur);
			}
			//Etudiant
			if(std!=null){
				result = ComputeQueryBean.selectAllByPseudo("etudiant", std, connection);
				System.out.println(std+" : "+result);
				while (result.next()) {
					student= new Student(result.getInt(1), result.getString(2),result.getString(3), result.getString(4), Integer.toString(result.getInt(5)), result.getString(6),
							result.getString(7), result.getString(8), result.getString(9), result.getString(10),
							result.getString(11), result.getString(12), Integer.toString(result.getInt(13)), result.getString(14), result.getString(15), result.getString(16), result.getString(17), result.getString(18), result.getString(19), result.getString(20));
				}
				req.setAttribute("etudiantRecu", student);
				System.out.println(result.getString(2));
				System.out.println(student.getPseudo());
				
			}
			//Activité
			if(activ!=null){
				myID=Integer.parseInt(activ);
				result = ComputeQueryBean.selectAllByID("activite", myID, connection);
				while (result.next()) {
					activite= new Activite(result.getInt(1), result.getString(2),
							Integer.toString(result.getInt(3)), result.getString(4), result.getString(5), result.getString(6),
							result.getString(7), result.getString(8), result.getString(9), result.getString(10),
							result.getString(11), result.getString(12), result.getString(13));
				}
				req.setAttribute("activiteRecu", activite);
			}
			//Enseignant
			if(thd!=null){
				myID=Integer.parseInt(thd);
				result = ComputeQueryBean.selectAllByID("enseignant", myID, connection);
				while (result.next()) {
					teacher=new Teacher(result.getInt(1), result.getString(2),result.getString(3), result.getString(4), result.getString(9), result.getString(5),
							result.getString(6), result.getString(7), result.getString(8), result.getString(10),
							result.getString(11),result.getString(12));
				}
				req.setAttribute("teacherRecu", teacher);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
