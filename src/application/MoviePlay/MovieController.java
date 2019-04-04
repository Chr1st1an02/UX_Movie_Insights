package application.MoviePlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.datamodel.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;






public class MovieController implements Initializable {
	
	@FXML
	private MediaView mediaView;
	
	@FXML
	private JFXButton Playbutton;
	
	private MediaPlayer mediaPlayer;
	private Film film;

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
			}
		else {
			mediaPlayer.play();
			Playbutton.setText("| |");
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

}
