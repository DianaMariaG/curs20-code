package ro.fasttrackit.curs20;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingMain {
    public static void main(String[] args) {
       var persons = List.of(
               new Person("Marcel", "Oradea", 33),
               new Person("Ioan", "Cluj", 23),
               new Person("Daria", "Brasov", 42),
               new Person("Otilia", "Oradea", 13),
               new Person("Mihai", "Brasov", 22),
               new Person("Cornel", "Bucuresti", 25)
       );

       Map<String, Integer> result = persons.stream()
               .collect(Collectors.toMap(person -> person.name(), person ->person.age()));
        System.out.println(result);

        Map<String, String> collect = persons.stream()
                .collect(Collectors.toMap(Person::city, Person::name, (name1, name2) ->name1 + "," +name2 ));
        System.out.println(collect);

        Map<String, List<Person>> groupByCity = persons.stream()
                .collect(Collectors.groupingBy(Person::city));
        System.out.println(groupByCity);

        System.out.println(persons.stream()
                .collect(Collectors.groupingBy(Person::city, Collectors.mapping(person -> person.name(),Collectors.toList())))); //grupeaza dupa oras, iar valorile le grupeaza dupa name si pe pune intr-o lista
    }
}
record Person(String name, String city, int age) {

}
