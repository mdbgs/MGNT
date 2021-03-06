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
import BeanPackage.TeacherBean;
import ModelPackage.Teacher;
import ServletPackages.GetAuthorisationUsers;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/TeacherList")
public class TeacherList extends GetAuthorisationUsers {
	//
	// FIELDS
	//
	private Connection connection;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
     this.doGet(req, resp, "responsable_Suivi_Evaluation", "List/ListEnseignant.jsp", connection);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherBean teacher = new TeacherBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Enseignant", connection);
			while (result.next()) {
				teacher.AddTeacher(new Teacher(result.getInt(1), result.getString(2),result.getString(3), result.getString(4), result.getString(9), result.getString(5),
						result.getString(6), result.getString(7), result.getString(8), result.getString(10),
						result.getString(11),result.getString(12),result.getString(13)));
			}
			System.out.println("Taille de la liste : "+teacher.getTeacherList().size());
			req.setAttribute("teacherRecu",teacher);
		} catch (SQLException e){
			
			e.printStackTrace();
		}

	}
}
