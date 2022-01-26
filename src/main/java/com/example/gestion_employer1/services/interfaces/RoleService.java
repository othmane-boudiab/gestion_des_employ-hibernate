package com.example.gestion_employer1.services.interfaces;

import com.example.gestion_employer1.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public interface RoleService {
    RoleEntity add(RoleEntity role);
    RoleEntity find(Long id);
    ArrayList<RoleEntity> getAll();
    RoleEntity update(RoleEntity role);
    boolean delete(Long id);

}
