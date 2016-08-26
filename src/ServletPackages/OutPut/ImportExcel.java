package ServletPackages.OutPut;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class ImportExcel {
	public static final String VUE = "/WEB-INF/jsp/Home/AdminAccueil.jsp";
	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN_FICHIERS = "c:/CeamiticFile/";
	private static List<String> listRow = new ArrayList<String>();

	public static void chronogram(String file, Connection connection) {

		System.out.println("Nom du fichier : " + file);
		BufferedReader buffer = openBufferReader(file);
		String readLine = null;
		Statement statement;
		try {
			for (int i = 0; i < 4; i++)
				readLine = buffer.readLine();
			if (readLine != null) {
				int k = 0;
				do {
					listRow.add(readLine);
				} while ((readLine = buffer.readLine()) != null);
				readLine = buffer.readLine();
				while (k < listRow.size()) {
					String[] listeColumn = listRow.get(k).split(",");
					try {
						statement = connection.createStatement();
						// Creation Comptes des étudiants
						Date date = new Date();
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String dateNow = dateFormat.format(date);
						String pseudo =(listeColumn[2] + "." + listeColumn[3]).replaceAll("\\s", "");
						String password = "A80éZKµµ&k0Kµµ5&kRKµµR£PKéZµµàl#H£PA8";
						String query = "INSERT INTO compte(pseudo,password,dateinscription,photo,statut) VALUES('"+pseudo+"','"+password+"',"+ dateNow+",'inconnue','actif');";
						String sexe = listeColumn[10];
						int count = statement.executeUpdate(query);
						query = "INSERT INTO users_roles values ('"+pseudo+"','etudiant');";
						count = statement.executeUpdate(query);
						// Ajout des étudiants dans la BDD
						int sexeInt = 0;
						if (listeColumn[10] == "Masculin")
							sexeInt = 1;
						String sql = "INSERT INTO etudiant(iDEtudiant,pseudo,nom,prenom,email,dateNaissance,lieuNaissance,niveau,nationalite,adresse,email,telephone,bp,sexe,numeroEtudiant,pacNom,programme,semestre,anneeInscription) "
										+ "VALUES(null";
						for(int i=1;i<listeColumn.length;i++){
							if( i==4 || i ==12)
								sql+=","+listeColumn[i];
							else
								sql+=",'"+listeColumn[i]+"'";
						}
						sql+=");";
						count = statement.executeUpdate(sql);
						if (count > 0) {
							System.out.println("Enregistrement effectué");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println();
					k++;
				}
			}
		} catch (Exception e) {
			System.err.println("lecture de fichier impossible");
		}

		finally {
			try {
				buffer.close();
			} catch (Exception e) {
				System.err.println("buffer or rasterFile closing error");
			}
		}
	}

	public static BufferedReader openBufferReader(String file) {
		try {
			return new BufferedReader(new FileReader(file));
		} catch (IOException ioe) {
			System.err.println("file read error, please verify file :" + file + ". " + ioe.getMessage());
		}
		return null;
	}

	private static void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {
			}
			try {
				entree.close();
			} catch (IOException ignore) {
			}
		}
	}

	public static String getNomFichier(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public static void upload(String source, HttpServletRequest request) {
		Part part;
		try {
			part = request.getPart(source);
			// On vérifie qu'on a bien reçu un fichier
			String nomFichier = getNomFichier(part);
			// Si on a bien un fichier
			if (nomFichier != null && !nomFichier.isEmpty()) {
				String nomChamp = part.getName();
				// Corrige un bug du fonctionnement d'Internet Explorer
				nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
						.substring(nomFichier.lastIndexOf('\\') + 1);
				// On écrit définitivement le fichier sur le disque
				ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

				request.setAttribute(nomChamp, nomFichier);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
