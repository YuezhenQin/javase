public class Person implements Comparable<Person> { /* 1.4 */
    private String name;
    private int rank;

    public Person(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    /* 子类对父类覆盖（重载）, 一个类内重写 */
    @Override
    public boolean equals(Object another) {
        /* 是否是不同类的对象*/
        if (this.getClass() != another.getClass()) return false;
        /* 是否是一个空对象 */
        if (another == null) return false;
        /* 是否是同一个对象 */
        if (this == another) return true;

        /* equals() 判断逻辑 */
        Person person = (Person) another;
        return this.name.toLowerCase().equals(person.name.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Person(name:%s, rank:%d)", name, rank);
    }

    /* 具体如何比较由类的设计者完成 */
    @Override
    public int compareTo(Person another) {
//        if (this.rank < another.rank) {
//            return -1;
//        } else if (this.rank == another.rank) {
//            return 0;
//        } else {
//            return 1;
//        }
        return this.rank - another.rank; /* 从小到大 */
    }

    public static void main(String[] args) {
        Array<Person> people = new Array(10);
        people.addLast(new Person("Socrates", 1));
        people.addLast(new Person("Plato", 2));
        people.addLast(new Person("Aristotle", 3));
        System.out.println(people);
    }
}
