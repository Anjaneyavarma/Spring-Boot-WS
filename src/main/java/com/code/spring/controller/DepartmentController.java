package com.code.spring.controller;

import com.code.spring.entity.Department;
import com.code.spring.error.DepartmentNotFoundException;
import com.code.spring.service.DepartmentService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("inside getDepartments of department controller");
        return service.getDepartments();
    }

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("inside saveDepartment of department controller");
        Department savedDepartment = service.saveDepartment(department);
        return savedDepartment;
    }

    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("inside fetchDepartmentById of department controller");

        return service.fetchById(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        LOGGER.info("inside deleteDepartmentById of department controller");
        service.deleteById(id);
        return "Department deleted " + id;
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                        @RequestBody Department department){
        LOGGER.info("inside updateDepartment of department controller");
        return service.updateDepartment(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        LOGGER.info("inside getDepartmentByName of department controller");
        return service.getDepartmentByName(name);
    }

}
