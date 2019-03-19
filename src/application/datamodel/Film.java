package application.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.PlatformFactory;

import javafx.scene.shape.Path;

public class Film {
	private String title;
	private String description;
	private int duration;
	private int fsk;
	
	private Genre genre;
	private List<Plattform> plattformList;
	
	public Film(String title, String description, int duration, int fsk, Genre genre, Plattform ...plattforms) {
		this.setTitle(title);
		this.setDescription(description);
		this.setDuration(duration);
		this.setFsk(fsk);
		this.setGenre(genre);
		
		for(Plattform plattform :plattforms) {
			addPlattform(plattform);
		}
		
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFsk() {
		return fsk;
	}

	public void setFsk(int fsk) {
		this.fsk = fsk;
	}



	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	



	public List<Plattform> getPlattformList() {
		return plattformList;
	}



	public void setPlattformList(List<Plattform> plattformList) {
		this.plattformList = plattformList;
	}
	
	public void addPlattform(Plattform p) {
		if(plattformList==null) {
			plattformList = new ArrayList<Plattform>();
		}
		if(!plattformList.contains(p)) {
			plattformList.add(p);
		}
	}
	
	
}
