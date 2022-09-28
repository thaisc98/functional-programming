package lecture;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class LectureSix {
    public static void main(String[] args) throws IOException {

        //unique words
       Files.lines(Paths.get("file.txt"))
               .map(str -> str.split(" "))
               .flatMap(Arrays::stream)
               .distinct()
               .sorted()
               .forEach(System.out::println);


        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
