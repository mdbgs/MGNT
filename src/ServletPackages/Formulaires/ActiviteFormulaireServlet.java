package ServletPackages.Formulaires;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
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
import javax.swing.plaf.synth.SynthSeparatorUI;

import BeanPackage.ComputeQueryBean;
import BeanPackage.NumericConstant;
import BeanPackage.ResponsableBean;
import ModelPackage.Responsable;
import ServletPackages.GetAuthorisationUsers;

/**
 * Servlet implementation class ActiviteFormulaire
 */
@WebServlet("/ActiviteFormulaireServlet")
public class ActiviteFormulaireServlet extends GetAuthorisationUsers implements NumericConstant {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAllWritter(connection);
			ResponsableBean responsableSend = new ResponsableBean();
			while (result.next()) {
				responsableSend.AddResponsable(new Responsable(Integer.parseInt(result.getString(1)), result.getString(2),
						result.getString(3), result.getString(4), result.getString(5), result.getString(6),
						result.getString(7), result.getString(8), result.getString(9)));
			}
			req.setAttribute("responsableRecu", responsableSend);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.doGet(req, resp, "responsable_Suivi_Evaluation", "Formulaire/ActiviteFormulaire.jsp", connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errors = new HashMap<String, String>();
		String resultat;

		/* Récupération des champs du formulaire. */
		String libelle = request.getParameter(LIBELLE);
		String periode = request.getParameter(PERIODE);
		String echeancePrevu = request.getParameter(ECHEANCEPREVU);
		String echeanceRealise = request.getParameter(ECHEANCEREALISE);
		String statutActivite = request.getParameter(STATUTACTIVITE);
		String natureIndicateur = request.getParameter(NATUREINDICATEUR);
		String libelleIndicateur = request.getParameter(LIBELLEINDICATEUR);
		String referenceTabSaisie = request.getParameter(REFERENCETABSAISIE);
		String pieceJustificatif = request.getParameter(PIECEJUSTIFICATIF);
		String composant = request.getParameter(COMPOSANT);
		String objectif = request.getParameter(OBJECTIF);
		String resultatAttendu = request.getParameter(RESULTATATTENDU);

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD");
		// HomeServlet servlet = new HomeServlet();
		try {

			connection = this.getDataSource().getConnection();
			date = dateFormat.parse(periode);
			String valueActivite = "%'" + libelle + "'%" + dateFormat.format(date) + "%'" + echeancePrevu + "'%'"
					+ echeanceRealise + "'%'" + statutActivite + "'%'" + natureIndicateur + "'%'" + libelleIndicateur
					+ "'%'" + referenceTabSaisie + "'%'" + pieceJustificatif + "'%'" + composant + "'%'" + objectif
					+ "'%" + "'" + resultatAttendu + "'%";
			int rs = ComputeQueryBean.insertInAllTable(valueActivite, "Activite", connection);

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		// /* Validation du champ libelle. */
		// try {
		//
		// validationLibelle(libelle);
		//
		// } catch (Exception e) {
		//
		// errors.put(LIBELLE, e.getMessage());
		//
		// }
		//
		// /* Validation du champ période. */
		// try {
		//
		// validationPeriode(periode);
		//
		// } catch (Exception e) {
		//
		// errors.put(PERIODE, e.getMessage());
		//
		// }
		//
		// /* Validation du champ Echéance prévu. */
		// try {
		//
		// validationEcheancePrevu(echeancePrevu);
		//
		// } catch (Exception e) {
		//
		// errors.put(ECHEANCEPREVU, e.getMessage());
		//
		// }
		//
		// /* Validation du champ Echéance réalisé. */
		// try {
		//
		// validationEcheanceRealise(echeanceRealise);
		//
		// } catch (Exception e) {
		//
		// errors.put(ECHEANCEREALISE, e.getMessage());
		//
		// }
		// /* Validation du champ statut de l'activité. */
		// try {
		//
		// validationStatut(statutActivite);
		//
		// } catch (Exception e) {
		//
		// errors.put(STATUTACTIVITE, e.getMessage());
		//
		// }
		//
		// /* Validation du champ nature de l'indicateur. */
		// try {
		//
		// validationNature(natureIndicateur);
		//
		// } catch (Exception e) {
		//
		// errors.put(NATUREINDICATEUR, e.getMessage());
		//
		// }
		//
		// /* Validation du champ nature de l'indicateur. */
		// try {
		//
		// validationLibelleI(libelleIndicateur);
		//
		// } catch (Exception e) {
		//
		// errors.put(LIBELLEINDICATEUR, e.getMessage());
		//
		// }
		//
		// /* Validation du champ référence. */
		// try {
		//
		// validationReference(referenceTabSaisie);
		//
		// } catch (Exception e) {
		//
		// errors.put(REFERENCETABSAISIE, e.getMessage());
		//
		// }
		//
		// /* Validation du champ composant. */
		// try {
		//
		// validationComposant(composant);
		//
		// } catch (Exception e) {
		//
		// errors.put(COMPOSANT, e.getMessage());
		//
		// }
		//
		// /* Validation du champ objectif. */
		// try {
		//
		// validationObjectif(objectif);
		//
		// } catch (Exception e) {
		//
		// errors.put(OBJECTIF, e.getMessage());
		//
		// }
		//
		// /* Validation du champresultat attendu. */
		// try {
		//
		// validationResultat(resultatAttendu);
		//
		// } catch (Exception e) {
		//
		// errors.put(RESULTATATTENDU, e.getMessage());
		//
		// }

		if (errors.isEmpty()) {

			resultat = "Succès de l'inscription.";

		} else {

			resultat = "Échec de l'inscription.";

		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */

		request.setAttribute(ERRORS, errors);

		request.setAttribute(RESULT, resultat);

		/* Transmission de la paire d'objets request/response à notre JSP */

		request.getRequestDispatcher("/WEB-INF/jsp/ActiviteFormulaire.jsp").forward(request, response);
	}

	private void validationLibelle(String libelle) throws Exception {
		if (libelle.trim().length() == 0)
			throw new Exception("Veuillez saisir le libellé svp");

	}

	private void validationPeriode(String periode) throws Exception {
		if (periode.trim().length() == 0)
			throw new Exception("Veuillez saisir la période svp");

	}

	private void validationEcheancePrevu(String echeancePrevu) throws Exception {
		if (echeancePrevu.trim().length() == 0)
			throw new Exception("Veuillez saisir l'échéance prévu svp");

	}

	private void validationEcheanceRealise(String echeanceRealise) throws Exception {
		if (echeanceRealise.trim().length() == 0)
			throw new Exception("Veuillez saisir l'échéance prévu svp");

	}

	private void validationStatut(String statutActivite) throws Exception {
		if (statutActivite.trim().length() == 0)
			throw new Exception("Veuillez saisir le statut de l'activivité svp");

	}

	private void validationNature(String natureIndicateur) throws Exception {
		if (natureIndicateur.trim().length() == 0)
			throw new Exception("Veuillez saisir la nature de l'indicateur svp");

	}

	private void validationLibelleI(String libelleIndicateur) throws Exception {
		if (libelleIndicateur.trim().length() == 0)
			throw new Exception("Veuillez saisir le libellé de l'indicateur svp");

	}

	private void validationReference(String referenceTabSaisie) throws Exception {
		if (referenceTabSaisie.trim().length() == 0)
			throw new Exception("Veuillez saisir le reférence tableau de saisie svp");

	}

	private void validationComposant(String composant) throws Exception {
		if (composant.trim().length() == 0)
			throw new Exception("Veuillez saisir le composant svp");

	}

	private void validationObjectif(String objectif) throws Exception {
		if (objectif.trim().length() == 0)
			throw new Exception("Veuillez saisir l'objectif svp");

	}

	private void validationResultat(String resultatAttendu) throws Exception {
		if (resultatAttendu.trim().length() == 0)
			throw new Exception("Veuillez saisir le résultat attendu svp");

	}

}
