package ModelPackage;

public class User {
	//
	// FIELDS
	//
	private String pseudo;
	private String password;
	//
	// GETTERS & SETTERS
	//
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
	public User(String pseudo, String password) {
		this.pseudo = pseudo;
		this.password = password;
	}
}
