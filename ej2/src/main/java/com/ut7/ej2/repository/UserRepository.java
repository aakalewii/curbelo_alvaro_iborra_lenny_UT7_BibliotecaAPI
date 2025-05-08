package com.ut7.ej2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ut7.ej2.model.Libro;

public interface UserRepository extends JpaRepository<Libro, Long> { }
