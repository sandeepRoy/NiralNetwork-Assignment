package com.niral.employeemanagement.services;

import com.niral.employeemanagement.entities.Employee;
import com.niral.employeemanagement.exceptions.EmployeeNotFoundException;
import com.niral.employeemanagement.repositories.EmployeeRepository;
import com.niral.employeemanagement.requests.CreateEmployeeRequest;
import com.niral.employeemanagement.requests.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // GET - List<Employee>
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    // GET - Employee by providing ID
    public Employee getEmployee(Integer id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Not Found"));
        return employee;
    }

    // POST - New Employee
    public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest){
        Employee employee = new Employee();
        employee.setName(createEmployeeRequest.getName());
        employee.setJobTitle(createEmployeeRequest.getJobTitle());
        employee.setSalary(createEmployeeRequest.getSalary());
        employee.setManager_name(createEmployeeRequest.getManagerName());

        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee;
    }

    // Update - Make changes to existing Employee by providing ID
    public Employee updateEmployee(Integer id, UpdateEmployeeRequest updateEmployeeRequest) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Not Found"));

        employee.setName(updateEmployeeRequest.getName());
        employee.setJobTitle(updateEmployeeRequest.getJobTitle());
        employee.setSalary(updateEmployeeRequest.getSalary());
        employee.setManager_name(updateEmployeeRequest.getManagerName());

        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    // DELETE - Remove an Employee by providing ID
    public String deleteEmployee(Integer id) throws EmployeeNotFoundException {
        String response = "";
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Not Found"));
        if(!employee.equals(null)) { response = "Deleted"; }
        employeeRepository.delete(employee);
        return response;
    }
}
