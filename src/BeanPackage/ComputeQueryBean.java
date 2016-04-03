package BeanPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ComputeQueryBean implements NumericConstant {
	//
	// FUNCTIONS
	//
	/**
	 * Insertion in database
	 * 
	 * @throws SQLException
	 */
	public static int insertDatabase(String value, String table, Connection connexion) throws SQLException {
		String[] listRequest = value.split("%");
		int nbre = listRequest.length;
		int result = 0;
		Statement statement = null;
		try {
			System.err.println();
			statement = connexion.createStatement();
			String request = "INSERT INTO " + table + " values(";
			if (!table.equals("compte"))
				request += "null";
			request += listRequest[0];
			for (int i = 1; i < nbre; i++) {
				request += "," + listRequest[i];
			}
			request += ");";
			System.out.println(request);
			result = statement.executeUpdate(request);
			System.out.println("Nombre de lignes insérées : " + result);
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (statement != null)
				statement.close();
		}
		return result;
	}

	/**
	 * updateDatabase: met à jour les champs d'une table donnée en entrée
	 * 
	 * @throws SQLException
	 */
	public static int updateDatabase(String value, String table, Connection connexion) throws SQLException {
		int result = 0;
		String[] listRequest = value.split("%");
		Statement statement = null;
		ResultSet response = null;
		try {
			statement = connexion.createStatement();

			String request = selectQueryID(table, listRequest[0]);
			// System.out.println(request);
			response = statement.executeQuery(request);
			while (response.next()) {
				// System.out.print(response.getString(getAttributID(table)));
				if (listRequest[0].equals(response.getString(getAttributID(table)))) {
					request = computeUpdateQuery(listRequest, table);
					// System.out.println("request for update : " + request);
					try {
						result = statement.executeUpdate(request);
						System.out.println("Update ok!");
						break;
					} catch (Exception e) {
						System.err.println("Update Impossible!");
					}
				} else {
					System.out.println("id différent");
				}
			}
		} catch (Exception e) {
			System.err.println("Select impossible!");
		} finally {
			if (response != null)
				statement.close();
			if (statement != null)
				statement.close();
		}
		return result;
	}

	/** Select All rows of table by ID */
	public static ResultSet selectAll(String table, Connection connection) {
		ResultSet result = null;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM " + table + ";";
			System.out.println(query);
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Select one rows of table by ID */
	public static ResultSet selectAllByID(String table, int id, Connection connection) {
		ResultSet result = null;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM " + table + " WHERE " + getAttributID(table) + "=" + id + ";";
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Select one rows of table by ID */
	public static ResultSet selectIndicateurByNumero(int id, Connection connection) {
		ResultSet result = null;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM indicateur WHERE numero=" + id + ";";
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** getAttributID: Retourne l'attribut en String de l'ID de la table */
	public static String getAttributID(String table) {
		String attribut = "";
		switch (table) {
		case "compte":
			attribut = "pseudo";
			break;
		case "etudiant":
			attribut = "IDetudiant";
			break;
		case "enseignant":
			attribut = "IDenseignat";
			break;
		case "reunion":
			attribut = "IDreunion";
			break;
		case "publication":
			attribut = "IDpublication";
			break;
		case "activite":
			attribut = "IDactivite";
			break;
		case "formation":
			attribut = "IDformation";
			break;
		case "programmecea":
			attribut = "IDprogramme";
			break;
		case "responsable":
			attribut = "IDresponsable";
			break;
		case "animateur_relecteur":
			attribut = "IDanimateur";
			break;
		case "stage":
			attribut = "IDstage";
			break;
		case "partenaires":
			attribut = "IDpartenaire";
			break;
		case "indicateur":
			attribut = "IdIndicateur";
			break;
		}
		return attribut;
	}

	/** selectQueryID : Compute Select query in database with table */
	public static String selectQueryID(String table, String ID) {
		String query = "";
		switch (table) {
		case "compte":
			query = "SELECT pseudo FROM compte WHERE pseudo	=" + ID + ";";
			break;
		case "etudiant":
			query = "SELECT IDetudiant FROM etudiant WHERE IDetudiant=" + ID + ";";
			break;
		case "enseignant":
			query = "SELECT IDenseignat FROM enseignant WHERE IDenseignat=" + ID + ";";
			break;
		case "reunion":
			query = "SELECT IDreunion FROM reunion WHERE IDreunion=" + ID + ";";
			break;
		case "publication":
			query = "SELECT IDpublication FROM publication WHERE IDpublication=" + ID + ";";
			break;
		case "activite":
			query = "SELECT IDactivite FROM activite WHERE IDactivite=" + ID + ";";
			break;
		case "formation":
			query = "SELECT IDformation FROM formation WHERE IDformation=" + ID + ";";
			break;
		case "programmecea":
			query = "SELECT IDprogramme FROM programmecea WHERE IDprogramme=" + ID + ";";
			break;
		case "responsable":
			query = "SELECT IDresponsable FROM responsable WHERE IDresponsable=" + ID + ";";
			break;
		case "animateur_relecteur":
			query = "SELECT IDanimateur FROM animateur_relecteur WHERE IDanimateur=" + ID + ";";
			break;
		case "stage":
			query = "SELECT IDstage FROM stage WHERE IDstage=" + ID + ";";
			break;
		case "partenaires":
			query = "SELECT IDpartenaire FROM partenaires WHERE IDpartenaire=" + ID + ";";
			break;
		case "indicateur":
			query = "SELECT IdIndicateur FROM indicateur WHERE IdIndicateur=" + ID + ";";
			break;
		}
		return query;
	}

	/** Compute Update query with table name */
	public static String computeUpdateQuery(String[] listValue, String table) {
		String query = "UPDATE " + table + " SET ";
		switch (table) {
		case "compte": {
			query += "',password='" + listValue[1] + "' WHERE pseudo = " + listValue[0] + ";";
		}
			break;
		case "activite":
			query += "libelle='" + listValue[1] + "',annee=" + listValue[2] + ",echeancePrevu='" + listValue[3]
					+ "',echeanceRealise='" + listValue[4] + "',statutActivite='" + listValue[5]
					+ "',natureIndicateur='" + listValue[6] + "',libelleIndicateur='" + listValue[7]
					+ "',referenceTableauDeSaisie='" + listValue[8] + "' WHERE IDactivite = " + listValue[0] + ";";
			break;
		case "animateur_relecteur":
			query += "iDpartenaire=" + listValue[1] + ",nom='" + listValue[2] + "',prenom='" + listValue[3] + "',mail='"
					+ listValue[4] + "',telephone='" + listValue[5] + "',boitePostale='" + listValue[6]
					+ "',affliationInstitutionnel='" + listValue[7] + "' WHERE IDanimateur = " + listValue[0] + ";";
			break;
		case "enseignant":
			query += "pseudo='" + listValue[1] + "',nom='" + listValue[2] + "',prenom='" + listValue[3] + "',niveau='"
					+ listValue[4] + "',nationalite='" + listValue[5] + "',adresse='" + listValue[6] + "',email='"
					+ listValue[7] + "',telephone='" + listValue[8] + "',bp='" + listValue[9] + "',sexe='"
					+ listValue[10] + "',affliationInstitutionnel='" + listValue[11] + "' WHERE IDenseignat = "
					+ listValue[0] + ";";
			break;
		case "etudiant":
			query += "pseudo='" + listValue[1] + "',nom='" + listValue[2] + "',prenom='" + listValue[3]
					+ "',dateNaissance=" + listValue[4] + ",lieuNaissance='" + listValue[5] + "',niveau='"
					+ listValue[6] + "',nationalite='" + listValue[7] + "',adresse='" + listValue[8] + "',email='"
					+ listValue[9] + "',telephone='" + listValue[10] + "',bp='" + listValue[11] + "',sexe="
					+ listValue[12] + ",numeroEtudiant='" + listValue[13] + "',pacNom='" + listValue[14]
					+ "',pacPrenom='" + listValue[15] + "',pacTel='" + listValue[16] + "',pacAdresse='" + listValue[17]
					+ "',programme='" + listValue[18] + "',semestre='" + listValue[19] + "' WHERE IDetudiant = "
					+ listValue[0] + ";";
			break;
		case "formation":
			query += "titre='" + listValue[1] + "',institution='" + listValue[2] + "',position='" + listValue[3]
					+ "',contenu='" + listValue[4] + "' WHERE IDformation = " + listValue[0] + ";";
			break;
		case "indicateur":
			query += "numero=" + listValue[1] + ",libelle='" + listValue[2] + "',objectif='" + listValue[3]
					+ "',sigle='" + listValue[4] + "' WHERE IdIndicateur = " + listValue[0] + ";";
			break;
		case "responsable":
			query += "pseudo='" + listValue[1] + "',nom='" + listValue[2] + "',prenom='" + listValue[3] + "',adresse='"
					+ listValue[4] + "',telephone='" + listValue[5] + "',mail='" + listValue[6] + "',sexe='"
					+ listValue[7] + "',poste='" + listValue[8] + "' WHERE IDresponsable = " + listValue[0] + ";";
			break;
		case "partenaires":
			query += "pseudo='" + listValue[1] + "',nom='" + listValue[2] + "',type='" + listValue[3] + "',adresse='"
					+ listValue[4] + "',telephone='" + listValue[5] + "',email='" + listValue[6] + "',boitePostale='"
					+ listValue[7] + "',titreAccord='" + listValue[8] + "',domaineDeCollaboration='" + listValue[9]
					+ "',dateSignature=" + listValue[10] + ",expirationAccord=" + listValue[11] + ",resultatAttendu='"
					+ listValue[12] + "',projetConjoint='" + listValue[13] + "' WHERE IDpartenaire = " + listValue[0]
					+ ";";
			break;
		case "programmecea":
			query += "titre='" + listValue[1] + "',niveau='" + listValue[2] + "',typeAccreditation='" + listValue[3]
					+ "',referenceAccreditation='" + listValue[4] + "',nomAgenceD_accreditaion='" + listValue[5]
					+ "',mailAgence='" + listValue[6] + "',telAgence='" + listValue[7] + "',bpAgence='" + listValue[8]
					+ "',dateAccreditation=" + listValue[9] + ",dateExpiration=" + listValue[10] + ",type='"
					+ listValue[11] + "',statut='" + listValue[12] + "',offertPar='" + listValue[13] + "',dateCreation="
					+ listValue[14] + " WHERE IDprogramme = " + listValue[0] + ";";
			break;
		case "publication":
			query += "iDResponsable=" + listValue[1] + ",titre='" + listValue[2] + "',datePublication=" + listValue[3]
					+ ",nomJournal='" + listValue[4] + "',auteurs='" + listValue[5] + "',impactFactor='" + listValue[6]
					+ "' WHERE IDpublication = " + listValue[0] + ";";
			break;
		case "reunion":
			query += "iDResponsable=" + listValue[1] + ",type='" + listValue[2] + "',dateDebut=" + listValue[3]
					+ ",dateFin=" + listValue[4] + ",objet='" + listValue[5] + "',nombreParticipant=" + listValue[6]
					+ ",lieu='" + listValue[7] + "',compteRendu='" + listValue[8] + "' WHERE IDreunion = "
					+ listValue[0] + ";";
			break;
		case "stage":
			query += "iDEnseignat=" + listValue[1] + ",iDEtudiant=" + listValue[2] + ",iDpartenaire=" + listValue[3]
					+ ",programme_Departement='" + listValue[4] + "',dateDebut=" + listValue[5] + ",dateFin="
					+ listValue[6] + ",certificat='" + listValue[7] + "',nomInstitution='" + listValue[8]
					+ "',statueInstitution='" + listValue[9] + "',nomDirecteur='" + listValue[10]
					+ "',prenomDirecteur='" + listValue[11] + "',mailDirecteur='" + "',telDirecteur='" + listValue[12]
					+ "' WHERE IDstage = " + listValue[0] + ";";
			break;
		}
		return query;
	}

	public static boolean isUser(String pseudo, String password, Connection connection) {
		Boolean result = false;
		try {
			Statement statement = connection.createStatement();
			System.out.println("ComputeQueryBean.isUser()" +"select pseudo from compte where pseudo=" + pseudo + " and password=" + password + ";");
			ResultSet resultSet = statement.executeQuery("select pseudo from compte where pseudo='" + pseudo + "' and password='" + password + "';");
			if (statement.executeQuery("select pseudo from compte where pseudo='" + pseudo + "' and password='" + password + "';") != null)
				{
					result = true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ComputeQueryBean.isUser() : "+result);
		return result;
	}
	public static ResultSet userRole(String pseudo,Connection connection){
		Statement statement;
		ResultSet result = null;
		try{
			statement = connection.createStatement();
			result= statement.executeQuery("Select rolename from users_roles where pseudo='"+pseudo+"';");
			System.out.println("ComputeQueryBean.userRole() :"+result);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Delete in the database
	 * 
	 * @throws SQLException
	 */
	public static int deleteRowIndatabase(int id, String table, Connection connexion) throws SQLException {
		int result = 0;
		Statement statement = null;
		try {
			statement = connexion.createStatement();
			String query = "DELETE FROM " + table + " WHERE " + getAttributID(table) + "=" + id + ";";
			result = statement.executeUpdate(query);
		} catch (Exception e) {
		} finally {
			if (statement != null)
				statement.close();
		}
		return result;
	}

	// public static void main(String[] args) {
	// String requete = "";
	// String requestUpdate;
	// int result;
	// Date actuelle = new Date();
	// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	// String date = dateFormat.format(actuelle);
	// try {
	// connection = this.getDataSource().getConnection();
	// /** Test d'accés sur la table Compte */
	// requete = "'moussa.sall@sanarsoft.com'%'mypassword'%'"+date+"'%'ma photo
	// ici'";
	// result = ComputeQueryBean.insertDatabase(requete, "compte",connection);
	// requestUpdate = "'moussa.sall@sanarsoft.com'%'mypassword'%"+date+"ma
	// photo ici";;
	// result = ComputeQueryBean.updateDatabase(requestUpdate,
	// "compte",connection);
	// } catch (SQLException e) {
	// System.out.println("ComputeQueryBean.main(): erreur sur la test de
	// d'insertion ou de update");
	// }
	//
	// /** Test d'accés sur la table Activite */
	// request = "'libelle'%" + date + "%'10-12-2015'" + "%'10-12-2016'" +
	// "%'Active'" + "%'First Nature'"
	// + "%'libelle Indicateur'" + "%'reference Tableau'" + "%null";
	// result = computeQuery.insertDatabase(request, "activite");
	// requestUpdate = "1%libelle%" + date + "%10-12-2015" + "%10-12-2016" +
	// "%Active" + "%First Nature"
	// + "%libelle Indicateur" + "%reference Tableau" + "%null";
	// result = computeQuery.updateDatabase(requestUpdate, "activite");
	//
	// /** Test d'accés sur la table Partenaires */
	// request = "1%" + "'Orange'%" + "'entreprise'%" + "'Thiaroye Gare'%" +
	// "'771321556'%" + "'orange@orange.sn'%"
	// + "'dk125'%" + "'partenariat'%" + "'financement'%" + date +
	// "%'12/12/2017'%"
	// + "'Améliorer la formation'%" + "'formation'%";
	// result = computeQuery.insertDatabase(request, "partenaires");
	// requestUpdate = "1%" + "1%" + "Orange%" + "entreprise%" + "Thiaroye
	// Gare%" + "771321556%" + "orange@orange.sn%"
	// + "dk125%" + "partenariat%" + "financement%" + date + "%12/12/2017%" +
	// "Améliorer la formation%"
	// + "formation";
	// result = computeQuery.updateDatabase(requestUpdate, "partenaires");
	//
	// /** Test d'accés sur la table Animateur_Relecteur */
	// request = "1%" + "'Diack'%" + "'Seydou'%" + "'Sdiack@sanarsoft.com'%" +
	// "'771321556'%" + "'SL234'%" + "'UGB'%"
	// + "'animateur'";
	// result = computeQuery.insertDatabase(request, "animateur_relecteur");
	// requestUpdate = "1%" + "1%" + "Diack%" + "Seydou%" +
	// "Sdiack@sanarsoft.com%" + "771321556%" + "SL234%" + "UGB%"
	// + "animateur";
	// result = computeQuery.updateDatabase(requestUpdate,
	// "animateur_relecteur");
	// /** Test d'accés sur la table Enseignant */
	// request = "1%" + "'Mar'%" + "'Abdou'%" + "'Professeur Titulaire'%" +
	// "'Sénégalaise'%" + "'Aïnoumady 5'%"
	// + "'mar.abdou@sanarsoft.com'%" + "'772316584'%" + "'TH456'%" + "1%" +
	// "'UGB'";
	// result = computeQuery.insertDatabase(request, "enseignant");
	// requestUpdate = "1%" + "1%" + "Mar%" + "Abdou%" + "Professeur Titulaire%"
	// + "Sénégalaise%" + "Aïnoumady 5%"
	// + "mar.abdou@sanarsoft.com%" + "772316584%" + "TH456%" + "1%" + "UGB";
	// result = computeQuery.updateDatabase(requestUpdate, "enseignant");
	//
	// /** Test d'accés sur la table Etudiant */
	// request = "1%" + "'Sall'%" + "'Modou'%" + date + "%'Yeumbeul'%" +
	// "'Master 2'%" + "'Sénégalaise'%"
	// + "'Aïnoumady 5'%" + "'sall.modou@sanarsoft.com'%" + "'772346156'%" +
	// "'UGB234'%" + "0%" + "'P26201'%"
	// + "'sall'%" + "'Momar'%" + "'774521685'%" + "'Aïnoumady 5'%" +
	// "'Master'%" + "'2nd Semestre'";
	// result = computeQuery.insertDatabase(request, "etudiant");
	// requestUpdate = "1%" + "1%" + "Sall%" + "Modou%" + date + "%Yeumbeul%" +
	// "Master 2%" + "Sénégalaise%"
	// + "Aïnoumady 5%" + "sall.modou@sanarsoft.com%" + "772346156%" + "UGB234%"
	// + "0%" + "P26201%" + "sall%"
	// + "Momar%" + "774521685%" + "Aïnoumady 5%" + "Master%" + "2nd Semestre";
	// result = computeQuery.updateDatabase(requestUpdate, "etudiant");
	//
	// /** Test d'accés sur la table Formation */
	// request = "'SIBD2'%" + "'UGB'%" + "'second semestre'%"
	// + "'former les étudiants en système à base de connaissance'";
	// result = computeQuery.insertDatabase(request, "formation");
	// requestUpdate = "1%" + "SIBD2%" + "UGB%" + "second semestre%"
	// + "former les étudiants en système à base de connaissance";
	// result = computeQuery.updateDatabase(requestUpdate, "formation");
	//
	// /** Test d'accés sur la table Responsable */
	// request = "1%" + "'SY'%" + "'Mme'%" + "'15.Rue Felix'%" + "'775468254'%"
	// + "'mail'%" + "0" + "%'responsable'%"
	// + "'responsableCeaMitic'";
	// result = computeQuery.insertDatabase(request, "responsable");
	// requestUpdate = "1%" + "1%" + "SY%" + "Mme%" + "15.Rue Felix%" +
	// "775468254%" + "mail%" + "0" + "%responsable%"
	// + "responsableCeaMitic";
	// result = computeQuery.updateDatabase(requestUpdate, "responsable");
	// System.out.println(result);
	//
	// /** Test d'accés sur la table Programmecea */
	// request = "'Programme1'%" + "'Master'%" + "'Accreditation'%" +
	// "'refAccreditation'%" + "'CAMES'%"
	// + "'cames@cames.sn'%" + "'771548620'%" + "'sn451'%" + date + "%" + date +
	// "%" + "'permanent'%"
	// + "'Accept'%" + "'Orange'%" + date;
	// result = computeQuery.insertDatabase(request, "programmecea");
	// requestUpdate = "1%" + "Programme1%" + "Master%" + "Accreditation%" +
	// "refAccreditation%" + "CAMES%"
	// + "cames@cames.sn%" + "771548620%" + "sn451%" + date + "%" + date + "%" +
	// "permanent%" + "Accept%"
	// + "Orange%" + date;
	// result = computeQuery.updateDatabase(requestUpdate, "programmecea");
	// System.out.println(result);
	//
	// /** Test d'accés sur la table publication */
	// request = "1%" + "'Gerbille'%" + date + "%" + "'Cisco'%" + "'Moussa'%" +
	// "'Développement durable'";
	// result = computeQuery.insertDatabase(request, "publication");
	// requestUpdate = "1%" + "1%" + "Gerbille%" + date + "%" + "Cisco%" +
	// "Moussa%" + "Développement durable";
	// result = computeQuery.updateDatabase(requestUpdate, "publication");
	// System.out.println(result);
	//
	// /** Test d'accés sur la table Reunion */
	// request = "1%" + "'Administrative'%" + date + "%" + date + "%" + "'Bilan
	// annuel'%" + "12%" + "'Siège social'%"
	// + "'Voici le compte rendu'";
	// result = computeQuery.insertDatabase(request, "reunion");
	// requestUpdate = "1%" + "1%" + "Administrative%" + date + "%" + date + "%"
	// + "Bilan annuel%" + "12%"
	// + "Siège social%" + "Voici le compte rendu";
	// result = computeQuery.updateDatabase(requestUpdate, "reunion");
	// System.out.println(result);
	//
	// /** Test d'accés sur la table Stage */
	// request = "null%" + "1%" + "null%" + "'Science et Technologie'%" + date +
	// "%" + date + "%" + "'Certificat'%"
	// + "'IRD'%" + "'Institution'%" + "'LeFur'%" + "'Jean'%" +
	// "'jean.lefur@ird.fr'%" + "'772568475'";
	// result = computeQuery.insertDatabase(request, "stage");
	// requestUpdate = "1%" + "null%" + "1%" + "null%" + "Science et
	// Technologie%" + date + "%" + date + "%"
	// + "Certificat%" + "IRD%" + "Institution%" + "LeFur%" + "Jean%" +
	// "jean.lefur@ird.fr%" + "772568475";
	// result = computeQuery.updateDatabase(requestUpdate, "stage");
	// System.out.println(result);
	// }
}
