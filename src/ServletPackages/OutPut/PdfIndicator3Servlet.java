package ServletPackages.OutPut;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Cell;
//import com.lowagie.text.Document;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ServletPackages.Formulaires.ConnexionServlet;

public class PdfIndicator3Servlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;

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
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateNow = dateFormat.format(date);
		try {
			connection = this.getDataSource().getConnection();
			//ResultSet result = ComputeQueryBean.selectAll("Etudiant", connection);

			resp.setContentType("application/pdf");
			PdfWriter.getInstance(document, resp.getOutputStream());
			document.open();

			PdfPTable table = new PdfPTable(2);
			PdfPTable tablee = new PdfPTable(1);
			table.setWidthPercentage(100);
			table.setWidths(new int[] { 30, 100 });
			table.addCell(getCell("INDICATOR3:", PdfPCell.ALIGN_LEFT));
			table.addCell(
					getCell("No. of Students /faculty with at least 1 month internship in a company or a local institution relevant to their field/ sector(→ Outreach)",
							PdfPCell.ALIGN_LEFT));
			tablee.setSpacingAfter(10);

			PdfPTable table1 = new PdfPTable(1);
			table1.setWidthPercentage(100);
			table1.addCell(getCell("Reporting Period:" + dateNow, PdfPCell.ALIGN_LEFT));
			table1.setSpacingAfter(10);
			PdfPTable table2 = new PdfPTable(1);
			table2.setWidthPercentage(100);
			table2.addCell(getCell("RECORD OF INTERNSHIPS", PdfPCell.ALIGN_CENTER));
			table2.setSpacingAfter(15);
			Table table3 = new Table(11);
			table3.setWidth(100);
			Color couleur = new Color(242, 242, 242);
			Cell cell = new Cell("CONTACT DETAILS (Postal, Tel, Email)                                                                                                         ");
			cell.setColspan(3);
			cell.setHorizontalAlignment(cell.ALIGN_CENTER);
			cell.setBackgroundColor(couleur);
			table3.addCell(getCell1("NUMBER"));
			table3.addCell(getCell1("NAME"));
			table3.addCell(getCell1(" SURNAME OF INTERN"));
			table3.addCell(getCell1("STUDENT/ LECTURER"));
			table3.addCell(cell);
			table3.addCell(getCell1("YEAR OF STUDY"));
			table3.addCell(getCell1("PROGRAMME/ DEPARTMENT"));
			cell = new Cell("INTERNSHIP DURATION");
			cell.setColspan(2);
			cell.setHorizontalAlignment(cell.ALIGN_CENTER);
			cell.setBackgroundColor(couleur);
			table3.addCell(cell);
			table3.addCell(CellSansSpan("Personal Email                                                                                                             "));
			table3.addCell(CellSansSpan("Tel No."));
			table3.addCell(CellSansSpan("Address"));
			table3.addCell(CellSansSpan("Start"));
			table3.addCell(CellSansSpan("Finish"));
//			while (result.next()) {
//				table3.addCell(CellPourRemplirTableau(result.getInt(1) + ""));
//				table3.addCell(CellPourRemplirTableau(result.getString(14)));
//				table3.addCell(CellPourRemplirTableau(result.getString(3)));
//				table3.addCell(CellPourRemplirTableau(result.getString(4)));
//				table3.addCell(CellPourRemplirTableau(result.getString(10)));
//				table3.addCell(CellPourRemplirTableau(result.getString(11)));
//				table3.addCell(CellPourRemplirTableau(
//						result.getString(15) + " " + result.getString(16) + " " + result.getString(17)));
//				table3.addCell(CellPourRemplirTableau(result.getString(7)));
//				table3.addCell(CellPourRemplirTableau(result.getString(19)));
//				table3.addCell(CellPourRemplirTableau(result.getString(20)));
//				table3.addCell(CellPourRemplirTableau(result.getString(13)));
//				table3.addCell(CellPourRemplirTableau(result.getString(6)));
//				table3.addCell(CellPourRemplirTableau(result.getString(8)));
//
//			}
			document.add(table);
			document.add(tablee);
			document.add(table1);
			document.add(table2);
			document.add(table3);

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

	Font largeBold = new Font(Font.NORMAL, 32, Font.BOLD);
	Font NORMAL = new Font(Font.TIMES_ROMAN, 15, Font.BOLD, Color.BLACK);
	Font BlackFont = new Font(Font.TIMES_ROMAN, 10, Font.BOLD, Color.BLACK);

	public PdfPCell getCell(String text, int alignment) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell(new Phrase(text, NORMAL));
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public Cell getCell1(String text) {
		Cell cell = new Cell(text);
		cell.setRowspan(2);
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
		cell.setBackgroundColor(new Color(242, 242, 242));
		return cell;
	}

	public Cell CellSansSpan(String text) {
		Cell cell = new Cell(text);
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell.setBackgroundColor(new Color(242, 242, 242));
		return cell;
	}

	public Cell CellPourRemplirTableau(String text) {
		Cell cell = new Cell(text);
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
		return cell;
	}
}
