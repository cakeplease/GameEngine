package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {

	//method to prepare OpenGL to render the game, it will be called every frame 
	public void prepare() {
		GL11.glClearColor(1, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	public void render(RawModel model) {
		//every time you want to use a VAO you have to bind it
		GL30.glBindVertexArray(model.getVaoID());
		//activate the attribute list where data is stored
		//param is attribute list 0
		GL20.glEnableVertexAttribArray(0);
		
		//render
		
		/*
		 * 1. what we want to render (triangles)
		 * 2. where in the data it should start rendering from
		 * 3. how many vertices it should render
		 * */
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());
		
		//disable attribute list after using it
		GL20.glDisableVertexAttribArray(0);
		//unbind VAO
		GL30.glBindVertexArray(0);
	}
	
}
