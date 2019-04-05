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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class FilmCardController implements Initializable {

	private Film film;
	
	@FXML
	private StackPane filmCardStack;
	
	@FXML
    private ImageView filmCardImage;
	
    @FXML
    private Label lblTitel;
    
    @FXML
    private Tooltip tooltip;
    
    @FXML 
    private ImageView buttonImageView;
    
    private Datenbank datenbank;
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		datenbank = Datenbank.getDatenbank();
	}
    
	public void setTitle(String title) {
		lblTitel.setText( title);
	}
	
	public void setFilm(Film film) {
		this.film = film;
		setTitle(film.getTitle());
		filmCardImage.setImage(datenbank.getFilmCardImages().get(0));
		
		if(film.getGenreList().contains(datenbank.getMyList())) {
			tooltip.setText("Aus MyList entfernen");
			buttonImageView.setAccessibleHelp("Aus MyList entfernen");
			buttonImageView.setImage(new Image("/application/images/icons8-broken-heart-52.png"));
		}
		filmCardStack.setAccessibleHelp("Filmcard für Filmtitel: "+ film.getTitle());
		
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
