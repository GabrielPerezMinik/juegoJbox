package pruebas.Elementos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jbox2d.common.Vec2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {
	
	boolean derecha,izquierda,arriba,abajo;
	
	WorldF world;
	
	// logic
	
	private GamePrueba game;
	
	// view
	
	@FXML
	private BorderPane view; 
	
	@FXML
	private Canvas canvas;
	
	public Controller() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		game = new GamePrueba(canvas);
		game.fpsProperty().addListener((o, ov, nv) -> System.out.println(nv + "fps"));
		game.start();
		gestionEventos();
		
	}
	
	public BorderPane getView() {
		return view;
	}

	
	private void gestionEventos() {
        /* implementar para pruebas con el mapa */

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                switch (evento.getCode().toString()) {
                case "RIGHT":
                    derecha = true;
                    world.setGravity(new Vec2(1,10f));
                    break;
                case "LEFT":
                    izquierda = true;
                    world.setGravity(new Vec2(-1,10f));
                    break;
                case "UP":
                    arriba = true;
                    world.setGravity(new Vec2(0,-10f));
                    break;
                case "DOWN":
                    abajo = true;
                    world.setGravity(new Vec2(0,10f));
                }
            }
        });

        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                switch (evento.getCode().toString()) {
                case "RIGHT":
                    derecha = false;
                    break;
                case "LEFT":
                    izquierda = false;
                    break;
                case "UP":
                    arriba = false;
                    break;
                case "DOWN":
                    abajo = false;
                }
            }
        });
	}
}
