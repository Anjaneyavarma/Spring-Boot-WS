package com.code.spring.service;

import com.code.spring.entity.Department;
import com.code.spring.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department fetchById(Long id) throws DepartmentNotFoundException;

    public void deleteById(Long Id);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentByName(String name);
}
