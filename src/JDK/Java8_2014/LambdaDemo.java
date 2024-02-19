package JDK.Java8_2014;

import 排序.Person;

import java.util.ArrayList;
import java.util.List;

import static 排序.Person.filterPeople;

public class LambdaDemo {



    public static void main(String[] args) {
        Person p1 = new Person("Socrates", 1);
        Person p2 = new Person("Plato", 99);
        Person p3 = new Person("Aristotle", 10);
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        List<Person> result = filterPeople(people, Person::isTop10);
        System.out.println(result);
    }
}
