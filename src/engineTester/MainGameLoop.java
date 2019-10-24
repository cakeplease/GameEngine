package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
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
		
		float[] textureCoords = {
				0,0,
				0,1,
				1,1,
				1,0
		};
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("image")); 
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		
		//check if user tries to exit display by clicking the cross
		while(!Display.isCloseRequested()) {
			
			renderer.prepare();
			shader.start();
			
			//game login
			renderer.render(texturedModel);
			shader.stop();
			DisplayManager.updateDisplay();
			
		}
		shader.cleanUp();
		loader.cleanUp();
		
		//close if user exists the display
		DisplayManager.closeDisplay();

	}

}
