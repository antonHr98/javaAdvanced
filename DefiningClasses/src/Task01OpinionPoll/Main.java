package Task01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Create a Person class with two fields String name and int age. Write a program that reads from the console N lines
 * of personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputsCount = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for(int i=0;i<inputsCount;i++){
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(person->person.getAge()>30)
                .sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        scanner.close();
    }
}
