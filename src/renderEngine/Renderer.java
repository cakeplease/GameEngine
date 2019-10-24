package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import models.RawModel;
import models.TexturedModel;

public class Renderer {

	//method to prepare OpenGL to render the game, it will be called every frame 
	public void prepare() {
		GL11.glClearColor(1, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	public void render(TexturedModel texturedModel) {
		RawModel model = texturedModel.getRawModel();
		
		//every time you want to use a VAO you have to bind it
		GL30.glBindVertexArray(model.getVaoID());
		
		//activate the attribute list where data is stored
		//param is attribute list 0
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTexture().getID());
		
		//render
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		
		//disable attribute list after using it
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		
		//unbind VAO
		GL30.glBindVertexArray(0);
		
	}
	
}
 