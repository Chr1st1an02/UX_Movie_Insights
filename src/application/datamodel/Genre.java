package application.datamodel;

import application.menu.filter.Filterbar;

public class Genre implements Filterbar{
	private String name;
	
	public Genre(String name){
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	
}
