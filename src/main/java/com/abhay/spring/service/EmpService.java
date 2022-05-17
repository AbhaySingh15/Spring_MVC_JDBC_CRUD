package com.abhay.spring.service;

import com.abhay.spring.model.Emp;

import java.util.List;

public interface EmpService {

    void saveEmp(Emp emp);
    List<Emp> getAllEmployees();
    void deleteEmp(int id);
    void updateEmpDetails(Emp emp);
    Emp getEmpById(int id);
}
