package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15C.glBindBuffer;
import static org.lwjgl.opengl.GL15C.glBufferData;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object2d extends ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;


    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        setupVAOVBO();
    }
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.verticesColor = verticesColor;
        setupVAOVBOwithVerticesColor();

    }
    public void setupVAOVBO(){
        vao=glGenVertexArrays();
        glBindVertexArray(vao);

        vbo=glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);

    }
    public void setupVAOVBOwithVerticesColor(){
        vao=glGenVertexArrays();
        glBindVertexArray(vao);

        vbo=glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);

        vboColor=glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(verticesColor),GL_STATIC_DRAW);

    }

    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);

    }
    public void drawSetupwithVerticesColor(){
        bind();

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);


        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
    }

    public void draw(){
        drawSetup();
        glLineWidth(1); //cuma isa jalan saat pke GL_LINE_LOOP
        glPointSize(0); //cuma isa jalan saat pke GL_POINTS
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
        //GL_LINE_STRIP

        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }

    public void drawwithVerticesColor(){
        drawSetupwithVerticesColor();
        glLineWidth(1); //cuma isa jalan saat pke GL_LINE_LOOP
        glPointSize(0); //cuma isa jalan saat pke GL_POINTS
        //GL_TRIANGLES
        //GL_LINE_LOOP
        //GL_LINES
        //GL_POINTS
        //GL_TRIANGLE_FAN
        //GL_LINE_STRIP

        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }

}
