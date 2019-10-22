package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	//set width and height of the display
	private static final int WIDTH = 1280;
	private static final int HEIGHT	 = 720;
	//set fps
	private static final int FPS_CAP = 120;
	
	public static void createDisplay() {
		//version of the opengl in the ()
		ContextAttribs attribs = new ContextAttribs(3,2);
		attribs.withForwardCompatible(true);
		attribs.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//tell OpenGL where in the display it can render the game (the whole display)
		//bottom left (0,0) and top right (width, height) of the display in pixels
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
		
	}
	
	public static void updateDisplay() {
		
		Display.sync(FPS_CAP);
		Display.update();
		
	}
	
	public static void closeDisplay() {
		
		Display.destroy();
		
	}
	
}
