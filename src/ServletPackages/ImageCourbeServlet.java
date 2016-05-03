package ServletPackages;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

import BeanPackage.ComputeQueryBean;

@WebServlet("/ServletImage")
public class ImageCourbeServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
    public ImageCourbeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/monGraphe.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			 connection=this.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ResultSet  rs = ComputeQueryBean.selectnum("indicateur", connection);
		 
		DefaultCategoryDataset data=new DefaultCategoryDataset();
		try {
			while(rs.next()){
			data.setValue(rs.getInt(2),rs.getString(1),"EPSC");}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		data.setValue(98,"entretien preventif systhématique non contractuel","EPSNC");
//		data.setValue(12,"entretien préventif conditionnelle","EPC");
//		data.setValue(65.67,"entretien preventif global","EPG");
//		data.setValue(100,"entretien curatif","EC");
//		data.setValue(95,"Autres","Autre");
	    JFreeChart graphico=ChartFactory.createBarChart("Diagramme en barre des activités en fonction des indicateurs" ,"Indicateurs","Activités",data,PlotOrientation.VERTICAL,true,true,true);
	    // JFreeChart graphe = ChartFactory.createPieChart("", (PieDataset) data, true, true, false);
		//JFreeChart graphe = ChartFactory.createPieChart(titre, defaultpiedataset, true, true, false);
		response.setContentType("image/JPEG");
		OutputStream sa=response.getOutputStream(); 
		ChartUtilities.writeChartAsJPEG(sa,graphico,600,500);

	}

}
