package com.abhay.spring.service;

import com.abhay.spring.dao.EmpDao;
import com.abhay.spring.model.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;
    public void setEmpDao(EmpDao empDao){
        this.empDao = empDao;
    }
    @Override
    public void saveEmp(Emp emp) {
        empDao.save(emp);
    }

    @Override
    public List<Emp> getAllEmployees() {
        return empDao.getAllEmployees();
    }

    @Override
    public void deleteEmp(int id) {
        empDao.delete(id);
    }

    @Override
    public void updateEmpDetails(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public Emp getEmpById(int id) {
       return empDao.getEmpById(id);
    }


}
