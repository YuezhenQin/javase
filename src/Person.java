import 排序.Array;

public class Person implements Comparable<Person> {
    private String name;
    private int rank;

    public Person(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    /* 不同类子类对父类覆盖（重载）, 一个类内重写 */
    @Override
    public boolean equals(Object another) {
        /* 不同类的对象*/
        if (this.getClass() != another.getClass()) return false;
        /* 一个空对象 */
        if (another == null) return false;
        /* 同一个对象 */
        if (this == another) return true;

        /* equals() 判断逻辑 */
        Person person = (Person) another;
        return this.name.toLowerCase().equals(person.name.toLowerCase());
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


    public static void main(String[] args) {
        Array<Person> people = new Array(10);
        people.addLast(new Person("Socrates", 1));
        people.addLast(new Person("Plato", 2));
        people.addLast(new Person("Aristotle", 3));
        System.out.println(people);

        ArrayReviewE<Person> arr = new ArrayReviewE<>(10);
        arr.addFirst(new Person("A", 1));
        arr.addFirst(new Person("B", 2));
        arr.addFirst(new Person("C", 3));
        arr.addFirst(new Person("D", 4));
        arr.addFirst(new Person("E", 5));
        System.out.println(arr);
        arr.add(1, new Person("X", 10));
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
    }
}
