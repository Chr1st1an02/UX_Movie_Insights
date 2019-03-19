package application.rubrik;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.filmcard.FilmCardBorderPane;
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

    @FXML
    //private GridPane filmeGrid;
	private HBox filmeGrid;
    
    @FXML
    private BorderPane rubrikPane;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		
		
		
		
		RubrikWidthListener rubrikPaneSizeListener = new RubrikWidthListener(); 
	    
	  
		rubrikPane.widthProperty().addListener(rubrikPaneSizeListener);
	}
	
	class RubrikWidthListener implements ChangeListener<Number> {

		@Override
		public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			System.out.println("Height: " + rubrikPane.getHeight() + " Width: " + rubrikPane.getWidth());
			
			try {
				filmeGrid.getChildren().clear();
				for(int i=0; i<((rubrikPane.getWidth()-100)/100); i++) {
					FilmCardBorderPane filmCard = FXMLLoader.load(getClass().getResource("/application/filmcard/FilmCardGUI.fxml"));
//					setFilmCardTitle(filmCard, "Erster Title");
					filmCard.setTitle(i+" Title");
//					filmeGrid.add(filmCard,i,0);
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
    
    


}
