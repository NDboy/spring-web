package spring.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Employee {

    private long id;

    private String name;

    public Employee(String name) {
        this.name = name;
    }


    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
