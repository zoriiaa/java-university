package lecture7;

@interface CourseInfo {
    String courseName();
    int year();
}

@CourseInfo(courseName = "Java Programming", year = 2024)
class UniversityCourse {
}

@Deprecated
class OldCourse {
    @Deprecated
    public String getCourseName() {
        return "Old Java Course";
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        UniversityCourse course = new UniversityCourse();
        OldCourse oldCourse = new OldCourse();
        System.out.println("Назва курсу: " + oldCourse.getCourseName());
    }
}

