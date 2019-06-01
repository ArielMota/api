package com.demo.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.contato.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}