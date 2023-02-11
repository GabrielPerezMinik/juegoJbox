package pruebas.Elementos.animations;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class pruebaAni extends Application {

	private Animation imageViewSprite;

	@Override
	public void start(Stage stage) {

		// load the image
		Image image = new Image("imagen/Idle_Animation42x42x22f.png");

		// simple displays ImageView the image as is
		ImageView iv1 = new ImageView();
		iv1.setImage(image);

//		Animation anim1 = new Animation(iv1,new Image("imagen/Idle_Animation42x42x22f.png"),42, 42, 22, 44, 60,25);
		Animation anim1=new Animation(iv1,new Image("imagen/Idle_Animation42x42x22f.png"),23,23,22,42,42,22);

		anim1.start();
	
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.BLACK);
		HBox box = new HBox();
		box.getChildren().add(iv1);
		root.getChildren().add(box);

		stage.setTitle("ImageView");
		stage.setWidth(415);
		stage.setHeight(200);
		stage.setScene(scene);

		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
