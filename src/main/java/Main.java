import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.lines;
import static org.joml.Vector2d.distance;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800,800, "Hello World");

//    ArrayList<Object2d> objects = new ArrayList<>();
//    ArrayList<Rectangle> objectsRectangle = new ArrayList<>();
//    ArrayList<Rectangle> objectsRumah = new ArrayList<>();
//    ArrayList<Rectangle> objectsAtap = new ArrayList<>();
//    ArrayList<Rectangle> objectsGapAtap = new ArrayList<>();
//    ArrayList<Rectangle> objectsCerobong = new ArrayList<>();
//    ArrayList<Rectangle> objectsTutupCerobong = new ArrayList<>();
//    ArrayList<Circle> objectsCircle = new ArrayList<>();
//    ArrayList<Circle> objectsBulan = new ArrayList<>();
//    ArrayList<Oval> objectsOval1 = new ArrayList<>();
//    ArrayList<Oval> objectsOval2 = new ArrayList<>();
//    ArrayList<Oval> objectsOval3 = new ArrayList<>();
//    ArrayList<Star> objectsStar1 = new ArrayList<>();
//    ArrayList<Star> objectsStar2 = new ArrayList<>();
//    ArrayList<Star> objectsStar3 = new ArrayList<>();
    ArrayList<Object> objects = new ArrayList<>();

    ArrayList<Object2d> objectsPointControl = new ArrayList<>();
    ArrayList<Kotak> objectKotak = new ArrayList<>();
    int countDegree = 0;
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    Camera camera = new Camera();


    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }


    public void init() {
        window.init();
        GL.createCapabilities();

        camera.setPosition(0,0,1.7f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(30.0f));

//        objects.add(new Object2d(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.00f, 0.00f, 0.0f),
//                                new Vector3f(0.00f, 0.00f, 0.0f),
//                                new Vector3f(0.00f, 0.00f, 0.0f)
//                        )
//                ), new Vector4f(1.0f, 1.0f, 0.0f, 1.0f)
//
//        ));
//
////
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f, -1.5f, 0.0f),
//                                new Vector3f(-1.0f, -0.5f, 0.0f),
//                                new Vector3f(1.0f, -0.5f, 0.0f),
//                                new Vector3f(1.0f, -2.5f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.0f, 153 / 255.f, 0.0f, 1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsRumah.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f, -0.1f, 0.0f),
//                                new Vector3f(0.5f, -0.1f, 0.0f),
//                                new Vector3f(-0.5f, -0.6f, 0.0f),
//                                new Vector3f(0.5f, -0.6f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.5f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsAtap.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.4f, 0.2f, 0.0f),
//                                new Vector3f(0.4f, 0.2f, 0.0f),
//                                new Vector3f(-0.6f, -0.2f, 0.0f),
//                                new Vector3f(0.6f, -0.2f, 0.0f)
//                        )
//                ),
//                new Vector4f(1f, 0.0f, 0.0f, 2.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsGapAtap.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f, -0.1f, 0.0f),
//                                new Vector3f(-0.4f, 0.11f, 0.0f),
//                                new Vector3f(-0.5f, -0.6f, 0.0f),
//                                new Vector3f(0.0f, -0.6f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.5f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsCerobong.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.2f, 0.3f, 0.0f),
//                                new Vector3f(0.3f, 0.3f, 0.0f),
//                                new Vector3f(0.2f, 0.1f, 0.0f),
//                                new Vector3f(0.3f, 0.1f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.5f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsTutupCerobong.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.18f, 0.32f, 0.0f),
//                                new Vector3f(0.32f, 0.32f, 0.0f),
//                                new Vector3f(0.18f, 0.28f, 0.0f),
//                                new Vector3f(0.32f, 0.28f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsAtap.add(new Rectangle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.4f, 0.2f, 0.0f),
//                                new Vector3f(0.4f, 0.2f, 0.0f),
//                                new Vector3f(-0.6f, -0.2f, 0.0f),
//                                new Vector3f(0.6f, -0.2f, 0.0f)
//                        )
//                ),
//                new Vector4f(1f, 0.0f, 0.0f, 2.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        objectsBulan.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                0.1, -0.65, 0.68
//        ));
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
//                0.1, -0.60, 0.68
//        ));
//        objectsOval1.add(new Oval(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
//                0.09, 0.26, 0.40, 1.6
//        ));
//        objectsOval2.add(new Oval(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
//                0.1, 0.30, 0.47, 2.2
//        ));
//        objectsOval3.add(new Oval(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
//                0.13, 0.37, 0.53, 3
//        ));
//        objectsStar1.add(new Star(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.0f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                Arrays.asList(3, 1, 1, 4, 4, 2, 2, 0, 0, 3)
//                , 0.05, -0.2, 0.5
//        ));
//        objectsStar2.add(new Star(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.0f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                Arrays.asList(3, 1, 1, 4, 4, 2, 2, 0, 0, 3)
//                , 0.02, 0.0, 0.75
//        ));
//        objectsStar3.add(new Star(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.0f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                Arrays.asList(3, 1, 1, 4, 4, 2, 2, 0, 0, 3)
//                , 0.05, 0.6, 0.7
//        ));

