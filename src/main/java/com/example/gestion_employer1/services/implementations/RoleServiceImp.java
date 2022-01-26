package com.example.gestion_employer1.services.implementations;

import com.example.gestion_employer1.dao.implementation.RoleDaoImp;
import com.example.gestion_employer1.dao.interfaces.RoleDao;
import com.example.gestion_employer1.entity.RoleEntity;
import com.example.gestion_employer1.services.interfaces.RoleService;

import java.util.ArrayList;

public class RoleServiceImp implements RoleService {
    private RoleDao roleDao = new RoleDaoImp();
    @Override
    public RoleEntity add(RoleEntity role){
        return roleDao.add(role);
    }
    @Override
    public  RoleEntity find(Long id){
        return roleDao.find(id);
    }
    @Override
    public ArrayList<RoleEntity> getAll(){
        return roleDao.getAll();
    }
    @Override
    public RoleEntity update(RoleEntity role){
        return roleDao.update(role);
    }
    @Override
    public boolean delete(Long id){
        return roleDao.delete(id);
    }
}
