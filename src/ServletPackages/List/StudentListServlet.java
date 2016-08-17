package ServletPackages.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.StudentBean;
import ModelPackage.Student;
import ServletPackages.GetAuthorisationUsers;

public class StudentListServlet extends GetAuthorisationUsers {
	//
	// FIELDS
	//
	private static Connection connection;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		this.doGet(req, resp, "responsable_Suivi_Evaluation","List/ListEtudiant.jsp", connection);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentBean student = new StudentBean();
		try {
			ResultSet result = allStudent();
			while (result.next()) {
				student.AddStudent(new Student(result.getInt(1), result.getString(2),result.getString(3), result.getString(4), Integer.toString(result.getInt(5)), result.getString(6),
						result.getString(7), result.getString(8), result.getString(9), result.getString(10),
						result.getString(11), result.getString(12), Integer.toString(result.getInt(13)), result.getString(14), result.getString(15), result.getString(16), result.getString(17), result.getString(18), result.getString(19), result.getString(20), result.getString(21)));
			}
			System.out.println("Taille de la liste : "+student.getStudentList().size());
			req.setAttribute("studentRecu", student);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public static ResultSet allStudent(){
		return ComputeQueryBean.selectAll("Etudiant", connection);
	}
}
