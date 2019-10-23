package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		float[] vertices = {
			//left bottom triangle
		   -0.5f, 0.5f, 0f,
		   -0.5f, -0.5f, 0f,
		    0.5f, -0.5f, 0f,
		    //right top triangle
		    0.5f, -0.5f, 0f,
		    0.5f, 0.5f, 0f,
		    -0.5f, 0.5f, 0f
		};
		
		RawModel model = loader.loadToVAO(vertices);
		
		//check if user tries to exit display by clicking the cross
		while(!Display.isCloseRequested()) {
			
			renderer.prepare();
			//game login
			renderer.render(model);
			DisplayManager.updateDisplay();
			
		}
		loader.cleanUp();
		
		//close if user exists the display
		DisplayManager.closeDisplay();

	}

}
