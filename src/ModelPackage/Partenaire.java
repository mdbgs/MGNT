package ModelPackage;

public class Partenaire {

	private int iDpartenaire;
	private String pseudo;
	private String nom;
	private String type;
	private String adresse;
	private String telephone;
	private String email;
	private String boitePostale;
	private String titreAccord;
	private String domaineDeCollaboration;
	private String dateSignature;
	private String expirationAccord;
	private String resultatAttendu;
	private String projetConjoint;
	public int getiDpartenaire() {
		return iDpartenaire;
	}
	public void setiDpartenaire(int iDpartenaire) {
		this.iDpartenaire = iDpartenaire;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}
	public String getTitreAccord() {
		return titreAccord;
	}
	public void setTitreAccord(String titreAccord) {
		this.titreAccord = titreAccord;
	}
	public String getDomaineDeCollaboration() {
		return domaineDeCollaboration;
	}
	public void setDomaineDeCollaboration(String domaineDeCollaboration) {
		this.domaineDeCollaboration = domaineDeCollaboration;
	}
	public String getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(String dateSignature) {
		this.dateSignature = dateSignature;
	}
	public String getExpirationAccord() {
		return expirationAccord;
	}
	public void setExpirationAccord(String expirationAccord) {
		this.expirationAccord = expirationAccord;
	}
	public String getResultatAttendu() {
		return resultatAttendu;
	}
	public void setResultatAttendu(String resultatAttendu) {
		this.resultatAttendu = resultatAttendu;
	}
	public String getProjetConjoint() {
		return projetConjoint;
	}
	public void setProjetConjoint(String projetConjoint) {
		this.projetConjoint = projetConjoint;
	}
	public Partenaire(int iDpartenaire, String pseudo, String nom, String type, String adresse, String telephone,
			String email, String boitePostale, String titreAccord, String domaineDeCollaboration, String dateSignature,
			String expirationAccord, String resultatAttendu, String projetConjoint) {
		super();
		this.iDpartenaire = iDpartenaire;
		this.pseudo = pseudo;
		this.nom = nom;
		this.type = type;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.boitePostale = boitePostale;
		this.titreAccord = titreAccord;
		this.domaineDeCollaboration = domaineDeCollaboration;
		this.dateSignature = dateSignature;
		this.expirationAccord = expirationAccord;
		this.resultatAttendu = resultatAttendu;
		this.projetConjoint = projetConjoint;
	}

}
