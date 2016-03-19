package ModelPackage;

import java.sql.Timestamp;

public class User {
	//
	// FIELDS
	//
	private String pseudo;
	private String password;
	private Timestamp inscriptionDate;
	private Integer id;
	//
	// GETTERS & SETTERS
	//
	;public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public Timestamp getInscriptionDate() {
		return inscriptionDate;
	}
	public void setInscriptionDate(Timestamp inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
	public String getPassword() {
		return password;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	//
	// CONSTRUCTOR
	//
	public User(String pseudo, String password,Integer id) {
		this.pseudo = pseudo;
		this.password = password;
		this.id = id;
	}
}
