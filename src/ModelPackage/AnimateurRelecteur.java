package ModelPackage;

public class AnimateurRelecteur {
	   private int iDAnimateur ;
	   private int iDpartenaire;
	   private String nom ;
	   private String prenom;
	   private String mail;
	   private String telephone;
	   private String boitePostale ;
	   private String affliationInstitutionnel;
	   private String type ;
	public int getiDAnimateur() {
		return iDAnimateur;
	}
	public void setiDAnimateur(int iDAnimateur) {
		this.iDAnimateur = iDAnimateur;
	}
	public int getiDpartenaire() {
		return iDpartenaire;
	}
	public void setiDpartenaire(int iDpartenaire) {
		this.iDpartenaire = iDpartenaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}
	public String getAffliationInstitutionnel() {
		return affliationInstitutionnel;
	}
	public void setAffliationInstitutionnel(String affliationInstitutionnel) {
		this.affliationInstitutionnel = affliationInstitutionnel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AnimateurRelecteur(int iDAnimateur, int iDpartenaire, String nom, String prenom, String mail,
			String telephone, String boitePostale, String affliationInstitutionnel, String type) {
		super();
		this.iDAnimateur = iDAnimateur;
		this.iDpartenaire = iDpartenaire;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.boitePostale = boitePostale;
		this.affliationInstitutionnel = affliationInstitutionnel;
		this.type = type;
	}
	public AnimateurRelecteur() {
		super();
		// TODO Auto-generated constructor stub
	}            

}
