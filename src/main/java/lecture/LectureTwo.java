package lecture;

import java.util.List;
import java.util.stream.Collectors;

public class LectureTwo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListStructured(numbers);
        System.out.println(sum);
        int sumFunctional = addListFunctional(numbers);
        System.out.println(sumFunctional);

        List<Integer> squaredNumbers = squaredList(numbers);
        System.out.println(squaredNumbers);

        // sorted and distinct
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    private static int sum(int aggregate, int nextNumber){
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        // for return a single value
        // combine them into one result -> one value
//        return numbers.stream().reduce(0, LectureTwo::sum);
        // simple way
//        return numbers.stream().reduce(0, (x,y) -> x + y );
        // another simple way
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        //how to loop?
        // how to store the sum?
        int sum = 0;
        for(int number: numbers){
            sum += number;
        }
        return sum;
    }

    private static List<Integer> squaredList(List<Integer> numbers) {
        // 1, 5, 6
        // 1, 25, 36
        // result: [1,25,36]
        return numbers.stream().map(number -> number * number).collect(Collectors.toList());

    }

}

