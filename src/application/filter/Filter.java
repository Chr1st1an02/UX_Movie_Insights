package application.filter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner.ListEditor;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;


import application.datamodel.Datenbank;
import application.datamodel.Film;
import application.datamodel.Genre;
import application.datamodel.Plattform;
import application.menu.filter.Filterbar;
import javafx.beans.InvalidationListener;

import java.util.Observable;

public class Filter extends Observable{
	private static Filter filter;
	private List<Genre> genreList;
	private List<Plattform> plattformList; 
	private List<Film> aktuelleListe; 
	
	private Filter() {
		genreList =  new ArrayList<Genre>();
		plattformList = new ArrayList<Plattform>();
		aktuelleListe = new ArrayList<Film>();
		filterAll();
		upgradeList();
		
	}
	
	public static Filter getFilter() {
		if(filter== null) {
			filter = new Filter();
		}
		return filter;
	}
	
	public List<Film> getListe(Filterbar filter){
		List<Film> gefilterteListe = new ArrayList<Film>();
		for(Film film : aktuelleListe) {
			if(film.contains(filter)){
				gefilterteListe.add(film);
			}
		}
		return gefilterteListe;
	}
	
	public List<Genre> getGenres() {
		return genreList;
		
	}
	
	public void addFilter(Filterbar filter) { 
		if(filter instanceof Genre) {
			if(!genreList.contains(filter)) {
				genreList.add((Genre)filter);			
			}
		}
			
		if(filter instanceof Plattform) {
			if(!plattformList.contains(filter)) {
				plattformList.add((Plattform)filter);			
			}
		}
	}
	public boolean removeFilter(Filterbar filter) {
		return (genreList.remove(filter) ||
				plattformList.remove(filter));
	}
	
	public void upgradeList() {
		List<Film> urListe = Datenbank.getDatenbank().getFilme();
		List<Film> zwischenListe = new ArrayList<Film>();
		aktuelleListe.clear();
		for(Film film : urListe) {
			for(Genre genre : genreList) {
				System.out.print(film);
				if(film.contains(genre)) {
					zwischenListe.add(film);
					break; 
				}
			}
		}
		for(Film film :zwischenListe) {
			for(Plattform plattform : plattformList) {
				System.out.print(film);
				if(film.contains(plattform)) {
					aktuelleListe.add(film);
					break; 
				}
			}
		}
		setChanged();
		notifyObservers();
	}
	
	private void filterAll() {
		Datenbank datenbank = Datenbank.getDatenbank();
		genreList.addAll(datenbank.getGenreList());
		plattformList.addAll(datenbank.getPlattformList());
	}
	
	public boolean isActiv(Filterbar filter) {
		if(genreList.contains(filter))
			return true;
		if(plattformList.contains(filter))
			return true;
		return false;
	}

}
