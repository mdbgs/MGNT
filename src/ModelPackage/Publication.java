package ModelPackage;


public class Publication {
	//FIELDS
private int idPublication;
private int idResponsable;
private String title;
private String datePublication;
private String nameJournal;
private String autors;
private String impactFacotrs;
private String type;
private String nameFile;
    //METHODS
public int getIdPublication() {
	return idPublication;
}
public void setIdPublication(int idPublication) {
	this.idPublication = idPublication;
}
public int getIdResponsable() {
	return idResponsable;
}
public void setIdResponsable(int idResponsable) {
	this.idResponsable = idResponsable;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDatePublication() {
	return datePublication;
}
public void setDatePublication(String datePublication) {
	this.datePublication = datePublication;
}
public String getNameJournal() {
	return nameJournal;
}
public void setNameJournal(String nameJournal) {
	this.nameJournal = nameJournal;
}
public String getAutors() {
	return autors;
}
public void setAutors(String autors) {
	this.autors = autors;
}
public String getImpactFacotrs() {
	return impactFacotrs;
}
public void setImpactFacotrs(String impactFacotrs) {
	this.impactFacotrs = impactFacotrs;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNameFile() {
	return nameFile;
}
public void setNameFile(String nameFile) {
	this.nameFile = nameFile;
}
public Publication(int idPublication, int idResponsable, String title, String datePublication, String nameJournal,
		String autors, String impactFacotrs, String type, String nameFile) {
	super();
	this.idPublication = idPublication;
	this.idResponsable = idResponsable;
	this.title = title;
	this.datePublication = datePublication;
	this.nameJournal = nameJournal;
	this.autors = autors;
	this.impactFacotrs = impactFacotrs;
	this.type = type;
	this.nameFile = nameFile;
}


}
