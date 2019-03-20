package application.datamodel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Datenbank {
	private static Datenbank datenbank;
	
	private List<Film> filme;
	private List<Genre> genres;
	private List<Plattform> plattforms;
	
	private Datenbank() {
		filme = new ArrayList<Film>();
		genres = new ArrayList<Genre>();
		plattforms = new ArrayList<Plattform>();
	}
	
	public static Datenbank getDatenbank() {
		if(datenbank==null) {
			datenbank = new Datenbank();
		}
		return datenbank;
		
	}
	
	public void addFilm(Film film) {
		filme.add(film);
	}
	
	public void addGenre(Genre genre) {
		genres.add(genre);
	}
	public void addPlattform(Plattform plattform) {
		plattforms.add(plattform);
	}
	
	public Film getFilm(int index) {
		return filme.get(index);
	}
	
	public List<Film> getFilme(){
		return filme;
	}
	
	
	public Genre getGenre(int index) {
		return genres.get(index);
	}
	
	public List<Genre> getGenreList(){
		return genres;
	}
	
	public Plattform getPlattform(int index) {
		return plattforms.get(index);
	}
	
	public List<Plattform> getPlattformList() {
		return plattforms;
	}
	
	

	
}
