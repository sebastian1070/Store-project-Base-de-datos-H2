package com.example.Store.project.repository;

import com.example.Store.project.entities.CamisaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamisaRepository extends JpaRepository<CamisaEntity, Long> {
}
