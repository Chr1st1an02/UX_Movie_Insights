package application.client;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainMovie extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
			
			Scene scene = new Scene(root,253,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
