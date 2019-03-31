package application.banner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ServiceLoader;

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
	    private Slider slider;

	    @FXML
	    private ImageView imageView;
	    
	    @FXML
	    private ImageView imageViewL;

	    @FXML
	    private ImageView imageViewR;
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		images = Datenbank.getDatenbank().getBannerImages();
		// TODO Auto-generated method stub
		
		slider.setMax(images.size()-0.001);
		imageView.setImage(images.get(0));
		imageViewR.setImage(images.get(1));
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				int bildId = arg0.getValue().intValue();
				imageView.setImage(images.get(bildId));
				if(bildId>0)
					imageViewL.setImage(images.get(bildId-1));
				else
					imageViewL.setImage(null);
				if(bildId<images.size()-1)
					imageViewR.setImage(images.get(bildId+1));
				else
					imageViewR.setImage(null);
			}
          });
		
		
	}
	
	
}
