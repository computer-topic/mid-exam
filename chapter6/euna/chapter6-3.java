// (1)과 (2) 빈칸에 들어갈 용어를 작성하세요
- (1) interface
- (2) implements

public (  1  )  Shape {
    public double area();
}
public class Square  (  2  )  Shape {
    private Point topLeft;
    private double side;

    public double area() {
        return side * side;
    }
}

public class Rectangle  (  2  )  Shape {
    private Point topLeft;
    private double height;
    private double width;

    public double area() {
        return height * width;
    }
}

public class Circle  (  2  )  Shape {
    public final double PI = 3.141592653;
    private Point center;
    private double radius;

    public double area() {
        return PI * radius * radius;
    }
}