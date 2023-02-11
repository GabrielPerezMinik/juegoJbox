package pruebas.Elementos.animations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.image.Image;

/**
 * Clase que realiza las animaciones de un player o cualquier tipo de animacion que quisieramos implementar
 */
public class AnimationV2 {
		
	private long duration;
	private long timeAcc = 0;
	private List<Image> frames;
	private int counter = 0;

	public AnimationV2(long duration, String ... images) {
		this.duration = duration;
		this.frames = Arrays.asList(images).stream().map(Image::new).collect(Collectors.toList());
	}

	public AnimationV2(String ... images) {
		this(200000, images);
	}
	
	public List<Image> getFrames() {
		return frames;
	}
	
	public Image getCurrentFrame() {
		return frames.get(counter);
	}
	
	public void reset() {
		this.counter = 0;
	}

	/**
	 * 
	 * @param El metodo update es llamado por cada frame diferencia de tiempo para que sea frame independiente
	 */
	public void update(long timeDifference) {
		if (timeAcc > duration) {
			counter++;
			if (counter >= frames.size()) {
				counter = 0;
			}
			timeAcc = 0;
		}
		timeAcc += timeDifference;
	}
	
}
