package ModelPackage;

public class Compte {
	private String pseudo;
	private String password;
	private String dateinscription;
	private String photo;
	private String Statut;
	private String nom;
	private String prenom;
	public Compte(String pseudo, String password, String dateinscription, String photo, String statut, String nom,
			String prenom) {
		this.pseudo = pseudo;
		this.password = password;
		this.dateinscription = dateinscription;
		this.photo = photo;
		Statut = statut;
		this.nom = nom;
		this.prenom = prenom;
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
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateinscription() {
		return dateinscription;
	}
	public void setDateinscription(String dateinscription) {
		this.dateinscription = dateinscription;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	public Compte(String pseudo, String password, String dateinscription, String photo, String statut) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.dateinscription = dateinscription;
		this.photo = photo;
		Statut = statut;
	}

}
