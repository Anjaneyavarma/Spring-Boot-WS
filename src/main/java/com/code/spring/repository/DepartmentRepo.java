package com.code.spring.repository;

import com.code.spring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    @Query("select d from Department d where d.departmentName=?1")
    public Department getDepartmentByName(String name);
}
