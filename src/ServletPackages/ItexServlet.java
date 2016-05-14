package ServletPackages;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.lowagie.text.Document;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

@WebServlet("/ItexServlet")
public class ItexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItexServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document document = new Document();
		try {
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("voila mon premier pdf,c'est super!ouff",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,Color.RED)));
		} catch (DocumentException de) {
			de.printStackTrace();
			System.err.println("document: " + de.getMessage());
		}
		document.close();
	}
}