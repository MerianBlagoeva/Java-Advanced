package Lab.p01_SingleResponsibility.p01_DrawingShape;

import Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class ConsoleRenderer implements Renderer {
    @Override
    public void render(Shape shape) {
        System.out.println("Shape with area " + shape.getArea());
    }
}