//        objectsPointControl.add(new Object2d(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
//
//        ));
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.8f,0.3f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                18
//        ));
//
//        objects.get(0).scaleObject(1.2f,1.2f,1.2f);
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.8f,0.8f,0.8f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                18
//        ));
//        objects.get(1).translateObject(0.37f,-0.1f,0.0f);
//        objects.get(1).scaleObject(0.5f,0.5f,0.5f);
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.8f,0.5f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                18
//        ));
//        objects.get(2).translateObject(0.5f,0.1f,0.0f);
//        objects.get(2).scaleObject(0.55f,0.55f,0.55f);
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                18
//        ));
//        objects.get(3).translateObject(0.6f,-0.1f,0.0f);
//        objects.get(3).scaleObject(0.65f,0.65f,0.65f);
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                18
//        ));
//        objects.get(4).translateObject(0.8f,0.1f,0.0f);
//        objects.get(4).scaleObject(0.65f,0.65f,0.65f);
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.7f,0.7f,0.7f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.1f,
//                0.1f,
//                0.1f,
//                36,
//                18
//        ));
//        objects.get(5).translateObject(1.6f,-0.5f,0.0f);
//        objects.get(5).scaleObject(0.3f,0.3f,0.3f);
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        objects.get(0).translateObject(0.5f,0.0f,0.0f);
        objects.get(0).scaleObject(1f,1f,1f);



//        objects.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(0).translateObject(0.25f,0.0f,0.0f);
//        objects.get(0).getChildObject().get(0).setCenterPoint(Arrays.asList(0.25f,0.0f,0.0f));

//        objects.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(1).translateObject(0.5f,0.0f,0.0f);
//        objects.get(0).getChildObject().get(1).setCenterPoint(Arrays.asList(0.5f,0.0f,0.0f));

//        objects.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.5f,0.5f,0.5f);
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f,-0.1f,0.0f);
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).setCenterPoint(Arrays.asList(0.5f,-0.1f,0.0f));
    }






    public void input() {
//        if (window.isKeyPressed(GLFW_KEY_F)) {
//            objects.get(0).rotateObject((float) Math.toRadians(0.8f),0.0f,0.0f,1.0f);
//            objects.get(1).rotateObject((float) Math.toRadians(0.7f),0.0f,0.0f,1.0f);
//            objects.get(2).rotateObject((float) Math.toRadians(0.6f),0.0f,0.0f,1.0f);
//            objects.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objects.get(4).rotateObject((float) Math.toRadians(0.4f),0.0f,0.0f,1.0f);
//            objects.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//
//
//        }
//        if (window.isKeyPressed(GLFW_KEY_G)) {
//
//            objects.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//
//            Vector3f merkurius = objects.get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
//            objects.get(1).translateObject(-merkurius.x,-merkurius.y,0f);
//            objects.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(1).translateObject(merkurius.x,merkurius.y,0f);
//
//            Vector3f venus = objects.get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
//            objects.get(2).translateObject(-venus.x,-venus.y,0f);
//            objects.get(2).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(2).translateObject(venus.x,venus.y,0f);
//
//            Vector3f bumi = objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
//            objects.get(3).translateObject(-bumi.x,-bumi.y,0f);
//            objects.get(3).rotateObject((float) Math.toRadians(0.8f),0f,0f,1f);
//            objects.get(3).translateObject(bumi.x,bumi.y,0f);
//
//            Vector3f mars = objects.get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
//            objects.get(4).translateObject(-mars.x,-mars.y,0f);
//            objects.get(4).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(4).translateObject(mars.x,mars.y,0f);
//
//            Vector3f bulan = objects.get(5).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
//            objects.get(5).translateObject(-bulan.x,-bulan.y,0f);
//            objects.get(5).rotateObject((float) Math.toRadians(0.8f),0f,0f,1f);
//            objects.get(5).translateObject(bulan.x,bulan.y,0f);
//
//
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_H)) {
//
//            Vector3f bulan = objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
//            objects.get(5).translateObject(-bulan.x,-bulan.y,0f);
//            objects.get(5).rotateObject((float) Math.toRadians(0.8f),0f,0f,1f);
//            objects.get(5).translateObject(bulan.x,bulan.y,0f);
//
//
//        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.1f), 0.0f, 0.0f, 1.0f);
            for(Object child:objects.get(0).getChildObject()){
                Vector3f tempCenterPoint=child.updateCenterPoint();
                child.translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
                child.rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
                child.translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
            }
            for(Object child:objects.get(0).getChildObject().get(1).getChildObject()){
                Vector3f tempCenterPoint=objects.get(0).getChildObject().get(1).updateCenterPoint();
                child.translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
                child.rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
                child.translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
            }




        }
