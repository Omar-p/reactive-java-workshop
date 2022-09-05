package io.javabrains.reactiveworkshop;

import java.util.Set;
import java.util.stream.Collectors;

public class Exercise1 {

  public static void main(String[] args) {


    System.out.println("Print all numbers in the intNumbersStream stream");
    StreamSources.intNumbersStream()
        .forEach(System.out::println);


    System.out.println("\nPrint numbers from intNumbersStream that are less than 5");
    StreamSources.intNumbersStream()
        .filter(num -> num < 5)
        .forEach(System.out::println);

    System.out.println("\nPrint the second and third numbers in intNumbersStream that's greater than 5");
    StreamSources.intNumbersStream()
        .filter(num -> num > 5)
        .skip(1)
        .limit(2)
        .forEach(System.out::println);


    System.out.println("""
        \nPrint the first number in intNumbersStream that's greater than 5.
        If nothing is found, print -1"""
    );
    StreamSources.intNumbersStream()
        .filter(num -> num > 5)
        .findFirst()
        .ifPresentOrElse(System.out::println, () -> System.out.println(-1));


    System.out.println("\nPrint first names of all users in userStream");
    StreamSources.userStream()
        .map(User::getFirstName)
        .forEach(System.out::println);

    System.out.println("\nPrint first names in userStream for users that have IDs from number stream");
    final Set<Integer> ids = StreamSources.intNumbersStream()
        .collect(Collectors.toUnmodifiableSet());
    StreamSources.userStream()
        .filter(user -> ids.contains(user.getId()))
        .map(User::getFirstName)
        .forEach(System.out::println);
  }

}
