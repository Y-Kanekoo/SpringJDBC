package com.example.service;

import com.example.domain.Department;
import com.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department findById(Integer id){
        return departmentRepository.findById(id);
    }

    public ArrayList<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public void deleteById(Integer id){
        departmentRepository.deleteById(id);
    }
}
