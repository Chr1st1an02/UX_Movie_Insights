package application.client;
	

import java.util.ArrayList;
import java.util.Arrays;

import application.datamodel.Datenbank;
import application.datamodel.Film;
import application.datamodel.Genre;
import application.datamodel.Plattform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainMovie extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			StackPane root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
			Scene scene = new Scene(root,800,400);
			primaryStage.setFullScreen(true);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("ScrollPane.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 Datenbank datenbank = Datenbank.getDatenbank();
		 
		 Plattform netflix = new Plattform("Netflix");
		 Plattform amazon = new Plattform("Amazon Prime");
		 Plattform maxdown = new Plattform("Maxdown");
		 
		 datenbank.addPlattform(netflix);
		 datenbank.addPlattform(amazon);
		 datenbank.addPlattform(maxdown);
		 
		 Genre horror = new Genre("Horror");
		 Genre komoedie = new Genre("Komödie");
		 Genre kinder = new Genre("Kinder");
		 Genre doku = new Genre("Doku");
		 
		 datenbank.addGenre(horror);
		 datenbank.addGenre(komoedie);
		 datenbank.addGenre(kinder);
		 datenbank.addGenre(doku);
		 
		 Image bannerImage0 = new Image("/application/images/banner0.jpeg");
		 datenbank.addBannerImages(bannerImage0);
		 Image bannerImage1 = new Image("/application/images/banner1.jpg");
		 datenbank.addBannerImages(bannerImage1);
		 Image bannerImage2 = new Image("/application/images/banner2.jpg");
		 datenbank.addBannerImages(bannerImage2);
		 
		 for(int i=0;i<2;i++) {
			 Image filmCardImage = new Image("/application/images/film"+i+".jpg");
			 datenbank.addFilmCardImages(filmCardImage);
		 }
		 
		 for(int i =0; i<20 ; i++) {
			 //Alle Plattformen
			 datenbank.addFilm(new Film("Horrorfilm Alle"+i, "Horrorfilm auf Netflix, Amazon, Maxdown", 102, 18, horror, netflix, amazon, maxdown ));
			 datenbank.addFilm(new Film("Doku Alle"+i, "Doku auf Netflix, Amazon, Maxdown", 102, 18, doku, netflix, amazon, maxdown ));
			 datenbank.addFilm(new Film("Kinder Alle"+i, "Kinder auf Netflix, Amazon, Maxdown", 102, 18, kinder, netflix, amazon, maxdown ));
			 datenbank.addFilm(new Film("Komödie Alle"+i, "Komödie auf Netflix, Amazon, Maxdown", 102, 18, komoedie, netflix, amazon, maxdown ));
			 
			 //Nur Netflix
			 datenbank.addFilm(new Film("Horrorfilm N"+i, "Horrorfilm auf Netflix", 102, 18, horror, netflix));
			 datenbank.addFilm(new Film("Doku N"+i, "Doku auf Netflix", 102, 18, doku, netflix));
			 datenbank.addFilm(new Film("Kinder N"+i, "Kinder auf Netflix", 102, 18, kinder, netflix));
			 datenbank.addFilm(new Film("Komödie N"+i, "Komödie auf Netflix", 102, 18, komoedie, netflix));

			 //Nur Amazon
			 datenbank.addFilm(new Film("Horrorfilm A"+i, "Horrorfilm auf Amazon", 102, 18, horror, amazon));
			 datenbank.addFilm(new Film("Doku A"+i, "Doku auf Amazon", 102, 18, doku, amazon));
			 datenbank.addFilm(new Film("Kinder A"+i, "Kinder auf Amazon", 102, 18, kinder, amazon));
			 datenbank.addFilm(new Film("Komödie A"+i, "Komödie auf Amazon", 102, 18, komoedie, amazon));
		 }
		 
		launch(args);
	}
}
