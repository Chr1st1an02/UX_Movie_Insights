package application.rubrik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.filmcard.FilmCardBorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RubrikController implements Initializable{

    @FXML
    private GridPane filmeGrid;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			FilmCardBorderPane filmCard = FXMLLoader.load(getClass().getResource("/application/filmcard/FilmCardGUI.fxml"));
//			setFilmCardTitle(filmCard, "Erster Title");
			filmCard.setTitle("Erster Title");
			filmeGrid.add(filmCard,0,0);
			
			FilmCardBorderPane filmCard2 = FXMLLoader.load(getClass().getResource("/application/filmcard/FilmCardGUI.fxml"));
//			setFilmCardTitle(filmCard2, "Zweiter Title");
			filmCard2.setTitle("Zweiter Title");
			filmeGrid.add(filmCard2,1,0);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	private void setFilmCardTitle(BorderPane filmCard, String title) {
//		Label titleLabel = (Label) filmCard.getBottom();
//		titleLabel.setText(title);
//	}

}
