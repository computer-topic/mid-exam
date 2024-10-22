public class Square {
    public Point topLeft;
    public double side;
}

public class Rectangle {
    public Point topLeft;
    public double height;
    public double width;
}

public class Circle {
    public Point center;
    public double radius;
}

public class Geometry {
    public final double PI = 3.141592653;
    public double area(Object shape) throws NoSuchShapeException {
        if (shape instanceof Square) {
            Square square = (Square) shape;
            return square.side * square.side;
        }
        else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.height * rectangle.width;
        }
        else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return PI * circle.radius * circle.radius;
        }
        throw new NoSuchShapeException();
    }
}