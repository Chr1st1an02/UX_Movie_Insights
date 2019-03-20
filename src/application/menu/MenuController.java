package application.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.datamodel.Datenbank;
import application.filter.Filter;
import application.menu.filter.Filterbar;
import application.menu.filter.MenuFilterController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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

public class MenuController implements Initializable{

	private List<MenuFilterController> filterControllerList;
	
    @FXML
    private VBox filterKategorieVBox;


    @FXML
    private Button menuX;
    
    public MenuController() {
    	filterControllerList = new ArrayList<MenuFilterController>();
	}

    @FXML
    void onMenuXCLick(ActionEvent event) {
    	Filter filter = Filter.getFilter();
    	for(MenuFilterController menuFilterController : filterControllerList) {
    		menuFilterController.updateFilter(filter);
    	}
    	System.out.println("Filter: upgradeList");
    	filter.upgradeList();
    	
    	
    	
    	
    	StackPane root = (StackPane)((Node)event.getSource()).getScene().getRoot();
		root.getChildren().remove(1);
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FXMLLoader loader;
		try {
			//Genre
			loader = new FXMLLoader(getClass().getResource("/application/menu/filter/MenuFilterGUI.fxml"));
			BorderPane genreFilter = loader.load();
			MenuFilterController genreFilterController = loader.getController();
			genreFilterController.setTitle("Genre");
			genreFilterController.setFilterbar(Datenbank.getDatenbank().getGenreList());
			filterKategorieVBox.getChildren().add(genreFilter);
			filterControllerList.add(genreFilterController);
			
			//Plattform
			loader = new FXMLLoader(getClass().getResource("/application/menu/filter/MenuFilterGUI.fxml"));
			BorderPane plattformFilter = loader.load();
			MenuFilterController plattformFilterController = loader.getController();
			plattformFilterController.setTitle("Plattform");
			plattformFilterController.setFilterbar(Datenbank.getDatenbank().getPlattformList());
			filterKategorieVBox.getChildren().add(plattformFilter);
			filterControllerList.add(plattformFilterController);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


}