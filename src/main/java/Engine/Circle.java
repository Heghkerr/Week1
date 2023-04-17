package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object
{
    double x, y, r, cpx, cpy;
    List<Float> centerPoint;
    Float radiusX;
    Float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX,Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createCircle();
        setupVAOVBO();
    }
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, double cpx, double cpy)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.cpx = cpx;
        this.cpy = cpy;

        vertices.clear();

        for (double i = 0; i < 360; i+=0.01)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r * (float)Math.sin(Math.toRadians(i));

            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }
    public double degToRad(float degree){
        return (degree * Math.PI / (float) 180);
    }
    public void createCircle()
    {
        //clear vertices
        vertices.clear();

        for (double i = 0; i < 360; i+=0.01)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r * (float)Math.sin(Math.toRadians(i));

            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }


//gambar persegi panjang menggunakan rumus lingkaran
    public void createRectangle()
    {
        //clear vertices
        vertices.clear();
//kotak totalnya 180 derajat
        for (double i = 45; i < 360; i+=90)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r * (float)Math.sin(Math.toRadians(i));

            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }
//menggambar segitiga menggunakan rumus lingkaran
    public void createTriangle()
    {
//       segitiga juga total 180 derajat namun 3 titik
        vertices.clear();

        for (double i = 90; i < 360; i+=120)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r * (float)Math.sin(Math.toRadians(i));

            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }
//    @Override
//    public void draw()
//    {
//        drawSetup();
//        glLineWidth(1);
//        glPointSize(0);
//        glDrawArrays(GL_POLYGON, 0, vertices.size());
//    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public double getCpx() {
        return cpx;
    }

    public void setCpx(double cpx) {
        this.cpx = cpx;
    }

    public double getCpy() {
        return cpy;
    }

    public void setCpy(double cpy) {
        this.cpy = cpy;
    }
}
