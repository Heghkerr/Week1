package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Oval extends Object2d
{
    double x, y, r, cpx, cpy;
    public Oval(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, double cpx, double cpy, double ratio)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.cpx = cpx;
        this.cpy = cpy;

        createHorizontalEllipse(ratio);

    }

    public void createHorizontalEllipse(double yRatio)
    {
        vertices.clear();

        for (double i = 0; i < 360; i+=0.01)
        {
            x = cpx + r * (float)Math.cos(Math.toRadians(i));
            y = cpy + r/yRatio * (float)Math.sin(Math.toRadians(i));

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
}
