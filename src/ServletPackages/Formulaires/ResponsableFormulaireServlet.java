package ServletPackages.Formulaires;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;
import Enumeration.EnumResponsable;

/**
 * Servlet implementation class ResponsableFormulaireServlet
 */
@WebServlet("/ResponsableFormulaireServlet")
public class ResponsableFormulaireServlet extends ConnexionServlet implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> poste = new ArrayList<String>();
		for (EnumResponsable responsable : EnumResponsable.values()) {
			poste.add(responsable.toString());
		}
		request.setAttribute("responsablePoste", poste);

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Formulaire/Responsable.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultat;

		Map<String, String> erreurs = new HashMap<String, String>();

		/* Récupération des champs du formulaire. */

		String prenom = request.getParameter(FIRSTNAME);
		String nom = request.getParameter(LASTNAME);
		String email = request.getParameter(MAIL);
		String telephone = request.getParameter(PHONE);
		String poste = request.getParameter(POST);
		String sexe = request.getParameter(GENDER);
		String adresse = request.getParameter(ADRESS);

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateNow = dateFormat.format(date);
		String pseudo = ("'" + nom + "." + prenom).replaceAll("\\s", ".");

		String password = "ceamitic2016";
		Vernam passCrypt = new Vernam(password);
		password = passCrypt.encry();
		String valueResponsable = "'%'"+password+"'%" + dateNow + "%'inconnu'%"+ "'actif'";
		ConnexionServlet servlet = new ConnexionServlet();
		try {
			connection = servlet.getDataSource().getConnection();
			int rs = ComputeQueryBean.insertInAllTable(pseudo + valueResponsable, "compte", connection);
			System.err.println();
			int number = 0;
			while (rs == 0) {
				number++;
				pseudo += number;
				rs = ComputeQueryBean.insertInAllTable(pseudo + valueResponsable, "compte", connection);
			}
			valueResponsable = "null%" + pseudo + "'%" + "'" + nom + "'%" + "'" + prenom + "'%" + "'" + adresse + "'%" + "'"
					+ telephone + "'%" + "'" + email + "'%" + "'" + sexe + "'%" + "'" + poste + "'";
			rs = ComputeQueryBean.insertInAllTable(valueResponsable, "Responsable", connection);

		} catch (SQLException e) {
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

		/* Validation du champ email. */
		try {

			validationEmail(email);

		} catch (Exception e) {

			erreurs.put(MAIL, e.getMessage());

		}
		/* Validation du champ téléphone */
		try {
			validationTelephone(telephone);

		} catch (Exception e) {

			erreurs.put(PHONE, e.getMessage());
		}

		try {

			validationAdresse(adresse);

		} catch (Exception e) {

			erreurs.put(ADRESS, e.getMessage());

		}

		try {

			validationPoste(poste);

		} catch (Exception e) {

			erreurs.put(POST, e.getMessage());

		}

		if (erreurs.isEmpty()) {

			resultat = "Succès de l'inscription.";

		} else {

			resultat = "Échec de l'inscription.";

		}
		/* Stockage du résultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, erreurs);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response à notre JSP */

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/List/ListResponsable.jsp").forward(request,
				response);

	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom.trim().length() == 0)
			throw new Exception("Veuillez saisir le prénom svp");
		else if (prenom != null) {
			if (!prenom.matches("^\\D+$"))
				throw new Exception("Le prenom doit uniquement contenir des lettres");

		}

	}

	private void validationNom(String nom) throws Exception {
		if (nom.trim().length() == 0)
			throw new Exception("Veuillez saisir le nom svp");
		else if (nom != null) {
			if (!nom.matches("^\\D+$"))
				throw new Exception("Le nom doit uniquement contenir des lettres");

		}

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

	private void validationTelephone(String telephone) throws Exception {
		if (telephone != null) {

			if (!telephone.matches("^\\d+$")) {

				throw new Exception("Le numéro de téléphone est incorrect.");

			} else if (telephone.length() < 9) {

				throw new Exception("Le numéro de téléphone doit contenir au moins 9 chiffres.");

			}

		} else {

			throw new Exception("Merci d'entrer un numéro de téléphone.");
		}

	}

	private void validationAdresse(String adresse) throws Exception {
		if (adresse.trim().length() == 0)
			throw new Exception("Veuillez saisir  une adresse svp");

	}

	private void validationPoste(String poste) throws Exception {
		if (poste.trim().length() == 0)
			throw new Exception("Veuillez saisir le poste svp");

	}

}
