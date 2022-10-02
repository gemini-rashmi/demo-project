package com.example.employee.services;

import com.example.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getEmployees() throws Exception;
    EmployeeDTO getEmployee(Long employeeId) throws Exception;
    EmployeeDTO updateEmployee(Long deptId, Long employeeId, EmployeeDTO employeeDTO) throws Exception;
    void createEmployee(Long deptId, EmployeeDTO employeeDTO) throws Exception;
    EmployeeDTO deleteEmployee(Long employeeId) throws Exception;
}
