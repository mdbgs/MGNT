package ServletPackages;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Map<String, String> erreurs = new HashMap<String, String>();

		/* R�cup�ration des champs du formulaire. */
//		try {
//	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//	        for (FileItem item : items) {
//	            if (item.isFormField()) {
//	                // Traiter les champs classiques ici (input type="text|radio|checkbox|etc", select, etc).
//	                String fieldname = item.getFieldName();
//	                String fieldvalue = item.getString();
//	                // ... (traitement � faire)
//	            } else {
//	                // Traiter les champs de type fichier (input type="file").
//	                String fieldname = item.getFieldName();
//	                String filename = FilenameUtils.getName(item.getName());
//	                InputStream filecontent = item.getInputStream();
//	                // ... (traitement � faire)
//	            }
//	        }
//	    } catch (FileUploadException e) {
//	        throw new ServletException("�chec de l'analyse de la requ�te multipart.", e);
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
		Date date = new Date();
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateNow = dateFormat.format(date);
		String pseudo = ("'"+nom+"."+prenom).replaceAll("\\s", "_");
		String valueEtudiant= "'%'ceamitic2016'%"+dateNow+"%'Etudiant'%'Inconnue'";
		HomeServlet servlet = new HomeServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertDatabase(pseudo+valueEtudiant, "compte",connection);
			int number = 0;
			while(rs==0){
				number++;
				pseudo+=number;
				rs = ComputeQueryBean.insertDatabase(pseudo+valueEtudiant, "compte",connection);
			}
			date = dateFormat.parse(dateN);
			valueEtudiant=pseudo+"%" + "'"+nom+"'%'"+prenom+"'%" + dateFormat.format(date) + "%'"+lieuDeNaiss+"'%'"+niveau+"'%'"+nationalite+"'%'" +adresse+"'%'"+email+"'%'" +telephone+"'%'" +boitePostale+"'%" +sexe+"%" + "'"+numeroEtudiant+"'%"
			+ "'"+nomPAC+"'%" + "'"+prenomPAC+"'%'"+phonePAC+"'%'"+adressePAC+"'%'"+programme+"'%'"+semestre+"'";
			rs= ComputeQueryBean.insertDatabase(valueEtudiant, "Etudiant",connection);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
		/* Validation du champ prenom. */
		try {
			validationPrenom(prenom);

		} catch (Exception e) {

			erreurs.put(FIRSTNAME, e.getMessage());

		}
		
		/* Validation du champ nom. */
		try {

			validationNom(nom);

		} catch (Exception e) {

			erreurs.put(LASTNAME, e.getMessage());

		}
		/* Validation du champ nom. */
		try {

			validationNumEtudiant(numeroEtudiant);

		} catch (Exception e) {

			erreurs.put(STUDENTNUMBER, e.getMessage());

		}
		/* Validation du champ email. */
		try {

			validationEmail(email);

		} catch (Exception e) {

			erreurs.put(MAIL, e.getMessage());

		}
		/* Validation du champ t�l�phone*/
		try{
			validationTelephone(telephone);
			
		} catch(Exception e){
			
			erreurs.put(PHONE, e.getMessage());
		}
		/* Validation du champ Personne � contacter. */
		
		try {

			validationNiveau(niveau);

		} catch (Exception e) {

			erreurs.put(LEVEL, e.getMessage());

		}
		
		try {

			validationProgramme(programme);

		} catch (Exception e) {

			erreurs.put(PROGRAM, e.getMessage());

		}
		try {

			validationSemestre(semestre);

		} catch (Exception e) {

			erreurs.put(SEMESTER, e.getMessage());

		}
		try {

			validationProgrammeLieuDeNaissance(programme);

		} catch (Exception e) {

			erreurs.put(COUNTRYOFBIRTH, e.getMessage());

		}
		try {

			validationNationalite(nationalite);

		} catch (Exception e) {

			erreurs.put(NATIONALITY, e.getMessage());

		}
		
		/*try {

			validationRegion(region);

		} catch (Exception e) {

			erreurs.put(area, e.getMessage());

		}*/
		
		if (erreurs.isEmpty()) {

			resultat = "Succ�s de l'inscription.";

		} else {

			resultat = "�chec de l'inscription.";

		}
		/* Stockage du r�sultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, erreurs);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response � notre JSP */

		request.getRequestDispatcher("/WEB-INF/jsp/ListEtudiant.jsp").forward(request, response);

	}
	
	

	

	private void validationPrenom(String prenom) throws Exception {
		if(prenom.trim().length()==0)
			throw new Exception("Veuillez saisir le pr�nom svp");
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
	
	public void validationNumEtudiant(String numeroEtudiant){
		
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
	public void validationTelephone(String telephone) throws Exception{
		if ( telephone != null ) {

            if ( !telephone.matches( "^\\d+$" ) ) {

                throw new Exception( "Le num�ro de t�l�phone doit uniquement contenir des chiffres." );

            } else if ( telephone.length() < 4 ) {
                throw new Exception( "Le num�ro de t�l�phone doit contenir au moins 4 chiffres." );

            }

        } else {

            throw new Exception( "Merci d'entrer un num�ro de t�l�phone." );
            }
		
	}
	
	public void validationPersonneContacter(String personneContacter)throws Exception{
		if(personneContacter.trim().length()==0)
			throw new Exception("Veuillez saisir le nom svp");
			else
				if (personneContacter != null) {
					if(!personneContacter.matches("^\\D+$" ))
						throw new Exception("Ce champs doit uniquement contenir des lettres");

		}
		
	}
	
	public void validationNiveau(String niveau){
		
	}
	
	public void validationProgramme(String programme){
		
	}
	private void validationRegion(String region) {
		
	}

	private void validationNationalite(String nationalite) {
		
	}

	private void validationProgrammeLieuDeNaissance(String programme) {
		
	}
	
	private void validationSemestre(String semestre) {
		
	}
	
}
