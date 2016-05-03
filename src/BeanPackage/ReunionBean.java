package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Reunion;
import ModelPackage.Stage;

public class ReunionBean {
	private List<Reunion> reunionList = new ArrayList<Reunion>();

	public List<Reunion> getReunionList() {
		return reunionList;
	}

	public void setReunionList(List<Reunion> reunionList) {
		this.reunionList = reunionList;
	}
	public void addReunionInList(Reunion reunion){
		this.reunionList.add(reunion);
	}

}
