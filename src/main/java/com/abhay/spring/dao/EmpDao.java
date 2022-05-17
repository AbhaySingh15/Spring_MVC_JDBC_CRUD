package com.abhay.spring.dao;

import com.abhay.spring.model.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public interface EmpDao {

    int save(Emp emp);
    int update(Emp emp);
    int delete(int id);
    Emp getEmpById(int id);
    List<Emp> getAllEmployees();
}
