package com.niral.employeemanagement.controllers;

import com.niral.employeemanagement.entities.Employee;
import com.niral.employeemanagement.exceptions.EmployeeNotFoundException;
import com.niral.employeemanagement.requests.CreateEmployeeRequest;
import com.niral.employeemanagement.requests.UpdateEmployeeRequest;
import com.niral.employeemanagement.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeService.createEmployee(createEmployeeRequest);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) throws EmployeeNotFoundException {
        Employee employee = employeeService.updateEmployee(id, updateEmployeeRequest);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
        String response = employeeService.deleteEmployee(id);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
}
