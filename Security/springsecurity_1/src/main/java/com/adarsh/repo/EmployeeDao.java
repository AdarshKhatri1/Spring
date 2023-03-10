package com.adarsh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarsh.model.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	public List<Employee> findByName(String name);
}
