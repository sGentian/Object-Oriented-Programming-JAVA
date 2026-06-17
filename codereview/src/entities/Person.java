package entities;

public class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public Person (Person person){
        this.name = person.name;

    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {

        return this.name.compareTo(o.name);
    }
}

