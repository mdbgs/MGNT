package Enumeration;
//All level in CEA-MITIC institute
public enum EnumNiveau {
	Master_1("Master 1"),
	Master_2("Master 2"),
	PremierAnnee("1er Ann&eacute;e"),
	DeuxiemeAnne("2ième Ann&eacute;e"),
	TroisimeAnne("3ième Ann&eacute;e"),
	maitrise("Maitrise"),
	doctorat("Doctorat");
	private String name="";
	EnumNiveau(String name){
		this.name=name;
	}
	public String toString(){
		return this.name;
	}
}
