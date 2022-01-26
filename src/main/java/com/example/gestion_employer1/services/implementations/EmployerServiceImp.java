package com.example.gestion_employer1.services.implementations;

import com.example.gestion_employer1.dao.implementation.EmployerDaoImp;
import com.example.gestion_employer1.dao.interfaces.EmployerDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import com.example.gestion_employer1.services.interfaces.EmployerService;

import java.util.ArrayList;
import java.util.List;

public class EmployerServiceImp implements EmployerService {
    private EmployerDao employerDao = new EmployerDaoImp();
    @Override
    public EmployerEntity add(EmployerEntity employer){
        return employerDao.add(employer);
    }
    @Override
    public EmployerEntity find(Long id){
        return employerDao.find(id);
    }
    @Override
    public List<EmployerEntity> getAll(){
        return employerDao.getAll();
    }
    @Override
    public EmployerEntity update(EmployerEntity employer){
        return employerDao.update(employer);
    }
    @Override
    public boolean delete(Long id){
        return employerDao.delete(id);
    }

}
