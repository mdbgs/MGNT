package ServletPackages;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;

/**
 * Servlet implementation class EtudiantFormulaireServlet
 */
@WebServlet("/EtudiantFormulaireServlet")
public class EtudiantFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
       

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/Etudiant.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		
		Map<String, String> errors = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */
//		try {
//	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//	        for (FileItem item : items) {
//	            if (item.isFormField()) {
//	                // Traiter les champs classiques ici (input type="text|radio|checkbox|etc", select, etc).
//	                String fieldname = item.getFieldName();
//	                String fieldvalue = item.getString();
//	                // ... (traitement à faire)
//	            } else {
//	                // Traiter les champs de type fichier (input type="file").
//	                String fieldname = item.getFieldName();
//	                String filename = FilenameUtils.getName(item.getName());
//	                InputStream filecontent = item.getInputStream();
//	                // ... (traitement à faire)
//	            }
//	        }
//	    } catch (FileUploadException e) {
//	        throw new ServletException("Échec de l'analyse de la requête multipart.", e);
//	    }
		
		String numeroEtudiant="null";
		if(request.getParameter(STUDENTNUMBER)!=""){
			 numeroEtudiant=request.getParameter(STUDENTNUMBER);
		}
		String prenom = "null";
		String nom =  "null";
		String dateN =  "null";
		String phonePAC= "null";
		String adressePAC= "null";
		String niveau= "null";
		String adresse= "null";
		String programme= "null";
		String semestre= "null";
		String sexe= "null";
		String lieuDeNaiss= "null";
		String nationalite= "null";
		String boitePostale= "null";
		String email =   "null";
		String telephone=  "null";
		String nomPAC=  "null";
		String prenomPAC=  "null";
	    String photo="null";
		

		if(request.getParameter(FIRSTNAME)!=""){
			prenom=request.getParameter(FIRSTNAME);
		}
		if(request.getParameter(LASTNAME)!=""){
			nom=request.getParameter(LASTNAME);
		}
		if(request.getParameter(BIRTHDAY)!=""){
			dateN=request.getParameter(BIRTHDAY);
		}
		if(request.getParameter(MAIL)!=""){
			email=request.getParameter(MAIL);
		}
		if(request.getParameter(PHONE)!=""){
			telephone=request.getParameter(PHONE);
		}
		if(request.getParameter(PacLASTNAME)!=""){
			nomPAC=request.getParameter(PacLASTNAME);
		}
		if(request.getParameter(PacFIRSTNAME)!=""){
			prenomPAC=request.getParameter(PacFIRSTNAME);
		}
		if(request.getParameter(PacPHONE)!=""){
			phonePAC=request.getParameter(PacPHONE);
		}
		if(request.getParameter(PacADRESS)!=""){
			adressePAC=request.getParameter(PacADRESS);
		}
		if(request.getParameter(LEVEL)!=""){
			niveau=request.getParameter(LEVEL);
		}
		if(request.getParameter(ADRESS)!=""){
			adresse=request.getParameter(ADRESS);
		}
		if(request.getParameter(PROGRAM)!=""){
			programme=request.getParameter(PROGRAM);
		}
		if(request.getParameter(SEMESTER)!=""){
			semestre=request.getParameter(SEMESTER);
		}
		if(request.getParameter(GENDER)!=""){
			sexe=request.getParameter(GENDER);
		}
		if(request.getParameter(COUNTRYOFBIRTH)!=""){
			lieuDeNaiss=request.getParameter(COUNTRYOFBIRTH);
		}
		if(request.getParameter(NATIONALITY)!=""){
			nationalite=request.getParameter(NATIONALITY);
		}
		if(request.getParameter(BP)!=""){
			boitePostale=request.getParameter(BP);
			System.out.println();
		}
		
		boolean isMultipart;
		String filePath;
		int maxFile=5000*1024;
		int maxMem=5*1024;
		String namePhoto="";
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
					 namePhoto=fileName;
				File file;
				if(fileName.lastIndexOf("\\")>=0){
					file =new File(filePath+fileName.substring(fileName.lastIndexOf("\\")));
				}else
				{
					 file =new File(filePath+fileName.substring(fileName.lastIndexOf("\\")+1));	
				}
				fi.write(file);
				out.println("file uploaded "+fileName);
				 }
			 }
			 		}
		catch(Exception e){
			out.println(e);
		}
		
		System.err.println(namePhoto);
		
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateNow = dateFormat.format(date);
		String pseudo = ("'"+nom+"."+prenom).replaceAll("\\s", "_");
