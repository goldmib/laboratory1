import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

class Point {
    public double x; // абсцисса точки
    public double y; // ордината точки

    // возвращает строку с описанием точки
    public String toString() {
        return "("+x+";"+y+")";
    }
    // выводит на экран описание точки
    public void print() {
        System.out.println(this.toString());
    }
    // метод перемещает точку на указанный вектор
    public void movePoint(double a, double b) {
        x = x + a;
        y = y + b;
    }
    // метод изменяет координаты точки на указанные
    public void setPoint(double a, double b) {
        x = a;
        y = b;
    }
    // конструктор по умолчанию
    public Point() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите точку x: ");
        x = in.nextDouble();
        System.out.print("Введите точку y: ");
        y = in.nextDouble();
    }
    // конструктор, создающий точку с указанными координатами
    public Point(double a, double b) {
        x = a;
        y = b;
    }
    // метод вычисляющий расстояние между точками
    public double length(Point p) {
        return Math.sqrt( Math.pow(p.x-x,2) + Math.pow(p.y-y,2) );
    }
    // метод проверяющий совпадают ли точки
    public boolean equalsPoint(Point p) {
        if(this.x == p.x && this.y == p.y) {
            return true;
        } else {
            return false;
        }
    }
    //Метод для определния координатной четверти
    public void coordinatePlane (){
        if (x>0 && y>0){
            System.out.println("Первая четверть");
        }
        else if (x<0 && y>0){
            System.out.println("Вторая четверть");
        }
        else if (x<0 && y<0){
            System.out.println("Третья четверть");
        }
        else if (x>0 && y<0){
            System.out.println("Четвертая четверть");
        }
        else {
            System.out.println("Точка лежит на границе четвертей");
        }
    }
    //Метод проверки симметричности точек отн 0,0
    public void symmetryPoint (Point p2){
        if ((x == p2.x * (-1)) && (y == p2.y * (-1)) ){
            System.out.println("Точки симметричны");
        }
        else{
            System.out.println("Точки не симметричны");
        }
    }
    public boolean collinearityPoint(Point p2, Point p3){
        double x1 = this.x;
        double y1 = this.y;
        double x2 = p2.x;
        double y2 = p2.y;
        double x3 = p3.x;
        double y3 = p3.y;
        if ((x1-x3)/(x2-x3) == (y1-y3)/(y2-y3)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean equals(Point p){
        if(this.x == p.x && this.y == p.y) {
            return true;
        } else {
            return false;
        }
    }
    public int hashCode(){
        return (int) (x*y);
    }
}

class Triangle {
    private Point a, b, c;

    public Point getA(){
        return a;
    }
    public Point getB(){
        return b;
    }
    public Point getC(){
        return c;
    }

    public void setA(double x, double y){
        if (a.collinearityPoint(b,c)) {
            System.out.print("Все точки лежат на одной прямой, введите заново!");
        }
        else{
            a.setPoint(x,y);
        }
    }
    public void setB(double x, double y){
        if (a.collinearityPoint(b,c)) {
            System.out.print("Все точки лежат на одной прямой, введите заново!");
        }
        else{
            b.setPoint(x,y);
        }
    }
    public void setC(double x, double y){
        if (a.collinearityPoint(b,c)) {
            System.out.print("Все точки лежат на одной прямой, введите заново!");
        }
        else{
            c.setPoint(x,y);
        }
    }

    public Triangle () {
        Scanner in = new Scanner(System.in);
        boolean err;
        do {
            err = true;
            System.out.print("Введите точку A: ");
            a = new Point();
            System.out.print("Введите точку B: ");
            b = new Point();
            System.out.print("Введите точку C: ");
            c = new Point();
            if (a.collinearityPoint(b,c)) {
                System.out.print("Все точки лежат на одной прямой, введите заново!");
            }
            else{
                err = false;
            }
        }while(err);
    }

    public void setTriangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public void print(){
        System.out.println("Треугольник состоит из 3 точек с координатами:");
        a.print();
        b.print();
        c.print();
    }
    // Нахождение периметра треугольника
    public double perimeter(){
        double AB = this.a.length(this.b);
        double BC = this.b.length(this.c);
        double AC = this.a.length(this.c);
        return AB + BC + AC;
    }
    // Площадь треугольника
    public double area(){
        double p = this.perimeter();
        double AB = this.a.length(this.b);
        double BC = this.b.length(this.c);
        double AC = this.a.length(this.c);
        return Math.sqrt(p*(p-AB)*(p-BC)*(p-AC));
    }

    //Нахождение центр масс треугольника
    public Point centerMass(){
        double x = (a.x + b.x + c.x) / 3;
        double y = (a.y + b.y + c.y) / 3;
        Point M = new Point(x,y);
        return M;
    }

    // Поворот треугольника относительно точки
    public Triangle turn(Point p, int degree){
        double sin = Math.sin(degree * Math.PI / 180);
        double cos = Math.cos(degree * Math.PI / 180);
        Point A = new Point(a.x - p.x,a.y - p.y);
        Point B = new Point(b.x - p.x,b.y - p.y);
        Point C = new Point(c.x - p.x,c.y - p.y);
        A.setPoint(A.x*cos - A.y*sin, A.x*sin + A.y*cos);
        B.setPoint(B.x*cos - B.y*sin, B.x*sin + B.y*cos);
        C.setPoint(C.x*cos - C.y*sin, C.x*sin + C.y*cos);
        A.setPoint(A.x + p.x, A.y + p.y);
        B.setPoint(B.x + p.x, B.y + p.y);
        C.setPoint(C.x + p.x, C.y + p.y);
        this.setTriangle(A,B,C);
        return this;
    }
}

public class ObjectLab {
    public static void main(String[] args) {
        Triangle One = new Triangle();
        One.print();
        System.out.println(One.perimeter());
        System.out.println(One.area());
        Point M = One.centerMass();
        System.out.println("Центр масс до поворота треугольника:");
        M.print();
        One.turn(M, 30);
        System.out.println("Треугольник был повернут:");
        One.print();
        Point M2 = One.centerMass();
        System.out.println("Центр масс после поворота треугольника");
        M2.print();
    }
}
