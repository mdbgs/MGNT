package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Indicateur;
import ModelPackage.Publication;


public class PublicationBean {
	
	private List<Publication> publicationList = new ArrayList<Publication>();

	public List<Publication> getPublicationList() {
		return publicationList;
	}

	public void setPublicationList(List<Publication> publicationList) {
		this.publicationList = publicationList;
	}
	
	public void addPublicationInList(Publication publication){
		this.publicationList.add(publication);
	}

}
