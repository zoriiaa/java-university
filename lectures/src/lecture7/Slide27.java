package lecture7;

public class Slide27 {
    public static void main(String[] args) {
        Double mathA, mathB, mathC;

        mathA = 85.7;
        mathB = 92.5;
        mathC = 88.3;

        Double averageGrade = (mathA + mathB + mathC) / 3;
        System.out.println("Середній бал (Double): " + averageGrade);

        double finalGrade = (85.7 + 92.5 + 88.3) / 3;
        System.out.println("Середній бал курсу: " + finalGrade);
    }
}
