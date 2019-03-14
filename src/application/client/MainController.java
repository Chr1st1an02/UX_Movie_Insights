package application.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
		//TOP
			BorderPane navigation = FXMLLoader.load(getClass().getResource("/application/navigation/NavigationGUI.fxml"));
			mainBorderPane.setTop(navigation);
			
		//CENTER
			GridPane home = FXMLLoader.load(getClass().getResource("/application/home/HomeGUI.fxml"));
			mainBorderPane.setCenter(home);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    

}
