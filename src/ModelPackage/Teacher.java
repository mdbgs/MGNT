package ModelPackage;

public class Teacher {
	private int idTeacher;
	private String pseudo;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String level;
	private String nationality;
	private String adress;
	private String mail;
	private String bp;
	private String gender;
	private String anneeDenseignement;
	private String affiliation;
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliaton) {
		this.affiliation = affiliaton;
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String birthday) {
		this.phoneNumber = birthday;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAnneeDenseignement() {
		return anneeDenseignement;
	}
	public void setAnneeDenseignement(String anneeDenseignement) {
		this.anneeDenseignement = anneeDenseignement;
	}
	
	public Teacher(int idTeacher, String pseudo, String lastName, String firstName, String phoneNumber, String level,
			String nationality, String adress, String mail, String bp, String gender, String anneeDenseignement, String affiliation) {
		super();
		this.idTeacher = idTeacher;
		this.pseudo = pseudo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.level = level;
		this.nationality = nationality;
		this.adress = adress;
		this.mail = mail;
		this.bp = bp;
		this.gender = gender;
		this.affiliation = affiliation;
		this.anneeDenseignement = anneeDenseignement;
	}
	public Teacher() {
		super();
	}
	
}
