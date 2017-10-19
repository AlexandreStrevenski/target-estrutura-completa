package com.target.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Conta {

  @Id @GeneratedValue
  private Long id;
  private String cliente;
  private Double saldo;
  
  public Conta() {
    
  }
  
  public Conta(String cliente, Double saldo) {
    this.cliente = cliente;
    this.saldo = saldo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  
  
}
