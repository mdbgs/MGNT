package ServletPackages;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;

import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;


@WebServlet("/ItexServlet")
public class ItexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public ItexServlet() {
        super(); }
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            	Document document = new Document();
            	try {
            	response.setContentType("application/pdf");
            	PdfWriter.getInstance(document, response.getOutputStream());
            		            
            	document.open();
            	document.add(new Paragraph("voila mon premier pdf,c'est super!ouff"));
            	}
            	catch(DocumentException de) {
            	de.printStackTrace();
            	System.err.println("document: " + de.getMessage());
            	}
            		        
            	document.close();}}