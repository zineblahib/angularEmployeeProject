package com.example.employeemanager;


import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployees(){
        List<Employee> employees= employeeService.findAllEmployee();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") Long id){
        Employee employees= employeeService.findEmployeeById(id);
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
        Employee newemployee =employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newemployee, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
        Employee updateemployee =employeeService.addEmployee(employee);
        return  new ResponseEntity<>(updateemployee, HttpStatus.OK);
    }


    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
