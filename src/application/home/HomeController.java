package application.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.rubrik.RubrikController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class HomeController implements Initializable{


    @FXML
    private GridPane homeGrid;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			BorderPane search = FXMLLoader.load(getClass().getResource("/application/search/SearchGUI.fxml"));
			homeGrid.add(search, 0, 0);
			
			ImageView banner = FXMLLoader.load(getClass().getResource("/application/banner/bannerGUI.fxml"));
			homeGrid.add(banner, 0, 1);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/rubrik/RubrikGUI.fxml"));
			BorderPane rubrik= loader.load();
			RubrikController rubrikController = loader.getController();
			
			homeGrid.add(rubrik, 0, 2);
			rubrikController.nextPage(null);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
    
    


}