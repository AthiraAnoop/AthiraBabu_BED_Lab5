package com.gl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.demo.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

}
