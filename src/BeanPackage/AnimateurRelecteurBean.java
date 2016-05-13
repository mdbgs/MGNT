package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.AnimateurRelecteur;

public class AnimateurRelecteurBean {
	
	private List<AnimateurRelecteur> animateurRelecteurList = new ArrayList<AnimateurRelecteur>();

	public List<AnimateurRelecteur> getAnimateurRelecteurList() {
		return animateurRelecteurList;
	}

	public void setAnimateurRelecteurList(List<AnimateurRelecteur> animateurRelecteurList) {
		this.animateurRelecteurList = animateurRelecteurList;
	}

	public AnimateurRelecteurBean(List<AnimateurRelecteur> animateurRelecteurList) {
		super();
		this.animateurRelecteurList = animateurRelecteurList;
	}
   public void addAnimateurRelecteurInlist(AnimateurRelecteur animateur){
	   this.animateurRelecteurList.add(animateur);
    }

public AnimateurRelecteurBean() {
	super();
	// TODO Auto-generated constructor stub
}
   
}

