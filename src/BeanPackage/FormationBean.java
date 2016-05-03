package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Formation;
import ModelPackage.Reunion;

public class FormationBean {
	private List<Formation> formationList = new ArrayList<Formation>();

	public List<Formation> getFormationList() {
		return formationList;
	}

	public void setFormationList(List<Formation> formationList) {
		this.formationList = formationList;
	}
	public void addFormationInList(Formation formation){
		this.formationList.add(formation);
	}


}
