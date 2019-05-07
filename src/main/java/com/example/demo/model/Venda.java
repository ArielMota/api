/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.util.Date;
import java.util.List;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Raffael
 */
@Entity
public class Venda {
    private Long id;
    private Date data;
    private double valor;
    private Cliente cliente;
    
    private List<ItemVenda> itensVendas;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToMany
    @JoinColumn(name = "venda_id")
    public List<ItemVenda> getItensVendas() {
        return itensVendas;
    }

    public void setItensVendas(List<ItemVenda> itensVendas) {
        this.itensVendas = itensVendas;
    }
    
}
