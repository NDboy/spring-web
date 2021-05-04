package spring.web.backend;

import org.springframework.stereotype.Service;
import spring.web.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeService {

    private AtomicInteger id = new AtomicInteger();

    private List<Employee> emps = IntStream.range(1,15)
            .mapToObj(i -> new Employee(id.incrementAndGet(), "John Doe 0" + i))
            .collect(Collectors.toList());

    private List<Employee> employees = Collections.synchronizedList(emps);


    public void saveEmployee(String name) {
        employees.add(new Employee(id.incrementAndGet(), name));
    }

    public List<Employee> listEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee findEmployeeById(long id) {
        return employees.stream()
                .filter(e -> id == e.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find employee " + id));
    }

    public void updateEmployee(Employee employee) {
        Employee employeeToModify = findEmployeeById(employee.getId());
        employeeToModify.setName(employee.getName());
    }

    public void reset() {
        id.set(0);
        employees.clear();
    }

}