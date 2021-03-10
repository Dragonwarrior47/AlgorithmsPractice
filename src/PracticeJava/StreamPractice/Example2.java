package PracticeJava.StreamPractice;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Example2 {
    public static Stream<String> letters(String s)
    {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            result.add(s.substring(i, i + 1));
        return result.stream();
    }
    public static void main(String args[]) throws  java.io.IOException {
        String contents = new String(Files.readAllBytes(Paths.get("/home/delhivery/workspace/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Optional<String> startsWithQ = words.stream().filter(s -> s.startsWith("")).findFirst();
        Optional<String> startsWithZ = words.stream().filter(s->s.startsWith("z")).findAny();
        System.out.println(String.format("Starts with Q value:%s", startsWithZ));
    }
}
