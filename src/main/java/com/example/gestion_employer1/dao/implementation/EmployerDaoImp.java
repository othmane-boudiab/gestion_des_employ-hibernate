package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.EmployerDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import com.example.gestion_employer1.hibernate.HSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployerDaoImp implements EmployerDao {
    @Override
    public EmployerEntity add(EmployerEntity employer) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();

        EmployerEntity employerEntity= new EmployerEntity();
        employerEntity.setFirst_name(employer.getFirst_name());
        employerEntity.setLast_name(employer.getLast_name());
        employerEntity.setEmail(employer.getEmail());
        employerEntity.setPassword(employer.getPassword());
        employerEntity.setRole(employer.getRole());


        session.save(employerEntity);
        session.getTransaction().commit();
        session.close();
        employer.setId_user(employer.getId_user());
        return employer;
    }
    @Override
    public EmployerEntity find(Long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        EmployerEntity employerEntity =  session.get(EmployerEntity.class,id);
        session.close();

        return employerEntity;

    }
    @Override
    public List<EmployerEntity> getAll() {

        Session session = HSessionFactory.getInstance().getSession().openSession();
        Transaction transaction =session.beginTransaction();

        List<EmployerEntity> employerEntity =  session.createQuery("from EmployerEntity ").list();
        transaction.commit();




        return employerEntity;
    }
    @Override
    public EmployerEntity update(EmployerEntity employer) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();

        session.find(EmployerEntity.class,employer.getId_user());

        EmployerEntity employerEntity = new EmployerEntity();

        employerEntity.setId_user(employer.getId_user());
        employerEntity.setEmail(employer.getEmail());
        employerEntity.setFirst_name(employer.getFirst_name());
        employerEntity.setLast_name(employer.getLast_name());
        employerEntity.setPassword(employer.getPassword());

        employerEntity.setRole(employer.getRole());


        session.merge(employerEntity);
        session.getTransaction().commit();
        session.close();
        return employer;
    }
    @Override
    public boolean delete(Long id) {
        Session session = HSessionFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        EmployerEntity employerEntity = session.load(EmployerEntity.class,id);
        session.delete(employerEntity);
        session.getTransaction().commit();
        return true;
    }
}
