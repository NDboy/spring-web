package spring.web.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.web.Employee;
import spring.web.backend.EmployeeService;

import java.util.Locale;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    private MessageSource messageSource;

    public EmployeeController(EmployeeService employeeService, MessageSource messageSource) {
        this.employeeService = employeeService;
        this.messageSource = messageSource;
    }

    @ModelAttribute
    public Employee employee(@PathVariable("id") long id) {
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findEmployeeById(@PathVariable("id") long id) {
        return new ModelAndView("employee");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes, Locale locale) {
        employeeService.updateEmployee(employee);
        String message = messageSource.getMessage("employee.modified", new Object[]{employee.getName()}, locale);

        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
