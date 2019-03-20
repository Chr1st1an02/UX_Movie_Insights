package application.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.datamodel.Datenbank;
import application.filter.Filter;
import application.rubrik.RubrikController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeController implements Initializable{


    @FXML
    private GridPane homeGrid;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("HomeController");
		try {
			
			BorderPane search = FXMLLoader.load(getClass().getResource("/application/search/SearchGUI.fxml"));
			homeGrid.getChildren().add(search);
			
			ImageView banner = FXMLLoader.load(getClass().getResource("/application/banner/bannerGUI.fxml"));
			homeGrid.getChildren().add(banner);
			
			//Datenbank datenbank = Datenbank.getDatenbank();
			Filter filter = Filter.getFilter();
			
			for(int i=0 ; i<filter.getGenres().size();i++) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/rubrik/RubrikGUI.fxml"));
				BorderPane rubrik= loader.load();
				RubrikController rubrikController = loader.getController();
				rubrikController.setGenre(filter.getGenres().get(i));
				//homeGrid.add(rubrik,0,);
				homeGrid.addRow(i+2, rubrik);
				System.out.println(filter.getGenres().get(i).getName());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
    
    


}
