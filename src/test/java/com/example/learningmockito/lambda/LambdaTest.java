package com.example.learningmockito.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

    @Test
    public void shouldReturnLettersInUppercase() {
        List<String> letters = Arrays.asList("a","b","c","d");
        List<String> lettersInUpperCase = letters
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Assert.assertEquals("A", lettersInUpperCase.get(0));
        Assert.assertEquals("B", lettersInUpperCase.get(1));
        Assert.assertEquals("C", lettersInUpperCase.get(2));
        Assert.assertEquals("D", lettersInUpperCase.get(3));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> numbersMultiplyByTwo = numbers
                .stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        Assert.assertEquals(new Integer(2), numbersMultiplyByTwo.get(0));
        Assert.assertEquals(new Integer(4), numbersMultiplyByTwo.get(1));
        Assert.assertEquals(new Integer(6), numbersMultiplyByTwo.get(2));
        Assert.assertEquals(new Integer(8), numbersMultiplyByTwo.get(3));


        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        memberNames
                .stream()
                .filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<String> sortedNames = memberNames
                .stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(sortedNames);



        //TODO: Testing Stream.match operation

        boolean matchedResult = memberNames
                .stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        matchedResult = memberNames
                .stream()
                .allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        matchedResult = memberNames
                .stream()
                .noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        //TODO: Testing Stream.count operation

        long totalMatched = memberNames
                .stream()
                .filter((s) -> s.startsWith("A"))
                .count();
        System.out.println(totalMatched);

        //TODO: Testing Stream.findFirst operation

        String selectedName = memberNames
                .stream()
                .filter(s -> s.startsWith("X"))
                .findFirst()
                .orElse(null);
        System.out.println(selectedName);
    }
}
