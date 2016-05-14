package ModelPackage;

public class Formation {
	   private int idFormation;          
	   private String  title;  
	   private String  institution ;  
	   private String  position  ;         
	   private String contenu ;
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Formation(int idFormation, String title, String institution, String position, String contenu) {
		super();
		this.idFormation = idFormation;
		this.title = title;
		this.institution = institution;
		this.position = position;
		this.contenu = contenu;
	}
	   

}
