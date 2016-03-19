package ModelPackage;

public class Indicateur {
	//
	// FIELDS
	//
	private int IdIndicateur;
	private int numero;
	private String libelle;
	private String objectif;
	private String sigle;
	//
	// GETTERS & SETTERS
	//
	public int getIdIndicateur() {
		return IdIndicateur;
	}
	public void setIdIndicateur(int idIndicateur) {
		IdIndicateur = idIndicateur;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	//
	// CONSTRUCTOR
	//
	public Indicateur(int idIndicateur, int numero, String libelle, String objectif, String sigle) {
		super();
		IdIndicateur = idIndicateur;
		this.numero = numero;
		this.libelle = libelle;
		this.objectif = objectif;
		this.sigle = sigle;
	}
}
