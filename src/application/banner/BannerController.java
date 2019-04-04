package application.banner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ServiceLoader;

import javax.swing.Timer;

import application.datamodel.Datenbank;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class BannerController implements Initializable{
	private List<Image> images;
	   @FXML
	    private BorderPane banner;


	    @FXML
	    private ImageView imageView;
	    
	    private int bildId =0;
	    
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		images = Datenbank.getDatenbank().getBannerImages();
		// TODO Auto-generated method stub
		
		
		imageView.setImage(images.get(0));
		
		Timer timer = new Timer(5000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bildId= ++bildId%images.size();
				imageView.setImage(images.get(bildId));
			}
		});
		timer.start();
		
		
		
	}
	
	
}
