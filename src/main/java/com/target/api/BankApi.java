package com.target.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.entity.Conta;
import com.target.service.InternetBankingService;

@RestController
@RequestMapping("/bank-tt")
public class BankApi {

  @Autowired
  private InternetBankingService internetBankingService;
  
  @RequestMapping(method=RequestMethod.GET, value="/contas")
  public ResponseEntity<List<Conta>> listarTodasContas(){
    
    List<Conta> contas = internetBankingService.listarContas();
    return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);
    
  }
  
}
