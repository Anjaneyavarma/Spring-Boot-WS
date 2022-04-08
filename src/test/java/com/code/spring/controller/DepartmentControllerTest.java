package com.code.spring.controller;

import com.code.spring.entity.Department;
import com.code.spring.error.DepartmentNotFoundException;
import com.code.spring.service.DepartmentService;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentName("MECH")
                .departmentAddress("Block-02").departmentcode("MECH-02").id(3L).build();
    }

    @Test
    public void saveDeaprtment() throws Exception {
        Department inputDepartment = Department.builder().departmentName("MECH")
                .departmentAddress("Block-02").departmentcode("MECH-02").build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/department").contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "    \"departmentName\":\"MECH\",\n" +
                "    \"departmentAddress\":\"Block-02\",\n" +
                "    \"departmentcode\":\"MECH-02\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchById(3L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/department/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));

//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/department/3").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
//                        .value(department.getDepartmentName()))
//                .andReturn();
    }
}