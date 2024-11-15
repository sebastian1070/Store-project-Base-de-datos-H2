package com.example.Store.project.repository;

import com.example.Store.project.entities.PantalonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantalonRepository extends JpaRepository<PantalonEntity, Long> {
}
