package ServletPackages;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {
	public static final String VUE = "/WEB-INF/jsp/upload.jsp";
	public static final String CHAMP_DESCRIPTION = "description";
	public static final String CHAMP_FICHIER     = "fichier";
	public static final String CHEMIN        = "chemin";
	public static final int TAILLE_TAMPON = 10240; // 10 ko



	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* Affichage de la page d'envoi de fichiers */
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		boolean isMultipart;
		String filePath;
		int maxFile=5000*1024;
		int maxMem=5*1024;
		filePath=getServletContext().getInitParameter("file_upload");
		isMultipart=ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(!isMultipart){
			out.print("file not upload");
			return;
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(maxFile);
		factory.setRepository(new File("C:\\temp"));
		ServletFileUpload upload= new ServletFileUpload(factory);
		upload.setSizeMax(maxFile);
		try{
			List fileItems=upload.parseRequest(request);
			Iterator i= fileItems.iterator();
			 while(i.hasNext()){
				 FileItem fi=(FileItem)i.next();
				 if(!fi.isFormField()){
					 String fieldName=fi.getFieldName();
					 String fileName=fi.getName();
					 String contentType=fi.getContentType();
					 boolean isInMemory=fi.isInMemory();
					 long sizeInBytes=fi.getSize();
					
				File file;
				if(fileName.lastIndexOf("\\")>=0){
					file =new File(filePath+fileName.substring(fileName.lastIndexOf("\\")));
				}else
				{
					 file =new File(filePath+fileName.substring(fileName.lastIndexOf("\\")+1));	
				}
				fi.write(file);
				out.println("file uploaded "+file);
				 }
			 }
			 		}
		catch(Exception e){
			out.println(e);
		}
		
	}
}