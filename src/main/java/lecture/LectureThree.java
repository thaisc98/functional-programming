package lecture;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LectureThree {

    /**
     * Functional interfaces
     * Behavior Parameterization
     */
    public static void main(String[] args) {

        /* START Functional interfaces **/
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicated = x -> x % 2 == 0;

        // behind of lambda expression
        Predicate<Integer> isEvenPredicated2 = new Predicate<Integer>(){
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Function<Integer, Integer> squareFunction = x -> x * x;

        // behind of lambda expression
        Function<Integer, Integer> squareFunction2 = new Function<Integer,Integer>(){

            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> systemOutConsumer = System.out::println;

        // behind of lambda expression
        Consumer<Integer> systemOutConsumer2 = new Consumer<Integer>() {

            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicated2)
                .map(squareFunction2)
                .forEach(systemOutConsumer2);
        System.out.println("end functional interfaces");
        /* END Functional interfaces **/

        /* Behavior Parameterization **/
        System.out.println("start behavior parameterization");
        Predicate<Integer> evenPredicated = x -> x % 2 == 0;

        System.out.println("even predicated");
        numbers.stream()
                .filter(evenPredicated)
                .forEach(System.out::println);

        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        System.out.println("odd predicated");
        numbers.stream()
                .filter(oddPredicate)
                .forEach(System.out::println);

        System.out.println("behavioral parameterization of even");
        // even
        filterAndPrint(numbers, x -> x % 2 == 0);

        System.out.println("behavioral parameterization of odd");
        //odd
        filterAndPrint(numbers,  x -> x % 2 != 0);

        System.out.println("behavioral parameterization of multiples of three");
        // passing the logic of the method as an argument
        // passing the behavior of the method as an argument
        filterAndPrint(numbers,  x -> x % 3 == 0);

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicated) {
        numbers.stream()
                .filter(predicated)
                .forEach(System.out::println);
    }


}
