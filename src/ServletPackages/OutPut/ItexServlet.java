package ServletPackages.OutPut;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import BeanPackage.ComputeQueryBean;
import ModelPackage.Reunion;
import ServletPackages.Formulaires.ConnexionServlet;

@WebServlet("/ItexServlet")
public class ItexServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public ItexServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		// this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/itex.jsp").forward(request,
		// response);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reunion reunion=null;
		ResultSet result=null;
		String reunio=req.getParameter("myID");
		try {
		connection = this.getDataSource().getConnection();
		if(reunio!=null){
			int myID=Integer.parseInt(reunio);
			System.out.println(myID);
			result = ComputeQueryBean.selectAllByID("reunion", myID, connection);
			while (result.next()) {
				System.out.println(result);
				reunion= new Reunion(result.getInt(1), result.getInt(2),
						result.getString(3), result.getString(4), result.getString(5), result.getString(6),
						result.getInt(7), result.getString(8), result.getString(9), result.getString(10));
			            }
			req.setAttribute("reunionRecu", reunion);
			System.out.println(reunion.getStartDate());
			
			
		  
						}
						}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
//	    ArrayList<String> listRow = new ArrayList<String>();
//	    ArrayList<String> values=new ArrayList<String>();
		Document document = new Document();
		Connection connection;
	    Statement statement;
		try {
		
			connection = this.getDataSource().getConnection();
			 statement = connection.createStatement();
					   
			resp.setContentType("application/pdf");
			PdfWriter.getInstance(document, resp.getOutputStream());
			document.open();
            String text="PROCES VERBAL N°"+ reunion.getiDMeeting();
            String text1="SEANCE DU "+ reunion.getStartDate()+" AU "+reunion.getEndDate();
            String text2=reunion.getPlaceMeeting();
			PdfPTable table = new PdfPTable(1);
		    PdfPCell cell = null;
//			PdfPCell cell1=new PdfPCell(new Paragraph("SEANCE DU "+ reunion.getStartDate()+" AU "+reunion.getEndDate()));
//			PdfPCell cell2=new PdfPCell(new Paragraph(reunion.getPlaceMeeting()));
//			cell.setColspan(4);
//			cell1.setColspan(4);
//			cell2.setColspan(4);
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setBackgroundColor(Color.GREEN);
			table.setWidthPercentage(100);
			table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
			table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
			
 	        table.addCell(getCell1(cell,text, PdfPCell.ALIGN_CENTER));
			table.addCell(getCell1(cell, text1,PdfPCell.ALIGN_CENTER));
			table.addCell(getCell1( cell,text2, PdfPCell.ALIGN_CENTER));
			
			table.addCell(getCell("OBJET: "+ reunion.getObject(), PdfPCell.ALIGN_LEFT));
			table.addCell(getCell(reunion.getReport(), PdfPCell.ALIGN_LEFT));

			document.add(table);
//			System.out.println("resultat ok");
//			document.add(new Paragraph( reunion.getStartDate() +
//			reunion.getNumberParticipant()+"idresponsable type dateDebut dateFin "+
//					"objet nombreParticipant lieu compteRendu pieceJustificatif"));
//			document.add(new Paragraph( "Procés Verbal n°"+ reunion.getiDMeeting(),FontFactory.getFont(FontFactory.TIMES_BOLD,24,Font.BOLD)));
//			document.add(new Paragraph( "DU "+ reunion.getStartDate()+" AU "+reunion.getEndDate(),FontFactory.getFont(FontFactory.TIMES_BOLD,22,Font.BOLD)));
//			document.add(new Paragraph( "A L' "+ reunion.getPlaceMeeting(),FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD)));
//			document.add(new Paragraph(" -------------------------------------------------------------------------------------------------------------------------"));
//			document.add(new Paragraph( reunion.getReport(),FontFactory.getFont(FontFactory.TIMES_BOLD,16)));
//			Paragraph paragraph = new Paragraph();
//			paragraph.add("Fisrt texte");
//			paragraph.add("second texte");
//			document.add(paragraph);
		} 
		
		catch (DocumentException de) {
			de.printStackTrace();
			System.err.println("document: " + de.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		document.close();
}
	public PdfPCell getCell(String text, int alignment) {
		PdfPCell cell = new PdfPCell(new Phrase(text));
		cell.setPadding(3);
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}
	public PdfPCell getCell1(PdfPCell cell, String text, int alignment) {
		cell = new PdfPCell(new Phrase(text));
		cell.setPadding(10);
		cell.setColspan(6);
		cell.setBackgroundColor(Color.gray);
		cell.setHorizontalAlignment(alignment);
		return cell;
	}
}
