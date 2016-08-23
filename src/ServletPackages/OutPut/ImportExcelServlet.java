package ServletPackages.OutPut;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ServletPackages.Formulaires.ConnexionServlet;

/**
 * Servlet implementation class ImportExcel
 */
public class ImportExcelServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
    public ImportExcelServlet() {
        super();
    }
    public static final String VUE = "/WEB-INF/jsp/Home/AdminHome.jsp";
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "c:/CeamiticFile/"; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


