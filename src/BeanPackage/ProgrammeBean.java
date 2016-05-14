package BeanPackage;

import java.util.ArrayList;
import java.util.List;
import ModelPackage.Programme;

public class ProgrammeBean {
	private List<Programme> programList = new ArrayList<Programme>();

	public List<Programme> getProgramList() {
		return programList;
	}

	public void setProgramList(List<Programme> programList) {
		this.programList = programList;
	}

	public void addProgramInList(Programme programme) {
		this.programList.add(programme);
	}
}
