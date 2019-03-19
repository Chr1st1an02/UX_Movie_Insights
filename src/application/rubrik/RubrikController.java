package application.rubrik;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.datamodel.Datenbank;
import application.datamodel.Film;
import application.datamodel.Genre;
import application.filmcard.FilmCardController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class RubrikController implements Initializable{

	private Genre genre;
	private List<Film> filme;
	
    @FXML
	private HBox filmeGrid;
    
    @FXML
    private BorderPane rubrikPane;
    
    @FXML
    private Label lblRubrikTitle;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		RubrikWidthListener rubrikPaneSizeListener = new RubrikWidthListener(); 
	    
		
	  
		rubrikPane.widthProperty().addListener(rubrikPaneSizeListener);
	}
	
	class RubrikWidthListener implements ChangeListener<Number> {

		@Override
		public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			try {
				filmeGrid.getChildren().clear();
				for(int i=0; i<((rubrikPane.getWidth()-100)/100); i++) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/filmcard/FilmCardGUI.fxml"));
					BorderPane filmCard = fxmlLoader.load();
					FilmCardController filmCardController = fxmlLoader.getController();
					filmCardController.setFilm(filme.get(i));
					filmeGrid.getChildren().add(filmCard);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

	}
	
//	private void setFilmCardTitle(BorderPane filmCard, String title) {
//		Label titleLabel = (Label) filmCard.getBottom();
//		titleLabel.setText(title);
//	}
	
    @FXML
    public void nextPage(ActionEvent event) {
    	System.out.println("nextPage");
    }
    
    public void setGenre(Genre genre) {
    	this.genre = genre;
    	this.setTitle(genre.getName());
    	filme = Datenbank.getDatenbank().getFilme(genre);
    }
    
    private void setTitle(String title) {
    	lblRubrikTitle.setText(title);
    }
    
    


}
