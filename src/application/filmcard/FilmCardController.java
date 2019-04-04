package application.filmcard;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.MoviePlay.MovieController;
import application.datamodel.Datenbank;
import application.datamodel.Film;
import application.datamodel.Genre;
import application.filter.Filter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

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
	 
	 @FXML
	 public void onMovie(MouseEvent event) throws IOException {
		 
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MoviePlay/MoviePlay.fxml"));
		 StackPane root = loader.load();
		 MovieController movieController = loader.getController();
		 movieController.setMovie(film);
		 movieController.setLables();
		 ((Node)event.getSource()).getScene().setRoot(root);
			 
	 }
    
    
}
