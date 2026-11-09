package lecture7;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class QuadraticEquation {
    public static void main(String[] args) {
        double a = 1, b = -3, c = 2;
        double discriminant = pow(b, 2) - 4 * a * c;

        double x1 = (-b + sqrt(discriminant)) / (2 * a);
        double x2 = (-b - sqrt(discriminant)) / (2 * a);
        System.out.println("Корені рівняння: x1 = " + x1 + ", x2 = " + x2);
    }
}
