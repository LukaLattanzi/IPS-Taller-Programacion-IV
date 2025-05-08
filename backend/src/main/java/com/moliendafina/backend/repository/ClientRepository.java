package com.moliendafina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moliendafina.backend.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}