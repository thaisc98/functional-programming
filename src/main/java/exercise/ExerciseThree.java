package exercise;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExerciseThree {


    public static void main(String[] args) {

        // Find the functional interface behind the second argument of reduce method.
        // Create an implementation for the functional Interface
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        BinaryOperator<Integer> sumBinaryOperator =  Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>(){

            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };

        // same
        numbers.stream().reduce(0, sumBinaryOperator);

        numbers.stream().reduce(0, sumBinaryOperator2);


        // do behavior parameterization for mapping logic.
         List<Integer> squaredNumber = mapAndCreateList(numbers, x -> x * x);
         List<Integer> cubedNumber = mapAndCreateList(numbers, x -> x * x * x);

         List<Integer> doubledNumbers = mapAndCreateList(numbers, x -> x + x);
        System.out.println(doubledNumbers);
    }

    private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mapped) {
        return numbers.stream()
                .map(mapped)
                .collect(Collectors.toList());
    }
}
