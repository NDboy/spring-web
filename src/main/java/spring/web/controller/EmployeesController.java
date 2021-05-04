package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.web.Employee;
import spring.web.backend.EmployeeService;

import java.util.List;

@Controller
public class EmployeesController {

    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    @RequestMapping("/")
//    public ModelAndView listEmployees() {
//        return new ModelAndView("index",
//                "message", "Hello Thymeleaf!");
//    }

//    @RequestMapping("/")
//    public ModelAndView listEmployees() {
//        return new ModelAndView("index",
//                "employees", List.of(new Employee("John Doe"), new Employee("Jane Doe")));
//    }

    @RequestMapping("/")
    public ModelAndView listEmployees() {
        return new ModelAndView("index",
                "employees", employeeService.listEmployees());
    }





}
