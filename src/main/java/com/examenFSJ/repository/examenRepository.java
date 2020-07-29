package com.examenFSJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenFSJ.entity.examenEntity;

public interface examenRepository extends  JpaRepository<examenEntity, String> {

}
