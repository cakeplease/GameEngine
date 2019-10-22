package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		//check if user tries to exit display by clicking the cross
		while(!Display.isCloseRequested()) {
			
			//game login
			//render
			DisplayManager.updateDisplay();
			
		}
		
		//close if user exists the display
		DisplayManager.closeDisplay();

	}

}
