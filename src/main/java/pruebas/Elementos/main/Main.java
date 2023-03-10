package pruebas.Elementos.main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pruebas.Elementos.Controller;

public class Main extends Application{
	
public static Stage primaryStage;
	
	private Controller gameController = new Controller();

	@Override
	public void start(Stage primaryStage) throws Exception {

		Main.primaryStage = primaryStage;

		primaryStage.setTitle("Bouncing Ball");
		primaryStage.setScene(new Scene(gameController.getView()));
		primaryStage.show();
		
	}

}
