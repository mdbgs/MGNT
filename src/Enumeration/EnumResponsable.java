package Enumeration;

//All categorie of responsable in CEA-MITIC institute
public enum EnumResponsable {
	Resp_Labo("Responsable Laboratoire"),
	ChercPrincipal("Chercheur Principal"),
	DirUfr("Directeur UFR"),
	Coordonnateur("Coordonnateur"),
	DirED("Directeur ED"),
	RespMaster("Responsable de Master"),
	ChefsSection("Chef de Section"),
	DA("DA"),
	CordAdjt("Coordonnateur Adjoint"),
	CSEP("Chargé du SEP"),
	Comptable("Comptable"),
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
