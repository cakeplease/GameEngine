package renderEngine;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/*
 * This class will deal with loading 3d model to memory by storing positional data about the model in a VAO
 */

public class Loader {

	//method that will take in positions of the model's vertices, load data into VAO and return information about VAO as a RawModel object
	public RawModel loadToVAO(float[] positions) {
		int vaoID = createVAO();
		storeDataInAttributeList(0, positions);
		unbindVAO();
		return new RawModel(vaoID, positions.length/3);
	}
	
	//method to create a new empty VAO, returns ID of the VAO
	private int createVAO() {
		//create a VAO
		int vaoID = GL30.glGenVertexArrays();
		//active VAO
		GL30.glBindVertexArray(vaoID);
		return vaoID;
	}
	
	//method to store the data in one of the attribute lists of the VAO
	private void storeDataInAttributeList(int attributeNumber, float[] data) {
		int vboID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		
		//convert data into a float buffer
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		
		//store floatbuffer in VBO
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW); //static draw if you don't want to edit this data ever again
		
		//put VBO into a VAO in one of the attribute lists
		/*following params are:
			- attributeNumber where xyz want to store data
			- 3 length of each vertex (x,y,z)
			- GL11.GL_FLOAT type of data
			- false if data is normalized
			- 0, distance between each of vertices, are there any other data between each of vertices
			- 0 offset
		*/
		GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);
		
	}
	
	//method to unbind VAO, when you're done using a VAO
	private void unbindVAO() {
		//unbind
		GL30.glBindVertexArray(0);
	}
	
	//method to convert float array into a float buffer 
	private FloatBuffer storeDataInFloatBuffer(float [] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
}
