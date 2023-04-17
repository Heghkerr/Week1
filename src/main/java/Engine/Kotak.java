package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;


public class Kotak extends Object2d {
    double x, y, r, cpx, cpy;
    public Kotak(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, double cpx, double cpy)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.cpx = cpx;
        this.cpy = cpy;

        createKotak();
    }

    public void createKotak()
    {
        vertices.clear();

        for (double i = 45; i < 360; i+=90)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r * (float)Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }

    @Override
    public void draw()
    {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }

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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
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