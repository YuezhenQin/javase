package SortingAlgorithm;


import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int rank;

    public Person(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }


    public static boolean isTop10(Person person) {
        return person.getRank() <= 10;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static List<Person> filterPeople(List<Person> people, Predicate<Person> pred) {
        List<Person> result = new ArrayList<>();
        for (Person person: people) {
            if (pred.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    /* 子类对父类覆盖（重载）, 一个类内重写 */
    @Override
//    public boolean equals(Object another) {
//        /* 一个空对象 */
//        if (another == null) return false;
//        /* 同一个对象 */
//        if (this == another) return true;
//        /* 不同类的对象*/
//        if (this.getClass() != another.getClass()) return false;
//
//
//        /* equals() 判断逻辑 */
//        Person person = (Person) another;
//        return this.name.toLowerCase().equals(person.name.toLowerCase());
//    }

    public boolean equals(Object o) {
        if (this == o) return true; //引用地址相同
        if (o == null || this.getClass() != o.getClass()) return false; //空或不同类

        Person another = (Person) o;
        return this.rank == another.rank && this.name.toLowerCase().equals(another.name.toLowerCase());
        //Reflexive
        //Symmetric
        //Transitive
        //Consistent
        //NOT null
    }

    /* 具体如何比较由类的设计者完成 */
    @Override
    public int compareTo(Person other) {
//        if (this.rank < another.rank) {
//            return -1;
//        } else if (this.rank == another.rank) {
//            return 0;
//        } else {
//            return 1;
//        }
        return this.rank - other.rank; /* 从小到大 */
    }

    @Override
    public String toString() {
        return String.format("Person(name:%s, rank:%d)", name, rank);
    }

    @Override
    public int hashCode() {
        int B = 10;
        int hash = 0;
        hash = hash * B + name.toLowerCase().hashCode();
        hash = hash * B + rank;
        return hash;
    }



    public static void main(String[] args) {
        Array<Person> people = new Array(10);
        people.addLast(new Person("Socrates", 1));
        people.addLast(new Person("Plato", 2));
        people.addLast(new Person("Aristotle", 3));
        System.out.println(people);
    }
}
