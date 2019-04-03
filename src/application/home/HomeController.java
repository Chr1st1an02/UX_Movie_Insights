package application.home;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import application.datamodel.Datenbank;
import application.filter.Filter;
import application.rubrik.RubrikController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeController implements  Observer, Initializable{


    @FXML
    private GridPane homeGrid;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("HomeController");
		Filter.getFilter().addObserver(this);
		try {
			
			BorderPane search = FXMLLoader.load(getClass().getResource("/application/search/SearchGUI.fxml"));
			homeGrid.add(search,0,0);
			
			BorderPane banner = FXMLLoader.load(getClass().getResource("/application/banner/bannerGUI.fxml"));
			homeGrid.add(banner,0,1);
			
			//Datenbank datenbank = Datenbank.getDatenbank();
			//FilmRubrike Laden
			ladeRubrike();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		try {
			//Lösche Alte Rubrik Inhalte
			while(homeGrid.getChildren().size() > 2){
				System.out.println(homeGrid.getChildren().size());
			    homeGrid.getChildren().remove(2);
			}
			
			ladeRubrike();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void ladeRubrike() throws IOException {
		Filter filter = Filter.getFilter();
		for(int i=0 ; i<filter.getGenres().size();i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/rubrik/RubrikGUI.fxml"));
			BorderPane rubrik= loader.load();
			RubrikController rubrikController = loader.getController();
			rubrikController.setGenre(filter.getGenres().get(i));
			//homeGrid.add(rubrik,0,);
			homeGrid.addRow(i+2, rubrik);
		}
	}
    
    
    


}
