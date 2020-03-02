import java.util.Scanner;
// описываем отдельный новый класс
class Circle {
    // свойства класса
    public double x; // абсцисса центра
    public double y; // ордината центра
    public double r; // радиус
    // методы класса
    // выводит на экран параметры окружности
    public Circle(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите точку x: ");
        x = in.nextDouble();
        System.out.print("Введите точку y: ");
        y = in.nextDouble();
        System.out.print("Введите радиус: ");
        r = in.nextDouble();
    }
    public void printCircle() {
        System.out.println("Окружность с центром ("+x+";"+y+") и радиусом "+r);
    }
    // перемещает центр, движение окружности
    public void moveCircle(double a, double b) {
        x = x + a;
        y = y + b;
    }
    // масштабируем, выполняем преобразование подобия с коэффициентом k
    public void zoomCircle(double k) {
        r = r * k;
    }
    public double lengthCircle() {
        double length = 2 * Math.PI * r;
        return length;
    }
    public void changeCenter() {
        double max = 99;
        double min = -99;
        x = (Math.random() * ++max) + min;
        y = (Math.random() * ++max) + min;
    }
    public double lengthCenter(Circle cir){
        double len = Math.sqrt((x-cir.x)*(x-cir.x)+(y-cir.y)*(y-cir.y));
        return len;
    }

    public void touchCircle(Circle cir) {
        double len = this.lengthCenter(cir);
        if (len > r + cir.r) {
            System.out.println("Не касаются");
        }
        else {
            System.out.println("Касаются");
        }
    }
}

// описываем основной класс, содержащий метод main
public class Main {
    public static void main(String[] args) {
        // Создаём объект (окружность класса Circle), у неё будет нулевой
        // радиус и центр в (0.0;0.0), поскольку все свойства получат
        // значения по умолчанию
        Circle o1 = new Circle();
        // выводим на экран параметры окружности
        o1.printCircle();
        // Меняем абсциссу центра, обращааясь к свойству x
        o1.x = 3;
        // Меняем радиус, обращааясь к свойству r
        o1.r = 12.3;
        // выводим на экран обновлённые параметры окружности
        o1.printCircle();
        // Создаём другой объект того же класса
        Circle o2 = new Circle();
        o2.r = 3.14;
        o2.zoomCircle(1.66);
        o2.printCircle(); // Окружность с центром (0.0;0.0) и радиусом 5.2124
        System.out.println(o2.lengthCircle());
        o2.changeCenter();
        o2.printCircle();
        Circle o3 = o1;
        System.out.println(o1.lengthCenter(o2));
        System.out.println(o2.lengthCenter(o1));
        o1.touchCircle(o2);
        o1.touchCircle(o3);
    }
}
