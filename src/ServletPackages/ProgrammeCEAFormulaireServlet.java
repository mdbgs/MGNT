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
public class ProgrammeCEAFormulaireServlet extends GetAuthorisationUsers implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			connection = this.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.doGet(request, response, "responsable_Suivi_Evaluation", "ProgrammeCEA.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultat;

		Map<String, String> errors = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */

		String titre = request.getParameter(TITLE);
		String niveau = request.getParameter(LEVEL);
		String type_Acc = request.getParameter(TYPE_ACCREDITATION);
		String ref_Acc = request.getParameter(REF_ACCREDITATION);
		String nom_Agence = request.getParameter(NOM_AGENCE_ACC);
		String email_Agence = request.getParameter(MAIL_AGENCE);
		String tel_Agence = request.getParameter(TEL_AGENCE);
		String bp_Agence = request.getParameter(BP_AGENCE);
		String date_Acc = request.getParameter(DATE_ACC);
		String date_Exp = request.getParameter(DATE_EXPIRATION);
		String type = request.getParameter(TYPE);
		String statut = request.getParameter(STATUT);
		String offert_Par = request.getParameter(OFFERT_PAR);
		String date_Creation = request.getParameter(DATE_CREATION);

		Date date = new Date();
		Date date1 = new Date();
		Date date2 = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		ConnexionServlet servlet = new ConnexionServlet();
		try {

			connection = servlet.getDataSource().getConnection();
			date = dateFormat.parse(date_Acc);
			date1 = dateFormat.parse(date_Exp);
			date2 = dateFormat.parse(date_Creation);
			String valueProgramme = "%'" + titre + "'%'" + niveau + "'%'" + type_Acc + "'%'" + ref_Acc + "'%'"
					+ nom_Agence + "'%'" + email_Agence + "'%'" + tel_Agence + "'%'" + bp_Agence + "'%"
					+ dateFormat.format(date) + "%" + dateFormat.format(date1) + "%'" + type + "'%" + "'" + statut
					+ "'%'" + offert_Par + "'%" + dateFormat.format(date2);
			int rs = ComputeQueryBean.insertDatabase(valueProgramme, "ProgrammeCEA", connection);

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		/* Validation du champ titre. */
		try {

			validationNom(titre);

		} catch (Exception e) {

			errors.put(TITLE, e.getMessage());

		}

		/* Validation du champ niveau. */
		try {

			validationNiveau(niveau);

		} catch (Exception e) {

			errors.put(LEVEL, e.getMessage());

		}

		/* Validation du champ type accréditation. */
		try {

			validationTypeAcc(type_Acc);

		} catch (Exception e) {

			errors.put(TYPE_ACCREDITATION, e.getMessage());

		}

		/* Validation du champ ref accréditation. */
		try {

			validationAgence(ref_Acc);

		} catch (Exception e) {

			errors.put(REF_ACCREDITATION, e.getMessage());

		}

		/* Validation du champ nom agence. */
		try {

			validationRefACC(nom_Agence);

		} catch (Exception e) {

			errors.put(NOM_AGENCE_ACC, e.getMessage());

		}
		/* Validation du champ mail agence. */
		try {

			validationMail_Agence(email_Agence);

		} catch (Exception e) {

			errors.put(MAIL_AGENCE, e.getMessage());

		}
		/* Validation du champ téléphone. */
		try {

			validationTel_Agence(tel_Agence);

		} catch (Exception e) {

			errors.put(TEL_AGENCE, e.getMessage());

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

		request.getRequestDispatcher("/WEB-INF/jsp/ProgrammeCEA.jsp").forward(request, response);
	}

	private void validationNom(String titre) throws Exception {
		if (titre.trim().length() == 0)
			throw new Exception("Veuillez saisir le titre svp");

	}

	private void validationNiveau(String niveau) throws Exception {
		if (niveau.trim().length() == 0)
			throw new Exception("Veuillez saisir le niveau svp");

	}

	private void validationTypeAcc(String type_Acc) throws Exception {
		if (type_Acc.trim().length() == 0)
			throw new Exception("Veuillez saisir le type d'accréditation svp");

	}

	private void validationRefACC(String ref_Acc) throws Exception {
		if (ref_Acc.trim().length() == 0)
			throw new Exception("Veuillez saisir le référence d'accréditation svp");

	}

	private void validationAgence(String nom_Agence) throws Exception {
		if (nom_Agence.trim().length() == 0)
			throw new Exception("Veuillez saisir l'agence d'accréditation svp");

	}

	private void validationMail_Agence(String email_Agence) throws Exception {
		if (email_Agence != null && email_Agence.trim().length() != 0) {

			if (!email_Agence.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

				throw new Exception("Merci de saisir une adresse mail valide.");

			}

		} else {

			throw new Exception("Merci de saisir une adresse mail.");

		}

	}

	private void validationTel_Agence(String tel_Agence) throws Exception {
		if (tel_Agence != null) {

			if (!tel_Agence.matches("^\\d+$")) {

				throw new Exception("Le numéro de téléphone est incorrect.");

			} else if (tel_Agence.length() < 9) {

				throw new Exception("Le numéro de téléphone doit contenir au moins 9 chiffres.");

			}

		} else {

			throw new Exception("Merci d'entrer un numéro de téléphone.");
		}

	}

}
