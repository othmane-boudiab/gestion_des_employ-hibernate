package com.example.gestion_employer1.dao.interfaces;


import com.example.gestion_employer1.entity.RoleEntity;

import java.util.ArrayList;

public interface RoleDao {

    RoleEntity add(RoleEntity role);
    RoleEntity find(Long id);
    ArrayList<RoleEntity> getAll();
    RoleEntity update (RoleEntity role);
    boolean delete(Long id);
}
