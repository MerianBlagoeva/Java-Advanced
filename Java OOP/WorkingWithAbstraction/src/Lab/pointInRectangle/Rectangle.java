package Lab.pointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean isXInside = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        boolean isYInside = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();

        return isXInside && isYInside;

    }
}
