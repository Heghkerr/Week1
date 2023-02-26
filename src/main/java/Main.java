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

    private Window window = new Window(800,800, "Hello World");

    ArrayList<Object2d> objects = new ArrayList<>();
    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();
    ArrayList<Rectangle> objectsRumah = new ArrayList<>();
    ArrayList<Rectangle> objectsAtap = new ArrayList<>();
    ArrayList<Rectangle> objectsGapAtap = new ArrayList<>();
    ArrayList<Rectangle> objectsCerobong = new ArrayList<>();
    ArrayList<Rectangle> objectsTutupCerobong = new ArrayList<>();
    ArrayList<Circle> objectsCircle = new ArrayList<>();
    ArrayList<Circle> objectsBulan = new ArrayList<>();
    ArrayList<Oval> objectsOval1 = new ArrayList<>();
    ArrayList<Oval> objectsOval2 = new ArrayList<>();
    ArrayList<Oval> objectsOval3 = new ArrayList<>();
    ArrayList<Star> objectsStar1 = new ArrayList<>();
    ArrayList<Star> objectsStar2 = new ArrayList<>();
    ArrayList<Star> objectsStar3 = new ArrayList<>();

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
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.00f, 0.00f, 0.0f),
                                new Vector3f(0.00f, 0.00f, 0.0f),
                                new Vector3f(0.00f, 0.00f, 0.0f)
                        )
                ),  new Vector4f(1.0f,1.0f,0.0f,1.0f)

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
                new Vector4f(0.0f,1.0f,0.0f,2.0f),
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
        objectsBulan.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                0.1,-0.65,0.68
        ));
        objectsCircle.add(new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
                0.1,-0.60,0.68
        ));
        objectsOval1.add(new Oval(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                0.09,0.26,0.40, 1.6
        ));
        objectsOval2.add(new Oval(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                0.1,0.30,0.47, 2.2
        ));
        objectsOval3.add(new Oval(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                0.13,0.37,0.53, 3
        ));
        objectsStar1.add(new Star (
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.0f,0.0f)
                        )
                ),
                new Vector4f(1.0f,1.0f,0.0f,1.0f),
                Arrays.asList(3,1,1,4,4,2,2,0,0,3)
                ,0.05,-0.2,0.5
        ));
        objectsStar2.add(new Star (
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.0f,0.0f)
                        )
                ),
                new Vector4f(1.0f,1.0f,0.0f,1.0f),
                Arrays.asList(3,1,1,4,4,2,2,0,0,3)
                ,0.02,0.0,0.75
        ));
        objectsStar3.add(new Star (
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.0f,0.0f)
                        )
                ),
                new Vector4f(1.0f,1.0f,0.0f,1.0f),
                Arrays.asList(3,1,1,4,4,2,2,0,0,3)
                ,0.05,0.6,0.7
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
            for (Circle object9 : objectsBulan) {
                object9.draw();
            }
            for (Circle object8 : objectsCircle) {
                object8.draw();
            }
            for (Oval object9 : objectsOval1) {
                object9.draw();
            }
            for (Oval object10 : objectsOval2) {
                object10.draw();
            }
            for (Oval object11 : objectsOval3) {
                object11.draw();
            }
            for (Star object12 : objectsStar1) {
                object12.draw();
            }
            for (Star object13 : objectsStar2) {
                object13.draw();
            }
            for (Star object13 : objectsStar3) {
                object13.draw();
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