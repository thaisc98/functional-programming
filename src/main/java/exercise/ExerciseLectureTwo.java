package exercise;

import java.util.List;
import java.util.stream.Collectors;

public class ExerciseLectureTwo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        // Square every number in a list and find the sum of squares
        int sumSquare = sumOfSquareList(numbers);
        System.out.println(sumSquare);
        // cube every number in a list and find the sum of cubes
        int sumCube = sumOfCubesList(numbers);
        System.out.println(sumCube);
        // find sum of odd numbers in a list
        int sumOdd = sumOddNumbersList(numbers);
        System.out.println(sumOdd);
        // create a list with even numbers filtered from the numbers list
        List<Integer> listOfEvenNumbers = createListOfEvenNumbers(numbers);
        System.out.println(listOfEvenNumbers);
        //create a list with lengths of all courses titles.
        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices", "AMS","PCP","Azure","Docker", "Kubernetes");
        List<Integer> listOfLengthCourses = createListLengthCourses(courses);
        System.out.println(listOfLengthCourses);

    }

    private static int sumOfSquareList(List<Integer> numbers) {
        return numbers.stream().map(x -> (x * x)).reduce(0, Integer::sum);
    }

    private static int sumOfCubesList(List<Integer> numbers) {
        return numbers.stream().map(x -> (x * x * x)).reduce(0, Integer::sum);
    }

    private static int sumOddNumbersList(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum);
    }

    private static List<Integer> createListOfEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> createListLengthCourses(List<String> courses) {
        return courses.stream().map(String::length).collect(Collectors.toList());
    }

}
