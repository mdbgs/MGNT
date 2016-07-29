package ServletPackages.OutPut;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvGenerator {
	private String $DOSSIER = "c:/";
	private String fileName = "";
	private PrintWriter printer;
	public int numRun = 0;
	//
	// CONSTRUCTOR
	//
	/** Create a new output data file */
	public CsvGenerator(String fileNameOrUrlPlusFileName, boolean incrementNameOrNot) {
		// Création du dossier (s'il n'existe pas encore)
		if (fileNameOrUrlPlusFileName.contains("/")) // if the complete url is given
			buildFolders(fileNameOrUrlPlusFileName);
		
		// Création du fichier, récupération de la dernière partie de l'URL Ex: titre.extension dans rep1/rep1.1/titre.extension
		fileNameOrUrlPlusFileName = fileNameOrUrlPlusFileName.split("/")[fileNameOrUrlPlusFileName.split("/").length - 1];
		File file = new File($DOSSIER + numRun + fileNameOrUrlPlusFileName);
		if (incrementNameOrNot) { // En incrémentant le nom
			while (file.exists()) {
				numRun++;
				file = new File($DOSSIER + numRun + fileNameOrUrlPlusFileName + "");
			}
		}
		else // En écrasant l'ancien de meme nom : PAMboup 27/12/2012
		file = new File($DOSSIER + fileNameOrUrlPlusFileName);
		this.fileName = $DOSSIER + file.getName();
		// Ouverture d'un flux d'écriture du fichier créé (écriture en écrasant, pr ecire en ajout: new FileWriter(file, true))
		try {
			printer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	// METHODS
	//
	/** Build folders, for exemple : if url = "folder1/forder2/ or url = "folder1/forder2/file.extension, this method build the
	 * folder1 and inside it build the folder2 (and don't build file.extension)
	 * @param url
	 * @author pamboup 20/06/2014 */
	private void buildFolders(String url) {
		String folders[] = url.split("/");
		$DOSSIER = "";
		int n;
		if (url.charAt(url.length() - 1) == '/') n = folders.length;// if l'url is finished by "/" (just folders and not file name)
		else n = folders.length - 1;// else the url contains folders name and file name
		for (int i = 0; i < n; i++) {
			$DOSSIER += folders[i] + "/";
			new File($DOSSIER).mkdir();
		}
	}
	// ECRITURE FICHIERS //
	/** Ecrit le String en paramètre */
	public void write(String str) {
		printer.print(str);
		printer.flush();
	}
	/** Ecrit le String en paramètre et saute une ligne */
	public void writeln(String str) {
		printer.println(str);
		printer.flush();
	}
	/** Constructs a FileWriter object given a file name and append the data written.
	 * @param urlAndfileName - String The filename.
	 * @param multiLine - ArrayList of String . author mboup 03/2014 */
	public static void writeMultiLineAndClose(String urlAndfileName, List<String> multiLine) {
		PrintWriter buffer = null;
		try {
			buffer = new PrintWriter(new BufferedWriter(new FileWriter(urlAndfileName, true)));
		} catch (IOException e) {
			System.err.println("C_OutputData.writeMultiLineAndClose() : Error openning " + urlAndfileName + "in writing");
			e.printStackTrace();
		}
		try {
			for (String line : multiLine)
				buffer.println(line);
		} catch (Exception e) {
			System.err.println("C_OutputData.writeMultiLineAndClose() : Erreur d'écriture sur le fichier " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (Exception e) {
				System.err.println("C_OutputData.writeMultiLineAndClose() : buffer closing error" + e.getMessage());
			}
		}
	}

	/** Ferme le fichier (à utiliser une fois que l'on a terminé d'écrire */
	public void closeFile() {
		printer.close();
	}
	public String getName() {
		return fileName;
	}
	public int getNumRun() {
		return numRun;
	}
}
