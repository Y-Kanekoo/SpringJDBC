package com.example.controller;

import com.example.domain.Department;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ex24")
public class Ex24DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        @GetMapping("/execute")
        public String execute() {
            Department department = new Department();
            department.setName("name");
            department.setId(15);

            departmentService.save(department);

            Department department1=departmentService.findById(3);
            System.out.println(department1);
            departmentService.deleteById(3);
            departmentService.findAll().forEach(System.out::println);
            return "finished";
        }
    }


