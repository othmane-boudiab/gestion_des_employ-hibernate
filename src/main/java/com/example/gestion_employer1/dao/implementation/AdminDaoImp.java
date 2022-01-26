package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.AdminDao;
import com.example.gestion_employer1.entity.AdminEntity;
import com.example.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;

import java.util.ArrayList;

public class AdminDaoImp implements AdminDao {
    @Override
    public AdminEntity add(AdminEntity admin) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();

        AdminEntity adminEntity= new AdminEntity();

        adminEntity.setFirst_name(admin.getFirst_name());
        adminEntity.setLast_name(admin.getLast_name());
        adminEntity.setEmail(admin.getEmail());
        adminEntity.setPassword(admin.getPassword());
        adminEntity.setRole(admin.getRole());

        session.save(adminEntity);
        session.getTransaction().commit();
        session.close();
        admin.setId_user(admin.getId_user());
        return admin;
    }
    @Override
    public AdminEntity find(Long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        AdminEntity adminEntity = session.get(AdminEntity.class,id);
        session.close();


        return adminEntity;
    }

    @Override
    public ArrayList<AdminEntity> getAll() {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        ArrayList<AdminEntity> adminEntity = (ArrayList<AdminEntity>
                ) session.createCriteria(AdminEntity.class).list();

        session.close();
        return adminEntity;
    }
    @Override
    public AdminEntity update(AdminEntity admin) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();

        session.find(AdminEntity.class,admin.getId_user());

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setId_user(admin.getId_user());
        adminEntity.setEmail(admin.getEmail());
        adminEntity.setFirst_name(admin.getFirst_name());
        adminEntity.setLast_name(admin.getLast_name());
        adminEntity.setPassword(admin.getPassword());
        adminEntity.setRole(admin.getRole());


        session.merge(adminEntity);
        session.getTransaction().commit();
        session.close();
        return admin;
    }
    @Override
    public boolean delete(Long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        AdminEntity adminEntity = session.load(AdminEntity.class,id);
        session.delete(adminEntity);
        session.getTransaction().commit();
        return true;
    }
}
