package com.target.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.entity.Conta;
import com.target.exception.SaldoInsuficienteException;
import com.target.repository.ContaRepository;

@Service
public class InternetBankingService {

  @Autowired
  private ContaRepository contaRepository;


  /** 
   * @param valorTransferencia valor a ser debitado de uma conta e creditado em outra
   * @param contaOrigem indica a conta de origem
   * @param contaDestino indica a conta de destino
   * @throws SaldoInsuficienteException pode acontecer caso nao tenha saldo na conta de origem
   */
  public void transferir(Double valorTransferencia, Conta contaOrigem, Conta contaDestino) throws SaldoInsuficienteException {
    
    Conta contaOrigemVerificada = contaRepository.findById(contaOrigem.getId()).get();
    Conta contaDestinoVerificada = contaRepository.findById(contaDestino.getId()).get();

    if (valorTransferencia > contaOrigemVerificada.getSaldo()) {
      throw new SaldoInsuficienteException(valorTransferencia);
    }

    Double novoSaldo = contaOrigemVerificada.getSaldo() - valorTransferencia;
    contaOrigemVerificada.setSaldo(novoSaldo);

    Double novoSaldoDestino = contaDestinoVerificada.getSaldo() + valorTransferencia;
    contaDestinoVerificada.setSaldo(novoSaldoDestino);

  }

  public List<Conta> listarContas() {
    return contaRepository.findAll();
  }

}