//        Vector2f pos = null;
//        if (window.getMouseInput().isLeftButtonPressed()) {
//            pos = window.getMouseInput().getCurrentPos();
////           System.out.println("x : "+pos.x+" y : "+pos.y);
//            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//                System.out.println("x : " + pos.x + " y : " + pos.y);
//                objectsPointControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//            }
//        }
//        if (window.getMouseInput().isLeftButtonPressed()) {
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//            //System.out.println("x : "+pos.x+" y : " +pos.y);
//            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
//
//            //System.out.println("x : "+pos.x+" y : " +pos.y);
//            if ((!(pos.x > 0.97 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//                System.out.println("x : " + pos.x + " y : " + pos.y);
//
//                List<Vector3f> curPoints = objectsPointControl.get(0).getVertices();
//                boolean valid = true;
//                int index = 0;
//                for (Vector3f curPoint : curPoints) { //cek jarak
//                    System.out.println(distance(pos.x, pos.y, curPoint.x, curPoint.y));
//                    if (distance(pos.x, pos.y, curPoint.x, curPoint.y) < 0.1f) {
//                        valid = false;
//                        break;
//                    }
//                    index += 1;
//                }
//                if (!valid) {
//                    System.out.println(index);
//                    objectKotak.get(index).setCpx(pos.x);
//                    objectKotak.get(index).setCpy(pos.y);
//                    objectKotak.get(index).createKotak();
//                    objectKotak.get(index).setupVAOVBO();
//                    List<Vector3f> temp = objectsPointControl.get(0).getVertices();
//                    temp.set(index, new Vector3f(pos.x, pos.y, 0));
//
//                    objectsPointControl.get(0).setupVAOVBO();
//
//                    objectsPointControl.get(0).updateCurve(curPoints);
//
//                    return;
//                }
//
//                objectsPointControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0.0f));
//                objectKotak.add(new Kotak(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(),
//                        new Vector4f(0.5f, 0.0f, 0.5f, 1.0f),
//                        0.22, pos.x, pos.y
//                ));
//
//                objectsPointControl.get(0).updateCurve(curPoints);
//            }
//        }
    }

    float distance(float x , float y, float x1, float y1){
        return (float) (Math.sqrt(Math.pow(x1 - x, 2) +  (Math.pow(y1 - y, 2))));
    }




    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();

            input();

            for (Object object1 : objects) {
                object1.draw(camera, projection);
            }
//            for (Rectangle object2 : objectsRectangle) {
//                object2.draw();
//            }
//            for (Rectangle object3 : objectsRumah) {
//                object3.draw();
//            }
            for (Rectangle object4 : objectsAtap) {
                object4.draw(camera,projection);
            }
//            for (Rectangle object5 : objectsGapAtap) {
//                object5.draw();
//            }
//            for (Rectangle object6 : objectsCerobong) {
//                object6.draw();
//            }
//            for (Rectangle object7 : objectsTutupCerobong) {
//                object7.draw();
//            }
//            for (Circle object9 : objectsBulan) {
//                object9.draw();
//            }
//            for (Circle object8 : objectsCircle) {
//                object8.draw();
//            }
//            for (Oval object9 : objectsOval1) {
//                object9.draw();
//            }
//            for (Oval object10 : objectsOval2) {
//                object10.draw();
//            }
//            for (Oval object11 : objectsOval3) {
//                object11.draw();
//            }
//            for (Star object12 : objectsStar1) {
//                object12.draw();
//            }
//            for (Star object13 : objectsStar2) {
//                object13.draw();
//            }
//            for (Star object13 : objectsStar3) {
//                object13.draw();
//            }
//            for (Object2d object14 : objectsPointControl) {
//                object14.drawLine();
//            }
//            for (Object2d object : objectsPointControl){
//                object.setupVAOVBO();
//                object.drawLine();
//            }
//            for (Object2d object : objectsPointControl){
//                object.setupVAOVBOCurve();
//                object.drawCurve();
//            }
//            for (Object2d object : objectKotak) {
//                object.draw();
//            }

            glDisableVertexAttribArray(0);
            glfwPollEvents();
            glfwPollEvents();
        }

    }
    public static void main(String[] args) {
        new Main().run();
    }
}