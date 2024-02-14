package com.example.testProject.Controller;

import com.example.testProject.Entity.Department;
import com.example.testProject.error.DepartmentNotFoundException;
import com.example.testProject.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/Departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/Departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("Inside fetchDepartments of DepartmentController");
        return departmentService.fetchDepartments();
    }
    @GetMapping("/Departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside findDepartmentById of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }
    @DeleteMapping("/Departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        return "Department deleted successfully";
    }
    @PutMapping("/Departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId,department);

    }
    @DeleteMapping("/Departments/DeleteAll")
    public String deleteAllDepartment(){
        departmentService.deleteAllDepartment();
        LOGGER.info("Inside deleteAllDepartment of DepartmentController");
        return "All Departments deleted successfully";
    }
    @GetMapping("Departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside getDepartmentByName of DepartmentController");
        return departmentService.getDepartmentByName(departmentName);

    }


}
