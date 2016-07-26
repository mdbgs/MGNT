package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Activite;

public class ActiviteBean {
	protected List<Activite> activeList = new ArrayList<>();

	public List<Activite> getActiveList() {
		return activeList;
	}

	public void addActiviteinList(Activite activite) {
		this.activeList.add(activite);
	}

	public Activite oneActivite() {
		if (!activeList.isEmpty()) {
			return activeList.get(0);
		}
		return null;
	}
}
