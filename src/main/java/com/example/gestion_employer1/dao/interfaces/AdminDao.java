package com.example.gestion_employer1.dao.interfaces;

import com.example.gestion_employer1.entity.AdminEntity;

import java.util.ArrayList;

public interface AdminDao {

    AdminEntity add(AdminEntity admin);
    AdminEntity find(Long id);
    ArrayList<AdminEntity> getAll();
    AdminEntity update(AdminEntity admin);
    boolean delete(Long id);
}
