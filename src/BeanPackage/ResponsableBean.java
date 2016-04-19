package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Responsable;

public class ResponsableBean {
	
		List<Responsable> responsableList = new ArrayList<>();

		public List<Responsable> getResponsableList() {
			return responsableList;
		}

		public void setResponsableList(List<Responsable> ResponsableList) {
			this.responsableList = ResponsableList;
		}

		public ResponsableBean() {
		}
		public void AddResponsable(Responsable responsable){
			this.responsableList.add(responsable);
		}
	


}
