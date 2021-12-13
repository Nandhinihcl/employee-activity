package com.example.employeeactivity.controller;

import com.example.employeeactivity.dao.Employee;
import com.example.employeeactivity.dao.EmployeeCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeCRUD employeeCRUD;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addEmployee(@RequestBody com.example.employeeactivity.pojo.Employee employee) {
        System.out.println("Request received to save employee with " + employee.getName());
        Employee employeeDAO = new Employee();
        employeeDAO.createDAOFromPojo(employee);
        try {
            employeeCRUD.save(employeeDAO);
        } catch (Exception e) {
            System.out.println("Employee saved successfully");
            return "Failed to save employee details";
        }
        return "Employee Details Added successfully";
    }

    @GetMapping(path = "")
    public @ResponseBody
    Iterable<com.example.employeeactivity.pojo.Employee> getAllEmployees() {
        System.out.println("Request made to retrieve all employees");
        List<com.example.employeeactivity.pojo.Employee> employeeList = new ArrayList();
        try {
            Iterable<Employee> daos = employeeCRUD.findAll();
            for (Employee emp : daos) {
                employeeList.add(emp.getPojo());
            }
        } catch (Exception e) {
            System.out.println("Failed to fetch employee info");
        }
        return employeeList;
    }

    @GetMapping(path = "/{code}")
    public @ResponseBody
    com.example.employeeactivity.pojo.Employee getEmployeeByCode(@PathVariable Integer code) {
        System.out.println("Request made to retrieve with employee code " + code);

        try {
            Employee dao = employeeCRUD.findByCode(code);
            return dao.getPojo();
        } catch (Exception e) {
            System.out.println("Failed to fetch employee info");
        }
        return null;
    }

    @PatchMapping(path = "edit")
    public @ResponseBody
    String editEmployee(@RequestBody com.example.employeeactivity.pojo.Employee employee) {
        System.out.println("Edit Request received for " + employee.getName());
        try {
            Employee emp = employeeCRUD.findByCode(employee.getCode());
            emp.createDAOFromPojo(employee);
            employeeCRUD.save(emp);
        } catch (Exception e) {
            System.out.println("Unable to edit employee details");
        }
        return "Employee Details edited successfully";
    }
}
