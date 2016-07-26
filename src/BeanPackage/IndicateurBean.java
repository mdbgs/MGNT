package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Indicateur;

public class IndicateurBean {
	//
	// FIELD
	//
	private List<Indicateur> indicateurList = new ArrayList<Indicateur>();
 	//
	// GETTER & SETTER
	//
	public List<Indicateur> getIndicateurList() {
		return indicateurList;
	}
	public void setIndicateurList(List<Indicateur> indicateurList) {
		this.indicateurList = indicateurList;
	}
	public void addIndicateurInList(Indicateur indicateur){
		this.indicateurList.add(indicateur);
	}
}
