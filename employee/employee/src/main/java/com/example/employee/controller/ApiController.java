package com.example.employee.controller;

import com.example.employee.models.Department;
import com.example.employee.models.Employee;
import com.example.employee.services.DepartmentService;
import com.example.employee.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class ApiController {
    Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    //Get all the employees
    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() throws Exception{
        List<Employee> employees = employeeService.getEmployees();

        LOGGER.info("GET request for all employees is successful");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //Get a specific employee
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Object> getEmployee(@PathVariable String employeeId) throws Exception{
        Long id = Long.parseLong(employeeId);
        Employee employee = employeeService.getEmployee(id);

        LOGGER.info("GET request is successful for employee with Id : "+employeeId);
        return new ResponseEntity<Object>(employee, HttpStatus.OK);
    }

    //Adding a new Employee
    @PostMapping("/departments/{deptId}/employees")
    public ResponseEntity<Object> createEmployee(@PathVariable String deptId, @Valid @RequestBody Employee employee) throws Exception {
        Long id = Long.parseLong(deptId);
        employeeService.createEmployee(id,employee);

        LOGGER.info("POST Request for employee is successful");
        return new ResponseEntity<>("Employee details added successfully", HttpStatus.CREATED);
    }

    //Updating the details of an employee
    @PutMapping("/departments/{deptId}/employees/{employeeId}")
    public ResponseEntity<Object> updateEmployee(@PathVariable String deptId, @PathVariable String employeeId, @Valid @RequestBody Employee employee) throws Exception{
        employeeService.updateEmployee(Long.parseLong(deptId), Long.parseLong(employeeId), employee);

        LOGGER.info("PUT Request is successful for employee with id : "+employeeId);
        return new ResponseEntity<>("Employee details have been successfully updated", HttpStatus.OK);
    }

    //Deleting the details of an employee
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String employeeId) throws Exception{
        Employee employee = employeeService.deleteEmployee(Long.parseLong(employeeId));

        LOGGER.info("DELETE Request is successful for employee with id : "+employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //Get all the departments
    @GetMapping("/departments")
    public ResponseEntity<Object> getDepartments() throws Exception {
        List<Department> departments = departmentService.getDepartments();

        LOGGER.info("GET Request for all departments is successful");
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    //Get a specific department
    @GetMapping("/departments/{deptId}")
    public ResponseEntity<Object> getDepartment(@PathVariable String deptId) throws Exception {
        Long id = Long.parseLong(deptId);
        Department department = departmentService.getDepartment(id);

        LOGGER.info("GET Request is successful for department with id : "+deptId);
        return new ResponseEntity<Object>(department, HttpStatus.OK);
    }

    //Adding a new Department
    @PostMapping("/departments")
    public ResponseEntity<Object> createDepartment(@Valid @RequestBody Department department) throws Exception{
        departmentService.createDepartment(department);

        LOGGER.info("POST Request for department is successful");
        return new ResponseEntity<>("Department details added successfully", HttpStatus.CREATED);
    }

    //Updating the details of a department
    @PutMapping("/departments/{deptId}")
    public ResponseEntity<Object> updateDepartment(@PathVariable String deptId, @Valid @RequestBody Department department) throws Exception{
        Long id = Long.parseLong(deptId);
        departmentService.updateDepartment(id, department);

        LOGGER.info("PUT Request is successful for department with id : "+deptId);
        return new ResponseEntity<>("Department details have been successfully updated", HttpStatus.OK);
    }

    //Deleting the details of a department
    @DeleteMapping("/departments/{deptId}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable String deptId) throws Exception{
        Department dept = departmentService.deleteDepartment(Long.parseLong(deptId));

        LOGGER.info("DELETE Request is successful for department with id : "+deptId);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }
}
