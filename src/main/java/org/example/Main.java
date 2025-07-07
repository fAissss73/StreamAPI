package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.max;
import static java.util.stream.Collectors.toMap;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,-2,-4,-5));
        ArrayList<Integer> numbersx10 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90,-20,-40,-50));
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Аптека","Апельсин","Больница","автомобиль","Луна","Аптека","аптека","Автомобиль"));
        ArrayList<Double> numberDouble = new ArrayList<>(Arrays.asList(1.1, 2.2, 4.2,55.1));

        List<Person> people = List.of(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie")
        );


        System.out.println(sumNumber(numbers));
        System.out.println();
        convertStringToNumbers(strings).forEach(System.out::println);
        System.out.println();
        System.out.println(filterStringWithUpperCase(strings));
        System.out.println();
        findMaxNumber(numbers).forEach(System.out::println);
        System.out.println();
        checkStringOnDublicate(strings).forEach(System.out::println);
        System.out.println();
        System.out.println(checkNumberOnNegative(numbers));
        System.out.println();
        joinListNumber(numbers, numbersx10).forEach(System.out::println);
        System.out.println();
        groupList(strings);
        System.out.println();
        System.out.println(searchAvgDoubleNumbers(numberDouble));
        System.out.println();
        sortedStringDesc(strings).forEach(System.out::println);
        System.out.println();
        powNumbers(numbers).forEach(System.out::println);
        System.out.println();
        System.out.println(findFirstElementMoreTen(numbers));
        System.out.println();
        splitList(numbers).forEach(System.out::println);
        System.out.println();
        generateListName(people).forEach(System.out::println);

    }

    public static int sumNumber(ArrayList<Integer> numbers) {
        int sumIntStream  = numbers.stream().filter(x -> (x % 2 == 0) && (x>0)).mapToInt(Integer::intValue).sum();
        return sumIntStream;
    }

    public static List<Integer> convertStringToNumbers(ArrayList<String> strings){
        return strings.stream().map(String::length).collect(Collectors.toList());
    }

    public static String filterStringWithUpperCase(ArrayList<String> strings){
        return strings.stream().filter(x-> x.startsWith("А")).collect(Collectors.joining(", "));
    }

    public static List<Integer> findMaxNumber (ArrayList<Integer> numbers){
        return numbers.stream().max((o1, o2) -> o1 - o2).stream().collect(Collectors.toList());

    }

    public static List<String> checkStringOnDublicate (ArrayList<String> strings){
        return strings.stream().distinct().collect(Collectors.toList());
    }

    public static Boolean checkNumberOnNegative (ArrayList<Integer> numbers){
        boolean result = numbers.stream().anyMatch(x-> x <0);
        return result;
    }


    public static List<Integer> joinListNumber (ArrayList<Integer> numbers, ArrayList<Integer> numbers1){
        return Stream.concat(numbers.stream(), numbers1.stream()).collect(Collectors.toList());
    }

    public static void groupList (ArrayList<String> strings){
        Map<Character, List<String>> groupedStrings = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        groupedStrings.forEach((letter, list) -> System.out.println(letter + ": " + list));
    }

    public static Double searchAvgDoubleNumbers (ArrayList<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    public static List<String> sortedStringDesc (ArrayList<String> strings){
        return strings.stream().sorted(((o1, o2) -> o2.length() - o1.length())).collect(Collectors.toList());
    }

    public static List<Integer> powNumbers(ArrayList<Integer> numbers) {
        return numbers.stream().map(x-> x * x).collect(Collectors.toList());
    }

    public static int findFirstElementMoreTen(ArrayList<Integer> numbers){

        int element = 0;

        try{
            return element = numbers.stream().filter(x-> x > 10).findFirst().get();
        }
        catch (Exception e){
            System.out.println("Элемент по условию не найден");
        }
        return element;
    }

    public static List<List<Integer>> splitList (ArrayList<Integer> numbers) {
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        List<Integer> evenNumber = partitionedNumbers.get(true);
        List<Integer> notEvenNumber = partitionedNumbers.get(false);

        List<List<Integer>> result = new ArrayList<>();
        result.add(evenNumber);
        result.add(notEvenNumber);

        return result;
    }

    public static List<String> generateListName (List<Person> people){

        return people.stream().map(Person::getName).collect(Collectors.toList());
    }

}

