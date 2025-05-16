package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex23")
public class Ex23Controller {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @GetMapping("/execute")
    public String execute(){
        String sql = "SELECT count(*) FROM departments WHERE name = :firstName OR name = :secondName;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("firstName","総務部").addValue("secondName","技術部");
        Integer result = template.queryForObject(sql,param, Integer.class);
        System.out.println("件数は" + result);
        return "finished";
    }
}