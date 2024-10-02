public class exercise3 {

    // Method 1: Calculating area of a rectangle
    public static double area(double length, double width) {
        return length * width;
    }

    // Method 2: Calculating area of a circle
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }

    // Method 3: Calculating area of a triangle 
    public static double area(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        // Calling the first overloaded method (rectangle area)
        double rectangleArea = area(10.0, 5.0);
        System.out.println("Area of the rectangle: " + rectangleArea);

        // Calling the second overloaded method (circle area)
        double circleArea = area(7.0);
        System.out.println("Area of the circle: " + circleArea);

        // Calling the third overloaded method (triangle area)
        double triangleArea = area(8.0, 6.0, true);
        System.out.println("Area of the triangle: " + triangleArea);
    }
}
