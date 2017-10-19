package com.target.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
