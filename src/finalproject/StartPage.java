package finalproject;


import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartPage extends Application{

	public static Stage mainStage;
	public static Scene mainScene;
		
	@Override
	public void start(Stage mainStage) throws IOException {
		
		StartPage.mainStage = mainStage;
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("StartPage.fxml"));
		Parent main = loadder.load();
		
		FXMLLoader loadderr = new FXMLLoader(getClass().getResource("PlayField.fxml"));
		Parent main2 = loadderr.load();
		
		mainScene = new Scene(main);
		mainStage.setTitle("³Â±N");
		mainStage.setScene(mainScene);
		mainStage.show();	
		
		StartPageControl mainCtrl = loadder.getController();
		mainScene.setOnKeyPressed(mainCtrl.OnKeyPressed);
		
	}
		

	public static void main(String[] args) {
		launch(args);
	}
		
		
}
