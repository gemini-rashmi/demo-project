package com.example.employee.services;

import com.example.employee.dto.DepartmentDTO;


import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> getDepartments() throws Exception;
    DepartmentDTO getDepartment(Long deptId) throws Exception;
    DepartmentDTO updateDepartment(Long deptId, DepartmentDTO departmentDTO) throws Exception;
    void createDepartment(DepartmentDTO departmentDTO) throws Exception;
    DepartmentDTO deleteDepartment(Long deptId) throws Exception;
}
