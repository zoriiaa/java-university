package lecture7;

class Course {
}

class OnlineCourse extends Course {
}

public class InstanceOfExample {
    public static void main(String[] args) {
        Course course = new OnlineCourse();

        if (course instanceof OnlineCourse) {
            System.out.println("Це онлайн-курс.");
        } else {
            System.out.println("Це не онлайн-курс.");
        }
    }
}

