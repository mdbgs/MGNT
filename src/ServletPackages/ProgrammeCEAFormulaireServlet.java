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
 * Servlet implementation class ProgrammeCEAFormulaireServlet
 */
@WebServlet("/ProgrammeCEAFormulaireServlet")
public class ProgrammeCEAFormulaireServlet extends ConnexionServlet implements NumericConstant{
	private static final long serialVersionUID = 1L;
	private Connection connection;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("/WEB-INF/jsp/ProgrammeCEA.jsp").forward(request, response);

		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String resultat;
			
			Map<String, String> erreurs = new HashMap<String, String>();

			/* Récupération des champs du formulaire. */
	
			String titre = request.getParameter(TITLE);
			String niveau = request.getParameter(LEVEL);
			String type_Acc = request.getParameter(TYPE_ACCREDITATION);
			String ref_Acc = request.getParameter(REF_ACCREDITATION);
			String nom_Agence=request.getParameter(NOM_AGENCE_ACC);
			String email_Agence=request.getParameter(MAIL_AGENCE);
			String tel_Agence=request.getParameter(TEL_AGENCE);
			String bp_Agence=request.getParameter(BP_AGENCE);
			String date_Acc=request.getParameter(DATE_ACC);
			String date_Exp= request.getParameter(DATE_EXPIRATION);
			String type= request.getParameter(TYPE);
			String statut= request.getParameter(STATUT);
			String offert_Par= request.getParameter(OFFERT_PAR);
			String date_Creation= request.getParameter(DATE_CREATION);
			
			Date date = new Date();
			Date date1 = new Date();
			Date date2 = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			HomeServlet servlet = new HomeServlet();
			try {
				
				connection = servlet.getDataSource().getConnection();
				date = dateFormat.parse(date_Acc);
				date1 = dateFormat.parse(date_Exp);
				date2 = dateFormat.parse(date_Creation);
				String valueProgramme="'"+titre+"'%'"+niveau+"'%'"+type_Acc+"'%'"+ref_Acc+"'%'"+nom_Agence+"'%'" +email_Agence+"'%'"+tel_Agence+"'%'" +bp_Agence+"'%'" +dateFormat.format(date)+"'%'" +dateFormat.format(date1)+"'%'"+type+"'%"
				+ "'"+statut+"'%'"+offert_Par+"'%'"+dateFormat.format(date2)+"'" ; 
				int rs= ComputeQueryBean.insertDatabase(valueProgramme, "ProgrammeCEA",connection);
				
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			} 
					
}
}		
