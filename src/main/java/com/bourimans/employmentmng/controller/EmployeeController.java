package com.bourimans.employmentmng.controller;

import com.bourimans.employmentmng.model.Departement;
import com.bourimans.employmentmng.model.Employee;
import com.bourimans.employmentmng.repository.DepartementRepository;
import com.bourimans.employmentmng.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
private DepartementRepository departementRepository;
    private IEmployeeService employeeService;
@Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    Departement passdepartement ;
    @GetMapping("/")
    public String ViewHomePage(Model model){
        model.addAttribute("listOfEmployees",employeeService.getALLEmployee());
        return "index";
    }
    @GetMapping("/AddEmployeeForm")
    public String AddEmployeeForm(Employee e, Model model){
     List<Departement> dept_list=departementRepository.LoadDeptList();
     model.addAttribute("deptList",dept_list);
    return "newEmployeeForm";
    }
    @PostMapping("/addEmployee")
    public String AddEmployee(@Valid Employee e, Errors errors,Model model) {
        if (errors.hasErrors()) {
            System.out.println("There are errors");
            return "newEmployeeForm";
        } else {
            model.addAttribute("message","Added successfully");
            e.setDepartement(passdepartement);
            employeeService.addEmployee(e);
            return "redirect:/";
        }
    }
    @GetMapping("/showEmployeeUpdateForm/{id}")
    public String showEmployeeUpdateView(@PathVariable(value = "id") long id,Model model){
    Employee employee = employeeService.getEmployeeByID(id);
    passdepartement = employee.getDepartement();
  //  System.out.println("This fk"+employee.getDepartement().getId());
    model.addAttribute("employee",employee);
    return "updateEmployeeForm";
    }
@GetMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable(value = "id")long id){
    employeeService.deleteEmployeeById(id);
    return "redirect:/";
}
}
