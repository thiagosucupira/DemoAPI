package com.sucupira.courrier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sucupira.courrier.model.Courrier;

/**
 * The Interface CourrierRepo.
 */
public interface CourrierRepo extends JpaRepository<Courrier, Long> {

}
