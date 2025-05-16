package com.example.repository;

import com.example.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;

@Repository
public class DepartmentRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public Department findById(Integer id){
        System.out.println("RepositoryのfindById()が呼ばれました。");
        return null;
    }

    public ArrayList<Department> findAll(){
        System.out.println("RepositoryのfindAll()が呼ばれました。");
        return new ArrayList<Department>();
    }

    public Department save(Department department){
        System.out.println("Repositoryのsave()が呼ばれました。");
        return null;
    }

    public void deleteById(Integer id){
        System.out.println("RepositoryのdeleteById()が呼ばれました。");
    }
}
