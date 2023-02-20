import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800,800, "title");

    ArrayList<Object2d> objects = new ArrayList<>();
    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();
    ArrayList<Rectangle> objectsRumah = new ArrayList<>();
    ArrayList<Rectangle> objectsAtap = new ArrayList<>();
    ArrayList<Rectangle> objectsGapAtap = new ArrayList<>();
    ArrayList<Rectangle> objectsCerobong = new ArrayList<>();
    ArrayList<Rectangle> objectsTutupCerobong = new ArrayList<>();
    

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
                                new Vector3f(1.0f, 0.0f, 0.0f),
                                new Vector3f(0.0f, 0.0f, 0.0f),
                                new Vector3f(0.5f, 0.0f, 0.0f)
                        )
                ),  new ArrayList<>(
                List.of(
                        new Vector3f(1.0f, 0.0f, 0.0f),
                        new Vector3f(0.0f, 1.0f, 0.0f),
                        new Vector3f(0.0f, 0.0f, 1.0f)
                )
        )
        ));
//
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-1.0f, -1.5f, 0.0f),
                                new Vector3f(-1.0f, -0.5f, 0.0f),
                                new Vector3f(1.0f, -0.5f, 0.0f),
                                new Vector3f(1.0f, -2.5f, 0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));
        objectsRumah.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, -0.1f, 0.0f),
                                new Vector3f(0.5f, -0.1f, 0.0f),
                                new Vector3f(-0.5f, -0.6f, 0.0f),
                                new Vector3f(0.5f, -0.6f, 0.0f)
                        )
                ),
                new Vector4f(1.0f,0.5f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));
        objectsAtap.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.4f, 0.2f, 0.0f),
                                new Vector3f(0.4f, 0.2f, 0.0f),
                                new Vector3f(-0.6f, -0.2f, 0.0f),
                                new Vector3f(0.6f, -0.2f, 0.0f)
                        )
                ),
                new Vector4f(1f,0.0f,0.0f,2.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));
        objectsGapAtap.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, -0.1f, 0.0f),
                                new Vector3f(-0.4f, 0.11f, 0.0f),
                                new Vector3f(-0.5f, -0.6f, 0.0f),
                                new Vector3f(0.0f, -0.6f, 0.0f)
                        )
                ),
                new Vector4f(1.0f,0.5f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));
        objectsCerobong.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.2f, 0.3f, 0.0f),
                                new Vector3f(0.3f, 0.3f, 0.0f),
                                new Vector3f(0.2f, 0.1f, 0.0f),
                                new Vector3f(0.3f, 0.1f, 0.0f)
                        )
                ),
                new Vector4f(1.0f,0.5f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));
        objectsTutupCerobong.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.18f, 0.32f, 0.0f),
                                new Vector3f(0.32f, 0.32f, 0.0f),
                                new Vector3f(0.18f, 0.28f, 0.0f),
                                new Vector3f(0.32f, 0.28f, 0.0f)
                        )
                ),
                new Vector4f(1.0f,0.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));
    }



    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,0.0f,1.0f,0.0f);
            GL.createCapabilities();

            for (Object2d object : objects) {
                object.drawwithVerticesColor();
            }
            for (Rectangle object2 : objectsRectangle) {
                object2.draw();
            }
            for (Rectangle object3 : objectsRumah) {
                object3.draw();
            }
            for (Rectangle object4 : objectsAtap) {
                object4.draw();
            }
            for (Rectangle object5 : objectsGapAtap) {
                object5.draw();
            }
            for (Rectangle object6 : objectsCerobong) {
                object6.draw();
            }
            for (Rectangle object7 : objectsTutupCerobong) {
                object7.draw();
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