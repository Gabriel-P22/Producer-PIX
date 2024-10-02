package com.alura.pix.infrastructure.database.repository;

import com.alura.pix.infrastructure.database.model.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixRepository extends JpaRepository<Pix, Integer> {}
