package application.menu.filter;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;

import application.filter.Filter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuFilterController implements Initializable {

	private List<JFXCheckBox> checkBoxList;
	private List<? extends Filterbar> filterbarList;
	
	private HashMap<Filterbar, JFXCheckBox> filterbarMap;
   
	 @FXML
	 private Label lblFilterTitle;

	 @FXML
	 private VBox filterVBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void setTitle(String text) {
		lblFilterTitle.setText(text);
	}
	
	public void setFilterbar(List<? extends Filterbar> filterbars) {
		this.filterbarList = filterbars;
		filterbarMap = new HashMap<Filterbar, JFXCheckBox>();
		for(Filterbar filterbar : filterbars) {
			JFXCheckBox checkBox = new JFXCheckBox(filterbar.getName());
			
			
			checkBox.setSelected(Filter.getFilter().isActiv(filterbar));
			
			filterVBox.getChildren().add(checkBox);
			filterbarMap.put(filterbar, checkBox);
		}
	}
	

	public void updateFilter(Filter filter) {
		for(Map.Entry<Filterbar, JFXCheckBox> entry : filterbarMap.entrySet()) {
		    Filterbar filterbar = entry.getKey();
		    JFXCheckBox checkBox = entry.getValue();

		    if(checkBox.isSelected())
				filter.addFilter(filterbar);
		    else 
		    	filter.removeFilter(filterbar);
		}
			
		
	}

}