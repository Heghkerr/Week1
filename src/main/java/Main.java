import Engine.Object2d;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800,800, "title");

    ArrayList<Object2d> objects = new ArrayList<>();

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init() {
        window.init();
        GL.createCapabilities();

        objects.add(new Object2d(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scenewithVerticesColor.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scenewithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f)
                        )
                ),  new ArrayList<>(
                List.of(
                        new Vector3f(1.0f, 0.0f, 0.0f),
                        new Vector3f(0.0f, 1.0f, 0.0f),
                        new Vector3f(0.0f, 0.0f, 1.0f)
                )
        )
        ));
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();

            for (Object2d object : objects) {
                object.drawwithVerticesColor();
            }
            glDisableVertexAttribArray(0);
            glfwPollEvents();
            glfwPollEvents();
        }

    }
    public static void main(String[] args) {
        new Main().run();
    }
}