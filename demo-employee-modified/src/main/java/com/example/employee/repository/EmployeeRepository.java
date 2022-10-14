package com.example.employee.repository;

import com.example.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByIsActiveAndIsDeleted(boolean isActive, boolean isDeleted);
}
