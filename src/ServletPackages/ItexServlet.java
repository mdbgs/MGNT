package ServletPackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.lowagie.text.Document;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@WebServlet("/ItexServlet")
public class ItexServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;

	public ItexServlet() {
		super();
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/itex.jsp").forward(request, response);
		Document document = new Document();
		String s="maman";
		Connection connection;
	    Statement statement;
	    ArrayList<String> listRow = new ArrayList<String>();
	    ArrayList<String> values=new ArrayList<String>();

		try {
			
			connection = this.getDataSource().getConnection();
			 statement = connection.createStatement();
			 
//					   ResultSet result=statement.executeQuery(sql);
//					   String[] listeColumn  = result;
//						for(int i=0;i<listeColumn.length;i++)
//						              {
//								System.out.print(listeColumn[i]+" ");
//						        values.add(listeColumn[i]);
//						               }
					   System.out.println("resultat ok");
					   
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph( s+" Proces Verbal "+
			"idreunion idresponsable type dateDebut dateFin "+
					"objet nombreParticipant lieu compteRendu pieceJustificatif"));
		} catch (DocumentException de) {
			de.printStackTrace();
			
			System.err.println("document: " + de.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
	}
}