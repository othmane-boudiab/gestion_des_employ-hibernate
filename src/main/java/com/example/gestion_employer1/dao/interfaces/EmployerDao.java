package com.example.gestion_employer1.dao.interfaces;

import com.example.gestion_employer1.entity.EmployerEntity;

import java.util.ArrayList;
import java.util.List;

public interface EmployerDao {

    EmployerEntity add(EmployerEntity employer);
    EmployerEntity find(Long id);
    List<EmployerEntity> getAll();
    EmployerEntity update(EmployerEntity employer);
    boolean delete(Long id);
}
