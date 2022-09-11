package lecture;

import java.util.List;
import java.util.Random;
import java.util.function.*;

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
        System.out.println("Supplier");

        // dosen't get any input but return a obj
        Supplier<Integer> randomInteger = () -> {
            //random number
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomInteger.get());

        // Offers to elements at the same time, and returns the values of the same type.
        BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x + y;

        // take one parameter return only one value  with the same type
        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(10));

        //Interfaces
        // Use biPredicate whe you have two inputs in the lambda expression
        // and want to return a boolean
        BiPredicate<Integer,String> biPredicate = (number,str) -> {
            return number < 10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(5,"Helloo"));

        //BiFunction
        BiFunction<Integer,String, String> biFunction = (number,str) -> {
            return number + " " +  str;
        };
        System.out.println(biFunction.apply(5,"Helloo"));

        //BiConsumir two inputs and not return anything
        BiConsumer<Integer, String> biConsumer = (number,str2) ->{
            System.out.println(number);
            System.out.println(str2);
        };

        biConsumer.accept(5, "Hello");

        //Using primitives functional interfaces
        //IntBinaryOperator
        //I can do this? why use IntBinaryOperator?
        BinaryOperator<Integer> sumBinaryOperator2 = (x,y) -> x + y;
        // Wrapper class: boxing and unboxing and its inefficient.
        // Primitives
        IntBinaryOperator intBinaryOperator = (x,y) -> x + y;


        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator

        //Long, Double Int

        // Method References
        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices", "AMS","PCP","Azure","Docker", "Kubernetes");
        courses.stream()
                .map(String::toUpperCase) // method which is on the object
                .forEach(System.out::println);

        Supplier<String> supplier = String::new; // this is called a constructor reference
        // to use this to create new objects.

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicated) {
        numbers.stream()
                .filter(predicated)
                .forEach(System.out::println);
    }


}
