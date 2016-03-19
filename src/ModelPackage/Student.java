package ModelPackage;

public class Student {
	//
	//FIELDS
	//
	private int idStudent;
	private int idCompte;
	private String lastName;
	private String firstName;
	private String birthday;
	private String countryOfBirth;
	private String level;
	private String nationality;
	private String adress;
	private String mail;
	private String phone;
	private String bp;
	private String gender;
	private String studentNumber;
	private String lastNamePAC;
	private String firstNamePAC;
	private String phonePAC;
	private String adressPAC;
	private String program;
	private String semester;
	//
	//GETTERS & SETTERS
	public int getIdStudent() {
		return idStudent;
	}public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public int getIdCompte() {
		return idCompte;
	}public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLastNamePAC() {
		return lastNamePAC;
	}
	public void setLastNamePAC(String lastNamePAC) {
		this.lastNamePAC = lastNamePAC;
	}
	public String getFirstNamePAC() {
		return firstNamePAC;
	}
	public void setFirstNamePAC(String firstNamePAC) {
		this.firstNamePAC = firstNamePAC;
	}
	public String getPhonePAC() {
		return phonePAC;
	}
	public void setPhonePAC(String phonePAC) {
		this.phonePAC = phonePAC;
	}
	public String getAdressPAC() {
		return adressPAC;
	}
	public void setAdressPAC(String adressPAC) {
		this.adressPAC = adressPAC;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public Student(int idStudent, int idCompte, String lastName, String firstName, String birthday,
			String countryOfBirth, String level, String nationality, String adress, String mail, String phone,
			String bp, String gender, String studentNumber, String lastNamePAC, String firstNamePAC, String phonePAC,
			String adressPAC, String program, String semester) {
		super();
		this.idStudent = idStudent;
		this.idCompte = idCompte;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthday = birthday;
		this.countryOfBirth = countryOfBirth;
		this.level = level;
		this.nationality = nationality;
		this.adress = adress;
		this.mail = mail;
		this.phone = phone;
		this.bp = bp;
		this.gender = gender;
		this.studentNumber = studentNumber;
		this.lastNamePAC = lastNamePAC;
		this.firstNamePAC = firstNamePAC;
		this.phonePAC = phonePAC;
		this.adressPAC = adressPAC;
		this.program = program;
		this.semester = semester;
	}
	
}
