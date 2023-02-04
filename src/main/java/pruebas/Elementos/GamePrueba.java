package pruebas.Elementos;

import java.util.Set;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class GamePrueba extends Game {
	
	public GamePrueba(Canvas canvas) {
		super(canvas);
	}

	@Override
	protected void init() {

		getEntities().addAll(
				new CuerpoPersonaje(this, 120, 50),
				new Muro(this, 0, getHeight() - 20f, getWidth(), 2)
			);

	}

	@Override
	protected void processInput(Set<KeyCode> input) {
		// TODO Auto-generated method stub

	}
}