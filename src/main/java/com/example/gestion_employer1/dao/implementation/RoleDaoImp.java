package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.RoleDao;
import com.example.gestion_employer1.entity.RoleEntity;
import com.example.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;

public class RoleDaoImp implements RoleDao {
    @Override
    public RoleEntity add(RoleEntity role) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(role.getName());


        session.save(roleEntity);
        session.getTransaction().commit();
        session.close();
        role.setId_role(role.getId_role());
        return roleEntity;
    }


    @Override
    public RoleEntity find(Long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        RoleEntity roleEntity =  session.get(RoleEntity.class,id);
        session.close();

        return roleEntity;

    }
    @Override
    public ArrayList<RoleEntity> getAll() {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        ArrayList<RoleEntity> roleEntity = (ArrayList<RoleEntity>) session.createCriteria(RoleEntity.class).list();

        session.close();
        return roleEntity;
    }


    @Override
    public RoleEntity update(RoleEntity role) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();

        session.find(RoleEntity.class,role.getId_role());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId_role(role.getId_role());
        roleEntity.setName(role.getName());

        session.merge(roleEntity);
        session.getTransaction().commit();
        session.close();
        return role;
    }
    @Override
    public boolean delete(Long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        RoleEntity roleEntity = session.load(RoleEntity.class,id);
        session.delete(roleEntity);
        session.getTransaction().commit();
        return true;
    }
}
