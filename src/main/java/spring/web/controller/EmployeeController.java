package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.web.Employee;
import spring.web.backend.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/{id}")
    public ModelAndView findEmployeeById(@PathVariable("id") long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ModelAndView("employee", "employee", employee);
    }
}