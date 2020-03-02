import java.rmi.StubNotFoundException;

public class app {
    public static void main(String[] arg) {
        int[] arr = {2,4,6,11,13,237,4,2};
        for5(arr);
        Student.printFullName("Петров Иван Марьевич");
        Point2 onePoint = new Point2(8, 4);
        onePoint.scale();
        Rectangle oneRectangle = new Rectangle(4,3);
        Circle2 oneCircle = new Circle2(3);
        Shape larger = getLargerShape(oneRectangle,oneCircle);

        System.out.println("The area of the larger shape is: "+larger.area());
    }
    public static void for5(int[] mas){
        for(int i = 0; i < mas.length; i++){
            if (mas[i] == 237){
                System.out.println("Число 237. Конец");
                break;
            }
            else if (mas[i]%2 == 0){
                System.out.println(mas[i]);
            }
        }
    }
    public static Shape getLargerShape(Shape s1, Shape s2) {
        if(s1.area() > s2.area())
            return s1;
        else
            return s2;
    }
}
class Student {
    public static void printFullName(String name){
        System.out.println(name);
    }
}

class Point2{
    int x;
    int y;

    Point2(int x, int y){
        this.x = x;
        this.y = y;
        this.printPoint();
    }

    void printPoint() {
        System.out.println("(" + x + "," + y + ")");
    }

    void scale() {
        this.x = this.x/2;
        this.y = this.y/2;
        this.printPoint();
    }
}

class Shape {
    public double area ()
    {
        return 0;
    }
}
class Circle2 extends Shape {  // ключевое слово "extends" означает наследование

    private static final double PI = Math.PI;   // константа
    private double diameter; //любое число, представляющее диаметр этого круга

    public Circle2(double diameter) { // конструктор
        this.diameter = diameter;
    }

    public double area(){
        double radius = diameter / 2.0;
        return PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double area(){
        return length * width;
    }
}