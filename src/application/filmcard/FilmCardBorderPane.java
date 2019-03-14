package application.filmcard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.omg.CosNaming.IstringHelper;

import com.sun.glass.ui.TouchInputSupport;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FilmCardBorderPane extends BorderPane{
	private String title;
	
	public FilmCardBorderPane() throws IOException {
		super();
//		Frage: Ist es Möglich das Obejkt wie folgt zu clonen? Sodass ein erstelltes Obejkt alles aus der fxml übernimmt?
//		this = FXMLLoader.load(getClass().getResource("/application/filmcard/FilmCardGUI.fxml"));
	}
	
	public void setTitle(String title) {
		this.title = title;
		Label titleLabel = (Label) this.getBottom();
		titleLabel.setText(title);
	}
	
	
	
}
