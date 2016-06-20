package ServletPackages;

import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import com.lowagie.text.Cell;
//import com.lowagie.text.Document;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import BeanPackage.ComputeQueryBean;
import ModelPackage.Teacher;
import ModelPackage.Activite;
import ModelPackage.Reunion;
import ModelPackage.Student;

@WebServlet("/PdfIndicator2")
public class PdfIndicator2 extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public PdfIndicator2() {
		super();
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Document document = new Document();
		Rectangle two = new Rectangle(1800,800);
		document.setPageSize(two);
		Connection connection;
	    Statement statement;
	       Date date = new Date();
		   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		   String dateNow = dateFormat.format(date);
		try {
			//Image image=Image.getInstance("logo.png");
//			BaseFont baseFont3 = BaseFont.createFont(BaseFont.TIMES_ROMAN, null, false);
//	        Font font2 = new Font(baseFont3, 12);
//			image.scalePercent(10f);
//			image.setAbsolutePosition(50f, 650f);
			//image.setAbsolute();
			//URL url = new URL("file:/C:/Users/awa/git/MGNT/logo.png");
			//image.setUrl(url);
			//System.out.println(image.getUrl()+"jjj");
			//image.scaleToFit(5,5);
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("Programmecea", connection);					   
			resp.setContentType("application/pdf");
			PdfWriter.getInstance(document, resp.getOutputStream());
			document.open();
            
			PdfPTable table = new PdfPTable(2);
			PdfPTable tablee = new PdfPTable(1);
			table.setWidthPercentage(100);
			table.setWidths(new int[]{30, 70});
			table.addCell(getCell("INDICATOR2:", PdfPCell.ALIGN_LEFT));
      		table.addCell(getCell("No. of internationally accredited education programs",PdfPCell.ALIGN_CENTER));
      	    tablee.addCell(getCell(	"(with national accreditation and international evaluation counting 50%)  (→ Training Quality)", PdfPCell.ALIGN_CENTER));
      	    tablee.setSpacingAfter(10);
      		
     	    PdfPTable table1 = new PdfPTable(1);
     	    table1.setWidthPercentage(100);
			table1.addCell(getCell("Reporting Period:"+dateNow, PdfPCell.ALIGN_LEFT));
			table1.setSpacingAfter(10);
     	    PdfPTable table2 = new PdfPTable(1);
     	    table2.setWidthPercentage(100);
			table2.addCell(getCell(" RECORD OF ACE PROGRAMME ACREDITATION ", PdfPCell.ALIGN_CENTER));
			table2.setSpacingAfter(10);
     	    Table table3 = new Table(7);
     	  // table3.setWidthPercentage(100);
     	  table3.setWidths(new int[]{15,5,15,15,30,15,15});
	     	   table3.addCell(getCell1("PROGRAMME TITLE"));
	     	   table3.addCell(getCell1("LEVEL[1]"));
	     	   table3.addCell(getCell1("TYPE OF ACCREDITATION[2]"));
	     	   table3.addCell(getCell1("ACCREDITATION REFERENCE "));
	     	   table3.addCell(getCell1("NAME AND CONTACTS OF THE ACCREDITATION AGENCY[2]"));
	     	   table3.addCell(getCell1("DATE OF ACCREDITATION"));
	     	   table3.addCell(getCell1("EXPIRY DATE OF ACCREDITATION"));
	     	   
//	     	   table3.addCell("amy");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   
//	     	   table3.addCell("amy");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   
//	     	   table3.addCell("amy");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
//	     	   table3.addCell("");
	     	  while (result.next()) {
					table3.addCell(CellPourRemplirTableau(result.getString(2)));
					table3.addCell(CellPourRemplirTableau(result.getString(3)));
					table3.addCell(CellPourRemplirTableau(result.getString(4)));
					table3.addCell(CellPourRemplirTableau(result.getString(5)));
					table3.addCell(CellPourRemplirTableau(result.getString(6)));
					table3.addCell(CellPourRemplirTableau(Integer.toString(result.getInt(10))));
					table3.addCell(CellPourRemplirTableau(Integer.toString(result.getInt(11))));
					
	     	  }

	     	 // table3.setSpacingAfter(10);
	     	   
	     	 // document.add(image);
	     	  document.add(table);
	     	  document.add(tablee);
	     	  document.add(table1);
	     	  document.add(table2);
	     	  document.add(table3);
document.add(new Paragraph( "[1] Indicate whether PhD, MSc, Short Course or Professional Training",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,Color.blue)));
document.add(new Paragraph( "[2] Indicate if the accreditation is international, regional, national, via ISO, etc.",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,Color.blue)));
document.add(new Paragraph( "[3] Provide the name and contacts (postal address, email and telephone number) of the agency",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,Color.blue)));
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
	
	Font largeBold = new Font(Font.NORMAL, 32,
            Font.BOLD);
    Font NORMAL= new Font(Font.TIMES_ROMAN, 15,
            Font.BOLD,Color.BLACK);
    Font BlackFont = new Font(Font.TIMES_ROMAN, 10,
            Font.BOLD, Color.BLACK);
	public PdfPCell getCell(String text , int alignment ) throws DocumentException, IOException
	{
	    PdfPCell cell = new PdfPCell(new Phrase(text,NORMAL));
	    //cell.setPadding(8);
	    //cell.setColspan(0);
	    cell.setHorizontalAlignment(alignment);
	    cell.setBorder(PdfPCell.NO_BORDER);
	    
	    return cell;
	}
	public Cell getCell1(String text) {
		Cell cell = new Cell(text);
		cell.setRowspan(2);
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell.setHorizontalAlignment(Cell.ALIGN_MIDDLE);
		cell.setBackgroundColor(new Color(242, 242, 242));
		return cell;

	}
	public Cell CellPourRemplirTableau(String text) {
		Cell cell = new Cell(text);
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell.setHorizontalAlignment(Cell.ALIGN_MIDDLE);
		return cell;
	}
}

//      	PdfPCell cell = null;
//			PdfPCell cell1=new PdfPCell(new Paragraph("SEANCE DU "+ reunion.getStartDate()+" AU "+reunion.getEndDate()));
//			PdfPCell cell2=new PdfPCell(new Paragraph(reunion.getPlaceMeeting()));
//			cell.setColspan(4);
//			cell1.setColspan(4);
//			cell2.setColspan(4);
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell.setBackgroundColor(Color.GREEN);
//			table.setWidthPercentage(100);
//			table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
//			table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
//			
// 	        table.addCell(getCell1(cell,text, PdfPCell.ALIGN_CENTER));
//			table.addCell(getCell1(cell, text1,PdfPCell.ALIGN_CENTER));
//			table.addCell(getCell1( cell,text2, PdfPCell.ALIGN_CENTER));
//			
//			table.addCell(getCell("OBJET: "+ reunion.getObject(), PdfPCell.ALIGN_LEFT));
//			table.addCell(getCell(reunion.getReport(), PdfPCell.ALIGN_LEFT));

			
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
			
			
	