package application.navigation;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class NavigationController {

    @FXML
    private BorderPane navigationBorderPane;
    
	
	  @FXML
	  void onMenuClicked(ActionEvent event) {
		  try {
			  
			
			BorderPane menu = FXMLLoader.load(getClass().getResource("/application/menu/MenuGUI.fxml"));
			StackPane root = (StackPane)((Node)event.getSource()).getScene().getRoot();
			
			
			root.getChildren().add(1, menu);
			
			
	            
		  } catch (IOException e) {
			e.printStackTrace();
		}
	  }

	  @FXML
	  void onVorgemerktClicked(ActionEvent event) {

	  }
}
