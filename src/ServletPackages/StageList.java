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
import BeanPackage.StageBean;
import ModelPackage.Publication;
import ModelPackage.Stage;

/**
 * Servlet implementation class StageList
 */
@WebServlet("/StageList")
public class StageList extends GetAuthorisationUsers {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection connection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StageList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		this.doGet(request, response, "responsable_Suivi_Evaluation", "StageList.jsp", connection);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StageBean stage=new StageBean();
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Stage", connection);
			while (result.next()) {
				stage.addStageInList(new Stage(result.getInt(1), result.getInt(2),result.getInt(3), result.getInt(4), result.getString(5),Integer.toString(result.getInt(4)),
						Integer.toString(result.getInt(7)), result.getString(8), result.getString(9),result.getString(10),result.getString(11),result.getString(12),result.getString(13),result.getString(14)));
			}
			System.out.println("Taille de la liste : "+stage.getStageList().size());
			request.setAttribute("StageRecu", stage);
		} catch (SQLException e){
			
			e.printStackTrace();
		}
	}

}
