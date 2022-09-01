package lecture;

import java.util.List;

public class LectureOne {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        printAllNumbersInListStructured(numbers);
//        printAllNumbersInListFunctional(numbers);
//        printEvenNumbersInListStructured(numbers);
//        printAllEvenInListFunctional(numbers);
        printSquareOfEvenInListFunctional(numbers);

    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //how to loop the numbers ?
        //structured
        for(int number: numbers){
            System.out.println(number);
        }
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // what to do ?
        numbers.stream().forEach(LectureOne::print);// method reference
        // simple way
        numbers.stream().forEach(System.out::println);
        //note: // I know this only can be forEach, but I wanted to use by the stream()
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        //how to loop the numbers ?
        //structured
        for(int number: numbers){
            if(number % 2 == 0){
                System.out.println(number);
            }
        }
    }

    private static void print(int number){
        System.out.println(number);
    }

    private static boolean isEven(int number){
        return number % 2 == 0;
    }

    private static void printAllEvenInListFunctional(List<Integer> numbers) {
        // what to do ?
        numbers.stream()
                .filter(LectureOne::isEven) //filter = only allow even numbers
                .forEach(System.out::println); // method reference
        // simple way
        numbers.stream()
                .filter(number -> number % 2 == 0) //lambda expression
                .forEach(System.out::println); // method reference
    }

    private static void printSquareOfEvenInListFunctional(List<Integer> numbers) {
        // what to do ?
        numbers.stream()
                .filter(number -> number % 2 == 0) //lambda expression
                .map(number -> number * number)
                .forEach(System.out::println); // method reference
    }
}
