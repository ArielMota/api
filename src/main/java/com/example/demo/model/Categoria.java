/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Raffael
 */
@Entity
class Categoria {
    private int id;
    private String nome;
    private List<Produto> produto;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToMany(mappedBy = "categoria")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<Produto> getProdutos() {
        return produto;
    }

    public void setProdutos(List<Produto> produto) {
        this.produto = produto;
    }
    
    
}
