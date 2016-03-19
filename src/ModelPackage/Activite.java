package ModelPackage;

public class Activite {
	//
	// FIELD
	//
	private int IDactivite;
	private String libelle;
	private String periode;
	private String echeancePrevu;
	private String echeanceRealise;
	private String statutActivite;
	private String natureIndicateur;
	private String libelleIndicateur;
	private String referenceTableauDeSaisie;
	private String pieceJustificatif;
	private String composant;
	private String objectif;
	private String resultatAttendu;
	//
	// GETTERS & SETTERS
	//
	public int getIDactivite() {
		return IDactivite;
	}
	public void setIDactivite(int iDactivite) {
		IDactivite = iDactivite;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getEcheancePrevu() {
		return echeancePrevu;
	}
	public void setEcheancePrevu(String echeancePrevu) {
		this.echeancePrevu = echeancePrevu;
	}
	public String getEcheanceRealise() {
		return echeanceRealise;
	}
	public void setEcheanceRealise(String echeanceRealise) {
		this.echeanceRealise = echeanceRealise;
	}
	public String getStatutActivite() {
		return statutActivite;
	}
	public void setStatutActivite(String statutActivite) {
		this.statutActivite = statutActivite;
	}
	public String getNatureIndicateur() {
		return natureIndicateur;
	}
	public void setNatureIndicateur(String natureIndicateur) {
		this.natureIndicateur = natureIndicateur;
	}
	public String getLibelleIndicateur() {
		return libelleIndicateur;
	}
	public void setLibelleIndicateur(String libelleIndicateur) {
		this.libelleIndicateur = libelleIndicateur;
	}
	public String getReferenceTableauDeSaisie() {
		return referenceTableauDeSaisie;
	}
	public void setReferenceTableauDeSaisie(String referenceTableauDeSaisie) {
		this.referenceTableauDeSaisie = referenceTableauDeSaisie;
	}
	public String getPieceJustificatif() {
		return pieceJustificatif;
	}
	public void setPieceJustificatif(String pieceJustificatif) {
		this.pieceJustificatif = pieceJustificatif;
	}
	public String getComposant() {
		return composant;
	}
	public void setComposant(String composant) {
		this.composant = composant;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getResultatAttendu() {
		return resultatAttendu;
	}
	public void setResultatAttendu(String resultatAttendu) {
		this.resultatAttendu = resultatAttendu;
	}
	//CONSTRUCTOR
	public Activite(int iDactivite, String libelle, String periode, String echeancePrevu, String echeanceRealise,
			String statutActivite, String natureIndicateur, String libelleIndicateur, String referenceTableauDeSaisie,
			String pieceJustificatif, String composant, String objectif, String resultatAttendu) {
		super();
		IDactivite = iDactivite;
		this.libelle = libelle;
		this.periode = periode;
		this.echeancePrevu = echeancePrevu;
		this.echeanceRealise = echeanceRealise;
		this.statutActivite = statutActivite;
		this.natureIndicateur = natureIndicateur;
		this.libelleIndicateur = libelleIndicateur;
		this.referenceTableauDeSaisie = referenceTableauDeSaisie;
		this.pieceJustificatif = pieceJustificatif;
		this.composant = composant;
		this.objectif = objectif;
		this.resultatAttendu = resultatAttendu;
	}
	public Activite() {
	}
}
