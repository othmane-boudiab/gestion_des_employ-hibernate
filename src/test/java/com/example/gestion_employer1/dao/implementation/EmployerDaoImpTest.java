package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.EmployerDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import com.example.gestion_employer1.entity.RoleEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployerDaoImpTest {

    @Test
    void add() {
        EmployerDao employerDao = new EmployerDaoImp();
        RoleEntity role = new RoleEntity(new Long(5),"employer");

        EmployerEntity employer = new EmployerEntity("abdelilah2","Zroud 2","abdelilahzroud@gmail.com","1234",role);

        assertInstanceOf(EmployerEntity.class,employerDao.add(employer));

    }

    @Test
    void find() {
        EmployerDao employerDao = new EmployerDaoImp();
        assertInstanceOf(EmployerEntity.class,employerDao.find(new Long(10)));
    }

    @Test
    void getAll() {
        EmployerDao employerDao = new EmployerDaoImp();
        ArrayList<EmployerEntity> employers = new ArrayList<EmployerEntity>();
        assertInstanceOf(employers.getClass(),employerDao.getAll());
    }

    @Test
    void update() {
        EmployerDao employerDao = new EmployerDaoImp();
        RoleEntity role = new RoleEntity(new Long(2),"employer");

        EmployerEntity employer = new EmployerEntity("abdelilah up","Zroud","abdelilahzroud@gmail.com","1234",role,new Long(1));
        assertInstanceOf(EmployerEntity.class,employerDao.update(employer));
    }

    @Test
    void delete() {
        EmployerDao employerDao = new EmployerDaoImp();
        assertTrue(employerDao.delete(new Long(8)));
    }
}