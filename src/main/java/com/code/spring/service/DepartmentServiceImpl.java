package com.code.spring.service;

import com.code.spring.entity.Department;
import com.code.spring.error.DepartmentNotFoundException;
import com.code.spring.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    @Override
    public Department saveDepartment(Department department) {
        Department newDepartment = repo.save(department);
        return newDepartment;
    }

    @Override
    public List<Department> getDepartments() {
        List<Department> departments = repo.findAll();
        return departments;
    }

    @Override
    public Department fetchById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = repo.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department id is not found");
        }

        return department.get();
    }

    @Override
    public void deleteById(Long Id) {
        repo.deleteById(Id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentDB = repo.findById(id).get();
            departmentDB.setDepartmentName(department.getDepartmentName());
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
            departmentDB.setDepartmentcode(department.getDepartmentcode());
        return repo.save(departmentDB);

    }

    @Override
    public Department getDepartmentByName(String name) {
        return repo.getDepartmentByName(name);
    }
}
