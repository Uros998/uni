package com.metropolitan.it355dz09.repository;

import com.metropolitan.it355dz09.entity.Gameplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameplayRepository extends JpaRepository<Gameplay, Integer> {
}
