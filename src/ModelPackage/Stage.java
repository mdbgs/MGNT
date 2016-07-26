package ModelPackage;


public class Stage {
	private int idStage;
	private int idTeacher;
	private int idStudent;
	private int idPartenaire;
	private String departmentProgram;
	private String startDate;
    private String endDate;
    private String certifcate;
    private String nameInstitution;
    private String  statutInstitution;
    private String firstNameDirector;
    private String LastNameDrector;
    private String mailDrector;
    private String phoneDirector;
	public int getIdStage() {
		return idStage;
	}
	public void setIdStage(int idStage) {
		this.idStage = idStage;
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public int getIdPartenaire() {
		return idPartenaire;
	}
	public void setIdPartenaire(int idPartenaire) {
		this.idPartenaire = idPartenaire;
	}
	public String getDepartmentProgram() {
		return departmentProgram;
	}
	public void setDepartmentProgram(String departmentProgram) {
		this.departmentProgram = departmentProgram;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCertifcate() {
		return certifcate;
	}
	public void setCertifcate(String certifcate) {
		this.certifcate = certifcate;
	}
	public String getNameInstitution() {
		return nameInstitution;
	}
	public void setNameInstitution(String nameInstitution) {
		this.nameInstitution = nameInstitution;
	}
	public String getStatutInstitution() {
		return statutInstitution;
	}
	public void setStatutInstitution(String statutInstitution) {
		this.statutInstitution = statutInstitution;
	}
	public String getFirstNameDirector() {
		return firstNameDirector;
	}
	public void setFirstNameDirector(String firstNameDirector) {
		this.firstNameDirector = firstNameDirector;
	}
	public String getLastNameDrector() {
		return LastNameDrector;
	}
	public void setLastNameDrector(String lastNameDrector) {
		LastNameDrector = lastNameDrector;
	}
	public String getMailDrector() {
		return mailDrector;
	}
	public void setMailDrector(String mailDrector) {
		this.mailDrector = mailDrector;
	}
	public String getPhoneDirector() {
		return phoneDirector;
	}
	public void setPhoneDirector(String phoneDirector) {
		this.phoneDirector = phoneDirector;
	}
	public Stage(int idStage, int idTeacher, int idStudent, int idPartenaire, String departmentProgram, String startDate,
			String endDate, String certifcate, String nameInstitution, String statutInstitution, String firstNameDirector,
			String lastNameDrector, String mailDrector, String phoneDirector) {
		super();
		this.idStage = idStage;
		this.idTeacher = idTeacher;
		this.idStudent = idStudent;
		this.idPartenaire = idPartenaire;
		this.departmentProgram = departmentProgram;
		this.startDate = startDate;
		this.endDate = endDate;
		this.certifcate = certifcate;
		this.nameInstitution = nameInstitution;
		this.statutInstitution = statutInstitution;
		this.firstNameDirector = firstNameDirector;
		this.LastNameDrector = lastNameDrector;
		this.mailDrector = mailDrector;
		this.phoneDirector = phoneDirector;
	}
    
}