//		String valueEtudiant= "'%'ceamitic2016'%"+dateNow+"%'inconnu'%";
		String valueEtudiant= "%'ceamitic2016'%"+dateNow+"%'"+namePhoto+"'%";
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertDatabase(pseudo+valueEtudiant, "compte",connection);
//			int number = 0;
//			while(rs==0){
//				number++;
//				pseudo+=number;
//				rs = ComputeQueryBean.insertDatabase(pseudo+valueEtudiant, "compte",connection);
//			}
			date = dateFormat.parse(dateN);
			valueEtudiant="%"+pseudo+"'%" + "'"+nom+"'%'"+prenom+"'%" + dateFormat.format(date) + "%'"+lieuDeNaiss+"'%'"+niveau+"'%'"+nationalite+"'%'" +adresse+"'%'"+email+"'%'" +telephone+"'%'" +boitePostale+"'%" +sexe+"%" + "'"+numeroEtudiant+"'%"
			+ "'"+nomPAC+"'%" + "'"+prenomPAC+"'%'"+phonePAC+"'%'"+adressePAC+"'%'"+programme+"'%'"+semestre+"'";
			rs= ComputeQueryBean.insertDatabase(valueEtudiant, "Etudiant",connection);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
		/* Validation du champ prenom. */
		try {
			validationPrenom(prenom);

		} catch (Exception e) {

			errors.put(FIRSTNAME, e.getMessage());

		}
		
		/* Validation du champ nom. */
		try {

			validationNom(nom);

		} catch (Exception e) {

	errors.put(LASTNAME, e.getMessage());

		}
		/* Validation du champ numero etudiant. */
		try {

			validationNumEtudiant(numeroEtudiant);

		} catch (Exception e) {

			errors.put(STUDENTNUMBER, e.getMessage());

		}
		/* Validation du champ email. */
		try {

			validationEmail(email);

		} catch (Exception e) {

			errors.put(MAIL, e.getMessage());

		}
		/* Validation du champ téléphone*/
		try{
			validationTelephone(telephone);
			
		} catch(Exception e){
			
			errors.put(PHONE, e.getMessage());
		}
		/* Validation du champ niveau. */
		
		try {

			validationNiveau(niveau);

		} catch (Exception e) {

			errors.put(LEVEL, e.getMessage());

		}
		
		try {

			validationProgramme(programme);

		} catch (Exception e) {

			errors.put(PROGRAM, e.getMessage());

		}
		try {

			validationSemestre(semestre);

		} catch (Exception e) {

			errors.put(SEMESTER, e.getMessage());

		}
		try {

			validationLieuDeNaissance(lieuDeNaiss);

		} catch (Exception e) {

			errors.put(COUNTRYOFBIRTH, e.getMessage());

		}
		try {

			validationNationalite(nationalite);

		} catch (Exception e) {

			errors.put(NATIONALITY, e.getMessage());

		}
		
		if (errors.isEmpty()) {

			resultat = "Succès de l'inscription.";

		} else {

			resultat = "Échec de l'inscription.";

		}
		/* Stockage du résultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, errors);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response à notre JSP */

		request.getRequestDispatcher("/WEB-INF/jsp/Etudiant.jsp").forward(request, response);

	}
	
	
	private void validationPrenom(String prenom) throws Exception {
		if(prenom.trim().length()==0)
			throw new Exception("Veuillez saisir le prénom svp");
			else
				if (prenom != null) {
					if(!prenom.matches("^\\D+$" ))
						throw new Exception("Le prenom doit uniquement contenir des lettres");
				
			}
		
	}

	private void validationNom(String nom) throws Exception {
		if(nom.trim().length()==0)
			throw new Exception("Veuillez saisir le nom svp");
			else
				if (nom != null) {
					if(!nom.matches("^\\D+$" ))
						throw new Exception("Le nom doit uniquement contenir des lettres");

		}

	}
	
	private void validationNumEtudiant(String numeroEtudiant){
		
	}
	
	private void validationEmail(String email) throws Exception {

		if (email != null && email.trim().length() != 0) {

			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

				throw new Exception("Merci de saisir une adresse mail valide.");

			}

		} else {

			throw new Exception("Merci de saisir une adresse mail.");

		}

	}
	private void validationTelephone(String telephone) throws Exception{
		if ( telephone != null ) {

            if ( !telephone.matches( "^\\d+$" ) ) {

                throw new Exception( "Le numéro de téléphone est incorrect." );

            } else if ( telephone.length() < 9 ) {
                throw new Exception( "Le numéro de téléphone doit contenir au moins 9 chiffres." );

            }

        } else {

            throw new Exception( "Merci d'entrer un numéro de téléphone." );
            }
		
	}
	
	private void validationNiveau(String niveau) throws Exception{
		if(niveau.trim().length()==0)
			throw new Exception("Veuillez saisir le niveau svp");
		
	}
	
	private void validationProgramme(String programme) throws Exception{
		if(programme.trim().length()==0)
			throw new Exception("Veuillez saisir le programme svp");
		
	}
	
	private void validationNationalite(String nationalite) throws Exception{
		if(nationalite.trim().length()==0)
			throw new Exception("Veuillez saisir la nationalité svp");
		
	}

	private void validationLieuDeNaissance(String lieuDeNaiss) throws Exception{
		if(lieuDeNaiss.trim().length()==0)
			throw new Exception("Veuillez saisir le lieu de naissance svp");
	}
	
	
	private void validationSemestre(String semestre) throws Exception{
		if(semestre.trim().length()==0)
			throw new Exception("Veuillez saisir le semestre svp");
	}
	
}
