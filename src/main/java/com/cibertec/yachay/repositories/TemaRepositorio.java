package com.cibertec.yachay.repositories;

import com.cibertec.yachay.entities.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepositorio extends JpaRepository<Tema, Long> {
}