package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.RoleDao;
import com.example.gestion_employer1.entity.RoleEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoImpTest {

    @Test
    void add() {
        RoleDao roleDao= new RoleDaoImp() ;
        RoleEntity roleEntity = new RoleEntity("admin");
        assertInstanceOf(RoleEntity.class,roleDao.add(roleEntity));
    }

    @Test
    void find() {
        RoleDao roleDao = new RoleDaoImp();
        assertInstanceOf(RoleEntity.class,roleDao.find(new Long(1)));
    }

    @Test
    void getAll() {
        RoleDao roleDao = new RoleDaoImp();
        ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>();
        assertInstanceOf(roles.getClass(),roleDao.getAll());
    }

    @Test
    void update() {
        RoleDao roleDao= new RoleDaoImp() ;
        RoleEntity roleEntity = new RoleEntity(new Long(2),"Employer");
        assertInstanceOf(RoleEntity.class,roleDao.update(roleEntity));
    }

    @Test
    void delete() {
        RoleDao roleDao = new RoleDaoImp();
        assertTrue(roleDao.delete(new Long(5)));
    }
}