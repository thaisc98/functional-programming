package lecture;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}


public class LectureFour {

    public static void main(String[] args) {
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

        //allMatch, noneMatch, anyMatch
        //allMatch : would return true, if every element in this stream matches the condition.
        // noneMatch :  will return true, if no elements in ths stream matches the condition specified.
        // anyMatch : return true if at least one element in the stream matches that specific condition.

        // All the courses have a review score greater than 90
        Predicate<Course> reviewScoreGreaterThan95Predicate =
                course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate =
                course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate =
                course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        // you can use comparing or comparingInt in this case the correct one should be comparingInt.
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsAndNoOfReview
                = Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview).collect(Collectors.toList()));

        // no completed list -> limit
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview).limit(5).collect(Collectors.toList()));
        // top three result skip
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview).skip(3).collect(Collectors.toList()));
        // skip 3 and print only 5
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReview).skip(3).limit(5).collect(Collectors.toList()));

        System.out.println(courses);
        //take all element  until one element not specify the criteria.
        System.out.println(courses.stream()
                                .takeWhile(course -> course.getReviewScore() >= 95)
                                .collect(Collectors.toList()));

        // as long this criteria es true will keep droping the element
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList()));

        // max course of this criteria comparingByNoOfStudentsAndNoOfReview the returns the last element in the list
        System.out.println("- max course of this criteria comparingByNoOfStudentsAndNoOfReview");
        System.out.println(courses.stream().max(comparingByNoOfStudentsAndNoOfReview));

        System.out.println("- min course of this criteria comparingByNoOfStudentsAndNoOfReview");
        System.out.println(courses.stream().min(comparingByNoOfStudentsAndNoOfReview).orElse(new Course("Kubernates", "Cloud", 91, 20000)));

        System.out.println("- filtering by the reviewScore less than 90 the first min course of this criteria comparingByNoOfStudentsAndNoOfReview");
        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReview).orElse(new Course("Kubernates", "Cloud", 91, 20000)));

        // find the first element which a certain criteria
        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .findFirst());
        //empty

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findFirst());
        // 'spring' course

        // any of te elements with match this criteria.
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findAny());
        // 'spring' course

        //sum having reviews greater than 95
        System.out.println("total numbers of students having reviews greater than 95");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents).sum()); // primitive method not boxing and unboxing


        //sum having reviews greater than 95
        System.out.println("average numbers of courses having reviews greater than 95");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents).average()); // primitive method not boxing and unboxing
        //OptionalDouble[22000.0]

        System.out.println("counter numbers of courses having reviews greater than 95");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents).count()); // primitive method not boxing and unboxing
        //OptionalDouble[22000.0]

        System.out.println("- max value numbers of students having reviews greater than 95");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents).max()); // primitive method not boxing and unboxing
        //OptionalInt[25000] microservices

        // group the courses by category
        System.out.println("- Group the course sby category");
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        ///{
        // Cloud=[Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000},
        // Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000},
        // Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000},
        // Course{name='Kubernates', category='Cloud', reviewScore=91, noOfStudents=20000}],
        // FullStack=[Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}],
        // Microservices=[Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000},
        //                 Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}],
        //    Framework=[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000},
        //                Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}]}

        System.out.println("- counter of each category");
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}
        // high's reviews
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        // map the name of the course only
        System.out.println("- mapping the name of each category grouped");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList()))));

        //Console
        //for transofrm to a list need to be boxed the intStream.
        IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());

        //Operations with long values
        LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);

        List<String> coursesss = List.of("Spring", "Spring boot", "API", "Microservices", "AMS","PCP","Azure","Docker", "Kubernetes");
        coursesss.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());

        List<String> coursesss2 = List.of("Spring", "Spring boot", "API", "Microservices", "AMS","PCP","Azure","Docker", "Kubernetes");
        coursesss.stream().flatMap(course -> coursesss2.stream().map(course2 -> List.of(coursesss,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());

        coursesss.stream().flatMap(course -> coursesss2.stream().filter(course2 -> course2.length() == course.length()).
                map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());
    }

}
