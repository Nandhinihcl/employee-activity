package com.example.employeeactivity.dao;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeCRUD extends CrudRepository<Employee, Integer> {
    Employee findByCode(Integer code);
}
