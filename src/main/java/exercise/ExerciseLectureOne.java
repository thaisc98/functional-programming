package exercise;

import java.util.List;

public class ExerciseLectureOne {

    public static void main(String[] args) {

        // Print only odd numbers from the list.
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        oddNumbers(numbers);

        // print all courses individually.
        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices", "AMS","PCP","Azure","Docker", "Kubernetes");
        printIndividually(courses);

        //print courses containing the word "Spring".
        printWordsSpring(courses);

        //print courses whose name has at least 4 letters.
        printWordsWithFourLetters(courses);

        // print the cubes of odd numbers
        printCubesOfOddNumbers(numbers);

        // print the numbers of characters in each course name
        printNumberOfCharactersCourses(courses);
    }

    private static void oddNumbers(List<Integer> numbers){
        numbers.stream().filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printIndividually(List<String> courses){
        // I know this only can be forEach, but I wanted to use by the stream()
        courses.stream().forEach(System.out::println);
    }

    private static void printWordsSpring(List<String> courses){
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printWordsWithFourLetters(List<String> courses){
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> Math.pow(number,3))
                .forEach(System.out::println);
    }

    private static void printNumberOfCharactersCourses(List<String> courses) {
        courses.stream()
                .map(String::length)
                .forEach(System.out::println);
    }


}
