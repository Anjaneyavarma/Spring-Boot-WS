package com.code.spring.service;

import com.code.spring.entity.Department;
import com.code.spring.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService service;
    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("EEE")
                .departmentAddress("Block-3")
                .departmentcode("EEE-04").id(2L).build();

        Mockito.when(departmentRepo.getDepartmentByName("EEE")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDepartmentName(){
        String departmenetName = "EEE";
        Department found = service.getDepartmentByName(departmenetName);
        assertEquals(departmenetName, found.getDepartmentName());
    }


}