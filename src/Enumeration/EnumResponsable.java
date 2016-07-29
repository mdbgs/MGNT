package Enumeration;

//All categorie of responsable in CEA-MITIC institute
public enum EnumResponsable {
	CSEP("Chargé du Suivi des étudiants et Partenaire"),
	ChefsSection("Chef de Section"),
	ChercPrincipal("Chercheur Principal"),
	Comptable("Comptable"),
	Coordonnateur("Coordonnateur"),
	CordAdjt("Coordonnateur Adjoint"),
	DA("DA"),
	DirED("Directeur ED"),
	DirUfr("Directeur UFR"),
	Resp_Labo("Responsable Laboratoire"),
	Resp_SV("Responsable Suivi-évaluation"),
	RespMaster("Responsable de Master"),
	RPM("RPM"),
	RSE("RSE");
	
	private String name;
	EnumResponsable(String name){
		this.name = name;
	}
	 public String toString(){
		 return this.name;
	 }
}
