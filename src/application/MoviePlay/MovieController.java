package application.MoviePlay;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.datamodel.Film;
import application.datamodel.Genre;
import application.datamodel.Plattform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;






public class MovieController implements Initializable {
	
	@FXML
	private MediaView mediaView;
	
	@FXML
	private JFXButton Playbutton;
	
	@FXML
	private VBox lables;

	
	@FXML
	private BorderPane borderPane;
	
	private MediaPlayer mediaPlayer;
	
	private Film film;
	
	@FXML
	private Label la_title;
	@FXML
	private Label la_description;
	@FXML
	private Label la_duration;
	@FXML
	private Label la_fsk;
	@FXML
	private Label la_genre;
	@FXML
	private Label la_plattform;
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Media media = new Media(getClass().getResource("/application/images/Movie.mp4").toExternalForm());
		
		mediaPlayer = new MediaPlayer(media);
		
		mediaView.setMediaPlayer(mediaPlayer);
		
		
	}
	
	@FXML
	public void onClick(ActionEvent event) {
		
		
		
		if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
			mediaPlayer.pause();
			Playbutton.setText("►");
			borderPane.setBottom(null);
			}
		else {
			mediaPlayer.play();
			Playbutton.setText("| |");
			borderPane.setBottom(lables);
		}
		
	}
	
	@FXML
	public void onBackButton(ActionEvent event) throws IOException {
		
		
		StackPane root = FXMLLoader.load(getClass().getResource("/application/client/MainGUI.fxml"));
		
		((Node)event.getSource()).getScene().setRoot(root);
		
		
		
	}
	
	public void setMovie(Film film) {
		this.film= film;
	}
	
	public void setLables() {
		
		la_title.setText(film.getTitle());
		la_description.setText(film.getDescription());
		la_duration.setText("Dauer: "+film.getDuration()+ "Minuten");
		la_fsk.setText("Altersbeschränkung: " + film.getFsk());
		
		List<Genre> genres = film.getGenreList();
		
		String genreLabel = "Genres: ";
		
		for(int i = 0; i < genres.size()-1; i++) {
			
			genreLabel = genreLabel + genres.get(i).getName() +", ";
			
		}
		
		genreLabel = genreLabel + genres.get(genres.size()-1).getName();
		
		la_genre.setText(genreLabel);
		
		
		List<Plattform> plattforms = film.getPlattformList();
		
		String plattformLabel = "Plattforms: ";
		
		for(int i = 0; i < plattforms.size()-1; i++) {
			
			plattformLabel = plattformLabel + plattforms.get(i).getName() +", ";
			
		}
		
		plattformLabel = plattformLabel + plattforms.get(plattforms.size()-1).getName();
		
		la_plattform.setText(plattformLabel);
		
	}

}
