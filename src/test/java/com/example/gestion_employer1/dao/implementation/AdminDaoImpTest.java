package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.AdminDao;
import com.example.gestion_employer1.entity.AdminEntity;
import com.example.gestion_employer1.entity.RoleEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminDaoImpTest {

    @Test
    void add() {

        AdminDao adminDao = new AdminDaoImp();
        RoleEntity role = new RoleEntity(new Long(1),"admin");

        AdminEntity admin = new AdminEntity("admin","lastadmin","admin@gmail.com","1234",role);
        assertInstanceOf(AdminEntity.class,adminDao.add(admin));

    }

    @Test
    void find() {

        AdminDao adminDao =new AdminDaoImp();
        assertInstanceOf(AdminEntity.class,adminDao.find(new Long(1)));
    }

    @Test
    void getAll() {

        AdminDao adminDao = new AdminDaoImp();
        ArrayList<AdminEntity> admins = new ArrayList<AdminEntity>();
        assertInstanceOf(admins.getClass(),adminDao.getAll());
    }

    @Test
    void update() {

        AdminDao adminDao = new AdminDaoImp();
        RoleEntity role = new RoleEntity(new Long(6),"admin");

        AdminEntity admin = new AdminEntity("admin","update admin","admin@gmail.com","1234",role,new Long(3));
        assertInstanceOf(AdminEntity.class,adminDao.update(admin));
    }

    @Test
    void delete() {

        AdminDao adminDao = new AdminDaoImp();
        assertTrue(adminDao.delete(new Long(4)));
    }

}