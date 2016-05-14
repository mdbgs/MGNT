package ModelPackage;

public class Programme {
	   private int idProgram ;
	   private String titre ;
	   private String niveau;
	   private String typeAccreditation;
	   private String referenceAccreditation;
	   private String nomAgenceD_accreditaion ;
	   private String mailAgence   ;
	   private String telAgence;
	   private String bpAgence;
	   private String dateAccreditation  ;
	   private String dateExpiration;
	   private String type ;
	   private String statut;
	   private String offertPar;
	   private String dateCreation;
	public int getIdProgram() {
		return idProgram;
	}
	public void setIdProgram(int idProgram) {
		this.idProgram = idProgram;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getTypeAccreditation() {
		return typeAccreditation;
	}
	public void setTypeAccreditation(String typeAccreditation) {
		this.typeAccreditation = typeAccreditation;
	}
	public String getReferenceAccreditation() {
		return referenceAccreditation;
	}
	public void setReferenceAccreditation(String referenceAccreditation) {
		this.referenceAccreditation = referenceAccreditation;
	}
	public String getNomAgenceD_accreditaion() {
		return nomAgenceD_accreditaion;
	}
	public void setNomAgenceD_accreditaion(String nomAgenceD_accreditaion) {
		this.nomAgenceD_accreditaion = nomAgenceD_accreditaion;
	}
	public String getMailAgence() {
		return mailAgence;
	}
	public void setMailAgence(String mailAgence) {
		this.mailAgence = mailAgence;
	}
	public String getTelAgence() {
		return telAgence;
	}
	public void setTelAgence(String telAgence) {
		this.telAgence = telAgence;
	}
	public String getBpAgence() {
		return bpAgence;
	}
	public void setBpAgence(String bpAgence) {
		this.bpAgence = bpAgence;
	}
	public String getDateAccreditation() {
		return dateAccreditation;
	}
	public void setDateAccreditation(String dateAccreditation) {
		this.dateAccreditation = dateAccreditation;
	}
	public String getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getOffertPar() {
		return offertPar;
	}
	public void setOffertPar(String offertPar) {
		this.offertPar = offertPar;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Programme(int idProgram, String titre, String niveau, String typeAccreditation,
			String referenceAccreditation, String nomAgenceD_accreditaion, String mailAgence, String telAgence,
			String bpAgence, String dateAccreditation, String dateExpiration, String type, String statut,
			String offertPar, String dateCreation) {
		super();
		this.idProgram = idProgram;
		this.titre = titre;
		this.niveau = niveau;
		this.typeAccreditation = typeAccreditation;
		this.referenceAccreditation = referenceAccreditation;
		this.nomAgenceD_accreditaion = nomAgenceD_accreditaion;
		this.mailAgence = mailAgence;
		this.telAgence = telAgence;
		this.bpAgence = bpAgence;
		this.dateAccreditation = dateAccreditation;
		this.dateExpiration = dateExpiration;
		this.type = type;
		this.statut = statut;
		this.offertPar = offertPar;
		this.dateCreation = dateCreation;
	}
	   

}
