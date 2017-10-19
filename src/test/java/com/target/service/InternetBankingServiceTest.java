package com.target.service;

import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.entity.Conta;
import com.target.exception.SaldoInsuficienteException;
import com.target.repository.ContaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InternetBankingServiceTest {

  @MockBean
  private ContaRepository contaRepository;
  
  @Autowired
  private InternetBankingService internetBankingService;
  
  private Conta contaOrigem;
  private Conta contaDestino;
  
  @Before
  public void setUp() {
    contaOrigem = new Conta("Alex", 300d);
    contaOrigem.setId(1L);
    contaDestino = new Conta("Joao", 200d);
    contaDestino.setId(2L);
  }
  
  @Test
  public void testTransferir() throws SaldoInsuficienteException {

    BDDMockito.given(contaRepository.findById(1L)).willReturn(Optional.of(contaOrigem));
    BDDMockito.given(contaRepository.findById(2L)).willReturn(Optional.of(contaDestino));

    internetBankingService.transferir(100d, contaOrigem, contaDestino);
    
    Assert.assertThat(contaOrigem.getSaldo(), CoreMatchers.is(200d));
  }
  
}
