package lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class LectureFive {
    List<Course> courses = List.of(
            new Course("Spring", "Framework", 98, 20000),
            new Course("Spring Boot", "Framework", 95, 18000),
            new Course("API", "Microservices", 97, 22000),
            new Course("Microservices", "Microservices", 96, 25000),
            new Course("FullStack", "FullStack", 91, 14000),
            new Course("AWS", "Cloud", 92, 21000),
            new Course("Azure", "Cloud", 99, 21000),
            new Course("Docker", "Cloud", 92, 20000),
            new Course("Kubernates", "Cloud", 91, 20000));

    public static void main(String[] args) {

        // Higher Order Functions
        Predicate<Course> reviewScoreGreaterThan95Predicate = createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate = createPredicateWithCutoffReviewScore(90);

        List<String> coursess = List.of("Spring", "Spring boot", "API", "Microservices", "AMS","PCP","Azure","Docker", "Kubernetes");
//        coursess.stream().filter(courses -> courses.length() > 11).map(String::toUpperCase).findFirst();
        coursess.stream()
                .peek(System.out::println)
                .filter(courses -> courses.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();

        // intermediate operations there are all lazy, they are all executed when I executed the terminal operation
        System.out.println(coursess.stream().filter(courses -> courses.length() > 11).map(String::toUpperCase).findFirst());

        // Parallelizing
        // time
        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0,1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - time);

//        coursess.replaceAll( str -> str.toUpperCase());
        List<String> modifyableCourses = new ArrayList<>(coursess);
        modifyableCourses.replaceAll(str -> str.toUpperCase());
        System.out.println(modifyableCourses);
        modifyableCourses.removeIf(course -> course.length() < 6);
        System.out.println(modifyableCourses);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }
}
