package com.example.gestion_employer1.services.interfaces;

import com.example.gestion_employer1.entity.AdminEntity;

import java.util.ArrayList;

public interface AdminService {

    AdminEntity add(AdminEntity admin);
    AdminEntity find(Long id);
    ArrayList<AdminEntity> getAll();
    AdminEntity update(AdminEntity admin);
    boolean delete(Long id);
}
