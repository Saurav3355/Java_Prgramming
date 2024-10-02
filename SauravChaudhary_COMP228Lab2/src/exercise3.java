public class exercise3 {

    public static double area(double length, double width) {
        return length * width;
    }

    public static double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static double area(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        double rectangleArea = area(10.0, 5.0);
        System.out.println("Area of the rectangle: " + rectangleArea);

        double circleArea = area(7.0);
        System.out.println("Area of the circle: " + circleArea);

        double triangleArea = area(8.0, 6.0, true);
        System.out.println("Area of the triangle: " + triangleArea);
    }
}
