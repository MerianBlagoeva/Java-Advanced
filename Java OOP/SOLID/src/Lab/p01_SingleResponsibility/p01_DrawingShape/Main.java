package Lab.p01_SingleResponsibility.p01_DrawingShape;

import Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;
import Lab.p02_OpenClosedPrinciple.p02_DrawingShape.Circle;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Rectangle(13,2);
        DrawingManager drawingManager = new DrawingManagerImpl(new ConsoleRenderer());

        Shape circle = new Circle(13);

        drawingManager.draw(shape);
        drawingManager.draw(circle);
    }
}
