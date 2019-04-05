package application.MoviePlay;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.Timer;

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
	private VBox labels;

	
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
	@FXML
	private JFXButton playbutton;
	@FXML
	private JFXButton backbutton;
	
	Timer buttonHideTimer; 
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Media media = new Media(getClass().getResource("/application/images/Movie.mp4").toExternalForm());
		
		mediaPlayer = new MediaPlayer(media);
		
		mediaView.setMediaPlayer(mediaPlayer);
		
		
		
		//Timer für Playbutton ausblenden
		buttonHideTimer = new Timer(3000, new ActionListener() {               
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				
	                hideButtons();
				
			}     
		});        
		
		
		
		
	}
	
	@FXML
	public void onClick(ActionEvent event) {
		
		
		
		if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
			buttonHideTimer.stop();
			mediaPlayer.pause();
			playbutton.setText("►");
			playbutton.setAccessibleText("Starte Film");
			showButtons();
			labels.setVisible(true);
			}
		else {
			mediaPlayer.play();
			playbutton.setText("| |");
			playbutton.setAccessibleText("Pausiere Film");
			labels.setVisible(false);
			buttonHideTimer.start();
		}
		
	}
	
	@FXML
	public void onBackButton(ActionEvent event) throws IOException {
		
		mediaPlayer.stop();
		StackPane root = FXMLLoader.load(getClass().getResource("/application/client/MainGUI.fxml"));
		
		((Node)event.getSource()).getScene().setRoot(root);
		
		
		
	}
	
	public void setMovie(Film film) {
		this.film= film;
	}
	
	public void setLables() {
		
		la_title.setText(film.getTitle());
		la_title.setAccessibleText(film.getTitle());
		la_description.setText(film.getDescription());
		la_description.setAccessibleText(film.getDescription());
		la_duration.setText("Dauer: "+film.getDuration()+ " Minuten");
		la_duration.setAccessibleText("Dauer: "+film.getDuration()+ " Minuten");
		la_fsk.setText("Altersbeschränkung: " + film.getFsk()+ " Jahre");
		la_fsk.setAccessibleText("Altersbeschränkung: " + film.getFsk()+ " Jahre");
		
		List<Genre> genres = film.getGenreList();
		
		String genreLabel = "Genres: ";
		
		for(int i = 0; i < genres.size()-1; i++) {
			
			genreLabel = genreLabel + genres.get(i).getName() +", ";
			
		}
		
		genreLabel = genreLabel + genres.get(genres.size()-1).getName();
		
		la_genre.setText(genreLabel);
		la_genre.setAccessibleText(genreLabel);
		
		
		List<Plattform> plattforms = film.getPlattformList();
		
		String plattformLabel = "Plattforms: ";
		
		for(int i = 0; i < plattforms.size()-1; i++) {
			
			plattformLabel = plattformLabel + plattforms.get(i).getName() +", ";
			
		}
		
		plattformLabel = plattformLabel + plattforms.get(plattforms.size()-1).getName();
		
		la_plattform.setText(plattformLabel);
		la_plattform.setAccessibleText(plattformLabel);
		
		
		
	}
	
	
	public void hideButtons() {		
		backbutton.setVisible(false);
		playbutton.setVisible(false);		
	}
	
	
	public void showButtons() {		
		backbutton.setVisible(true);
		playbutton.setVisible(true);
		
		
	}
	
	@FXML
	public void showButtonsMouseMoved() {
				
		if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
		buttonHideTimer.stop();
		showButtons();
		buttonHideTimer.start();	
		}
		
	}
	
	

}
