package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15C.glBindBuffer;
import static org.lwjgl.opengl.GL15C.glBufferData;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object2d extends ShaderProgram{
    List<Vector3f> curveVertices;
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
        this.curveVertices = new ArrayList<>();
    }
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.verticesColor = verticesColor;
        setupVAOVBOwithVerticesColor();
        this.curveVertices = new ArrayList<>();

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
    public void drawLine() {
        drawSetup();
        glLineWidth(1); //ketebalan garis
        glPointSize(0); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public void addVertices (Vector3f newvetor){
        vertices.add(newvetor);
        setupVAOVBO();
    }


    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
    }
    public void setVertice(int index, Vector3f v){
        vertices.set(index, v);
        setupVAOVBO();
    }

    public void setupVAOVBOCurve(){
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        // set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        // mengirim vertices
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(curveVertices), GL_STATIC_DRAW);
    }
    public void drawCurve(){
        if(vertices.size()<3) {
            if(vertices.size()==2){
                for (Vector3f vertice: vertices){
                    curveVertices.add(vertice);
                }
            }
            return;
        }
        setupVAOVBOCurve();
        drawSetup();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_LINE_STRIP, 0, curveVertices.size());
    }
    public void updateCurve(List<Vector3f> points){
        if(vertices.size() < 2) return;
        curveVertices.clear();
        curveVertices.add(vertices.get(0));
        int size = vertices.size();
        double interval = 0.02;
        for (double i = 0; i <= 1; i += interval) {
//            double j = 1-i;
//            float tempx = 0, tempy = 0;
//            for(int p=0; p<=size-1; p+=1){
//                tempx += C(size-1,p) * Math.pow(i,p) * Math.pow(j,size-p-1) * vertices.get(p).x;
//                tempy += C(size-1,p) * Math.pow(i,p) * Math.pow(j,size-p-1) * vertices.get(p).y;
//            }
            curveVertices.add(new Vector3f(calculateBezierPoint((float) i, points)));
        }
        curveVertices.add(vertices.get(vertices.size()-1));
    }

    public int combination(int n, int k){
        int ans = factorial(n);
        ans /= factorial(k);
        ans /= factorial(n-k);
        return ans;
    }
    public int factorial(int x){
        int ans = 1;
        for(int i=1; i<=x; i++) ans *= x;
        return ans;
    }
    public static Vector3f calculateBezierPoint(float t, List<Vector3f> points) {
        int n = points.size() - 1;
        float x = 0, y = 0;

        for (int i = 0; i <= n; i++) {
            double coefficient = calculateCoefficient(n, i, t);
            x += coefficient * points.get(i).x;
            y += coefficient * points.get(i).y;
        }

        return new Vector3f(x, y, 0.0f);
    }

    private static double calculateCoefficient(int n, int i, double t) {
        return binomialCoefficient(n, i) * Math.pow(t, i) * Math.pow(1 - t, n - i);
    }

    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
        }
    }

}