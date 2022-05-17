package com.abhay.spring.dao.impl;

import com.abhay.spring.dao.EmpDao;
import com.abhay.spring.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParamJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParamJdbcTemplate = namedParameterJdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Emp emp) {
        String insert_emp = "insert into Emp99 values (:id,:name,:salary,:designation)";
        return namedParamJdbcTemplate.update(insert_emp, this.getParameterSource(emp));
    }

    @Override
    public int update(Emp emp) {
        String update_emp = "update emp99 set name = :name, designation = :designation, salary = :salary where id = :id";
        return namedParamJdbcTemplate.update(update_emp, getParameterSource(emp));
    }

    @Override
    public int delete(int id) {
        String delete_emp = "delete from emp99 where id = ?";
        return jdbcTemplate.update(delete_emp,id);
    }


    @Override
    public Emp getEmpById(int id) {
        String getEmp = "select * from emp99 where id = ?";
        return jdbcTemplate.queryForObject(getEmp, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp e=new Emp();
                e.setId(rs.getInt("ID"));
                e.setName(rs.getString("NAME"));
                e.setSalary(rs.getFloat("SALARY"));
                e.setDesignation(rs.getString("DESIGNATION"));
                return e;
            }
        },id);
    }

    @Override
    public List<Emp> getAllEmployees() {
        String getAllEmp = "select * from emp99";
        return namedParamJdbcTemplate.query(getAllEmp, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp e=new Emp();
                e.setId(rs.getInt("ID"));
                e.setName(rs.getString("NAME"));
                e.setSalary(rs.getFloat("SALARY"));
                e.setDesignation(rs.getString("DESIGNATION"));
                return e;
            }
        });
    }

    private MapSqlParameterSource getParameterSource(Emp emp) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", emp.getId());
        parameterSource.addValue("name", emp.getName());
        parameterSource.addValue("salary", emp.getSalary());
        parameterSource.addValue("designation", emp.getDesignation());
        return parameterSource;
    }
}
