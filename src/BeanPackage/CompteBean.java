package BeanPackage;

import java.util.ArrayList;
import java.util.List;
import ModelPackage.Compte;
public class CompteBean {
	List<Compte> compteList = new ArrayList<>();
	public List<Compte> getCompteList() {
		return compteList;
	}
	public void setCompteList(List<Compte> compteList) {
		this.compteList = compteList;
	}
	public void addInListCompte(Compte compte){
		this.compteList.add(compte);
	}



}
