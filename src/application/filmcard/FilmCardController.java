package application.filmcard;

import java.net.URL;
import java.util.ResourceBundle;

import application.datamodel.Film;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FilmCardController implements Initializable {

	private Film film;
	
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
	}
    
    
    
}
