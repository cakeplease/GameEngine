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
			-0.5f, 0.5f, 0,
			-0.5f, -0.5f, 0,
			0.5f, -0.5f, 0,
			0.5f, 0.5f, 0
		};
		
		int[] indices = {
				0,1,3, //top left triangle (v0, v1, v3)
				3,1,2 //bottom right triangle (v3,v1,v2)
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
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
