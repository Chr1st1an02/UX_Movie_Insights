package application.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuController implements Initializable {

    @FXML
    private VBox filterKategorieVBox;


    @FXML
    private Button menuX;

    @FXML
    void onMenuXCLick(ActionEvent event) {
    	StackPane root = (StackPane)((Node)event.getSource()).getScene().getRoot();
		 
		root.getChildren().remove(1);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			for(int i=0; i<3; i++) {
				BorderPane filmCard = FXMLLoader.load(getClass().getResource("/application/menu/filter/MenuFilterGUI.fxml"));
//				setFilmCardTitle(filmCard, "Erster Title");
//				filmCard.setTitle(i+" Title");
//				filmeGrid.add(filmCard,i,0);
				filterKategorieVBox.getChildren().add(filmCard);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}