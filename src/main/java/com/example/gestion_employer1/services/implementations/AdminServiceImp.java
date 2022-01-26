package com.example.gestion_employer1.services.implementations;

import com.example.gestion_employer1.dao.implementation.AdminDaoImp;
import com.example.gestion_employer1.dao.interfaces.AdminDao;
import com.example.gestion_employer1.entity.AdminEntity;
import com.example.gestion_employer1.services.interfaces.AdminService;

import java.util.ArrayList;

public class AdminServiceImp implements AdminService {
    private AdminDao adminDao =new AdminDaoImp();
    @Override
    public AdminEntity add(AdminEntity admin){
        return adminDao.add(admin);
    }
    @Override
    public AdminEntity find(Long id){
        return adminDao.find(id);
    }
    @Override
    public ArrayList<AdminEntity> getAll(){
        return adminDao.getAll();
    }
    @Override
    public  AdminEntity update(AdminEntity admin){
        return adminDao.update(admin);
    }
    @Override
    public boolean delete(Long id){
        return adminDao.delete(id);
    }

}
