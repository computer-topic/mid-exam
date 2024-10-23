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
            /* 구현하세요 */
            Square square = (Square)shape;
            return square.side * square.topLeft;
        }
        else if (shape instanceof Rectangle) {
            /* 구현하세요 */
            Rectangle rectagle = (Rectangle)shape;
            return rectagle.height * rectagle.width;
        }
        else if (shape instanceof Circle) {
            /* 구현하세요 */
            Circle cirle = (Circle)circle;
            return circle.radius*circle.radius*PI;
        }
        throw new NoSuchShapeException();
    }
}