package application.datamodel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Datenbank {
	private static Datenbank datenbank;
	
	private List<Film> filme;
	private List<Genre> genres;
	private List<Plattform> plattforms;
	private List<Image> bannerImages;
	private List<Image> filmCardImages;
	
	private Genre myList;
	
	private Datenbank() {
		filme = new ArrayList<Film>();
		genres = new ArrayList<Genre>();
		plattforms = new ArrayList<Plattform>();
		bannerImages = new ArrayList<Image>();
		filmCardImages = new ArrayList<Image>();
		
		myList = new Genre("My List");
		genres.add(myList);
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

	public List<Image> getBannerImages() {
		return bannerImages;
	}
	
	public List<Image> getFilmCardImages() {
		return filmCardImages;
	}
	
	public void addBannerImages(Image bannerImage) {
		this.bannerImages.add(bannerImage);
	}
	
	public void addFilmCardImages(Image filmCardImage) {
		this.filmCardImages.add(filmCardImage);
	}
	
	public Genre getMyLst() {
		return myList;
	}
	
	

	
}
