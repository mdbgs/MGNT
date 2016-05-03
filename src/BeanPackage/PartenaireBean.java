package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Partenaire;

public class PartenaireBean {
	private List<Partenaire> partnerList = new ArrayList<Partenaire>();

	public List<Partenaire> getPatnerList() {
		return partnerList;
	}

	public void setPatnerList(List<Partenaire> patnerList) {
		this.partnerList = patnerList;
	}
	public void addPartnerInList(Partenaire partenaire){
		this.partnerList.add(partenaire);
	}

}
