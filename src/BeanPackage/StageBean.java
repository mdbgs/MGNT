package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Publication;
import ModelPackage.Stage;

public class StageBean {
	private List<Stage> stageList = new ArrayList<Stage>();

	public List<Stage> getStageList() {
		return stageList;
	}

	public void setStageList(List<Stage> stageList) {
		this.stageList = stageList;
	}
	public void addStageInList(Stage stage){
		this.stageList.add(stage);
	}
}
