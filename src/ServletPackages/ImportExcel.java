package ServletPackages;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


public class ImportExcel {
	public static final String VUE = "/WEB-INF/jsp/AdminAccueil.jsp";
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "D:/fichiers/"; 
	private static ArrayList<String> listRow = new ArrayList<String>();
	public static void chronogram(String file,Connection connection) {
		
		System.out.println("Nom du fichier : "+file);
		BufferedReader buffer = openBufferReader(file);
		String readLine;
		ArrayList<String> values=new ArrayList<String>();
	    Statement statement;
		try 
		       {
			readLine = buffer.readLine();
			readLine = buffer.readLine();
		if (readLine != null)
		       {
			//int k=8;
			System.err.println("****************************Affichage par ligne du fichier CSV ***************************");
				do {
					listRow.add(readLine);
					} while ((readLine = buffer.readLine()) != null); 
			System.err.println("****************************Fin de l'affichage ***************************");
			//readLine = buffer.readLine(); 
		    //while (k<325){
			    values.clear();
				String[] listeColumn  = listRow.get(35).split(";");
				for(int i=0;i<listeColumn.length;i++)
				              {
						System.out.print(listeColumn[i]+" ");
				        values.add(listeColumn[i]);
				               }
				   System.out.println();
				try{
				   statement = connection.createStatement();
            //Creation Comptes des étudiants
				   Date date = new Date();
				   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				   String dateNow = dateFormat.format(date);
				   String pseudo = values.get(1)+"."+values.get(2);
				   String valueEtudiant= "ceamitic2016/"+values.get(1);
				   String sexe=values.get(10);
String sqll =String.format("INSERT INTO compte(pseudo,password,dateinscription) VALUES('%s','%s','%s')",
				   pseudo,valueEtudiant,dateNow);
				   int counnt=statement.executeUpdate(sqll);
           //Ajout des étudiants dans la BDD
				   int sexeInt=0;
				   if (sexe=="Masculin")
					   sexeInt=0;
				   if (values.get(10)=="Feminin") 
				       sexeInt=1;
String sql =String.format("INSERT INTO etudiant(iDEtudiant,numeroEtudiant,nom,prenom,email,telephone,niveau,"
		                + "programme,semestre,sexe,lieuNaissance,nationalite,pseudo) "
		                + "VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%d','%s','%s','%s')",
				   		values.get(0),values.get(1),values.get(2),values.get(3),values.get(4),values.get(5),
				   		values.get(6),
                        values.get(8),values.get(9),sexeInt,values.get(11),values.get(12),pseudo);
					    System.out.println();
				        int count=statement.executeUpdate(sql);
				        if (count>0)
				              {
					    System.out.println("Enregistrement effectué");
				              }
				                 }
				  catch (Exception e) 
				               {
					   e.printStackTrace();
				               }
				 System.out.println();
				       //k++;
				       }
			//}
			} 
		catch (Exception e)
		         {
			System.err.println("lecture de fichier impossible");
		        }
		
		finally {
			try {
				buffer.close();
			     } 
			catch (Exception e) 
			      {
			System.err.println( "buffer or rasterFile closing error");
			      }
		}
	}
	
	public static BufferedReader openBufferReader(String file) {
		try {
			return new BufferedReader(new FileReader(file));
		} catch (IOException ioe) {
			System.err.println("file read error, please verify file :" + file+ ". " + ioe.getMessage());
		}
		return null;
	}
	private static void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
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
    
    public static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    } 
	public static void upload(String source,HttpServletRequest request) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
	}
	//test de la fonction chronogram
	/*public static void main(String[] args) throws SQLException {
		File chemin="D:/LAC/UGB_CEA-MITIC_Cadre de résultats N°4_27_11_2015 Corrigé par AUA & UGB.csv";
		    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/ceamitic","root","");
			chronogram(chemin,connection);*/
	
	}


