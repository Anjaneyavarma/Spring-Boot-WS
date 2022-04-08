package com.code.spring.repository;

import com.code.spring.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("EEE")
                .departmentAddress("Block-3").departmentcode("EEE-04").build();
        testEntityManager.persist(department);
    }

//    @Test
//    public void findDepartmentById(){
//        Department found = departmentRepo.findById(2L).get();
//        assertEquals(found.getDepartmentcode(),"EEE-04");
//
//    }
}