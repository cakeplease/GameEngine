package models;

/*
	Things we are going to do here:
	-render a rectangle (two triangles)
	-take the vertex positions data of those triangles
	-create a VBO
	-store the data into the VBO 
	-create a VAO
	-storing the VBO data into the attribute list of VAO 
	-use the ID of the VAO to tell the OpenGl to render the VAO rectangle
*/ 

// This class will represent a 3d model stored in memory
public class RawModel {
	
	//Two things we need to know about a model once stored in memory
	
	//it's ID
	private int vaoID;
	
	//number of vertices in the model
	private int vertexCount;
	
	//constructor
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
}
