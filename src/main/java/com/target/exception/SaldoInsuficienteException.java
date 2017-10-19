package com.target.exception;

public class SaldoInsuficienteException extends Exception {

  private Double valor;
  
  public SaldoInsuficienteException(Double valor) {
    this.valor = valor;
  }

  public Double getValor() {
    return valor;
  }  
  
}
