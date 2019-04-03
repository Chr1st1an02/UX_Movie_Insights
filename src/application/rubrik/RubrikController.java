package application.rubrik;

import java.awt.print.Pageable;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.imageio.ImageTypeSpecifier;

import com.sun.glass.ui.TouchInputSupport;

import application.datamodel.Datenbank;
import application.datamodel.Film;
import application.datamodel.Genre;
import application.filmcard.FilmCardController;
import application.filter.Filter;
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

public class RubrikController implements  Initializable{

	private Genre genre;
	private List<Film> filme;
	private int page=0;
	private int filmePerPage;
	
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
			int filmePerPageNeu = (int)((rubrikPane.getWidth()-100)/130);
			page= page*filmePerPage/filmePerPageNeu;
			filmePerPage = filmePerPageNeu;
			showFilme();
		}

	}
	
	private void showFilme(){
		try {
			filmeGrid.getChildren().clear();
			for(int i=page*filmePerPage; i<page*filmePerPage+filmePerPage+1 && i<filme.size(); i++) {
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
	
    @FXML
    public void nextPage(ActionEvent event) {
    	page = (page!=((filme.size()+1)/filmePerPage)?page+1:0);
    	System.out.println(page);
    	showFilme();
    }
    
    @FXML
    void prevPage(ActionEvent event) {
    	page = (page!=0?page-1:((filme.size()+1)/filmePerPage));
    	System.out.println(page);
    	showFilme();
    }
    
    public void setGenre(Genre genre) {
    	this.genre = genre;
    	this.setTitle(genre.getName());
    	getFilme();
    }
    
    private void setTitle(String title) {
    	lblRubrikTitle.setText(title);
    }

	
	
	private void getFilme() {
		filme = Filter.getFilter().getListe(genre);
	}

    
	
 
    
    


}
