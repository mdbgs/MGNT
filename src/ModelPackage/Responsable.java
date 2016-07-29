package ModelPackage;

public class Responsable {
	//
	//FIELDS
	//
	private int idResponsable;
	private String pseudo;
	private String lastName;
	private String firstName;
	private String adress;
	private String mail;
	private String phone;
	private String gender;
	private String post;
	//
	//GETTERS & SETTERS
	
		public int getIdResponsable() {
			return idResponsable;
		}


		public String getPseudo() {
			return pseudo;
		}


		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}


		public void setIdResponsable(int idResponsable) {
			this.idResponsable = idResponsable;
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


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getPost() {
			return post;
		}


		public void setPost(String post) {
			this.post = post;
		}
		public Responsable(int idResponsable, String pseudo, String lastName, String firstName, String adress, String mail,
				String phone, String gender, String post) {
			super();
			this.idResponsable = idResponsable;
			this.pseudo=pseudo;
			this.lastName = lastName;
			this.firstName = firstName;
			this.adress = adress;
			this.mail = mail;
			this.phone = phone;
			this.gender = gender;
			this.post = post;
		}
	

}
