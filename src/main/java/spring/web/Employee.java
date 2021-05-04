package spring.web;

public class Employee {

    private int id;
    private String name;
    private static int counter;

    public Employee(String name) {
        counter++;
        id = counter;
        this.name = name;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
