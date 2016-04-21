package ServletPackages;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Servlet implementation class ImportExcel
 */
@WebServlet("/ImportExcel")
public class ImportExcelServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
    public ImportExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static final String VUE = "/WEB-INF/jsp/AdminAccueil.jsp";
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "D:/fichiers/"; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part;
      Connection connection;
		try {
			part = request.getPart("source");
			String nomFichier = ImportExcel.getNomFichier(part);
			ImportExcel.upload("source",request);
			connection = this.getDataSource().getConnection();
			ImportExcel.chronogram(CHEMIN_FICHIERS+nomFichier, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        
    }


	
		
			
	}


