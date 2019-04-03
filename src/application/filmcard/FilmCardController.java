package application.filmcard;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.datamodel.Datenbank;
import application.datamodel.Film;
import application.datamodel.Genre;
import application.filter.Filter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FilmCardController implements Initializable {

	private Film film;
	
	@FXML
    private ImageView filmCardImage;
	
    @FXML
    private Label lblTitel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblTitel.setText("Hier ist ein Titel");
	}
    
	public void setTitle(String title) {
		lblTitel.setText( title);
	}
	
	public void setFilm(Film film) {
		this.film = film;
		setTitle(film.getTitle());
		filmCardImage.setImage(Datenbank.getDatenbank().getFilmCardImages().get(0));
	}
    
	 @FXML
	 void addToList(ActionEvent event) {
		 Datenbank datenbank = Datenbank.getDatenbank();
		 Genre myList = datenbank.getMyList();
		 List<Genre> genreList = film.getGenreList();
		 if(genreList.contains(myList)) {
			 genreList.remove(myList);
		 }else {
			 genreList.add(myList);
		 }
		 Filter.getFilter().upgradeList();
		 
		 
	 }
    
    
}
