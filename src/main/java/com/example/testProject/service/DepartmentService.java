package com.example.testProject.service;

import com.example.testProject.Entity.Department;
import com.example.testProject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

  public List<Department> fetchDepartments();

  public Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

    public void deleteAllDepartment();

   public Department getDepartmentByName(String departmentName);
}
