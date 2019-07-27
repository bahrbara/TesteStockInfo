package com.testestockinfo.teste;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/operacao")
public class OperationController {

    private Map<Integer, Account> listaContas = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public Map<Integer, Account> get() {

        Account conta = new Account(
              'N'
        );

        conta.setIdAccount(1);

        listaContas.put(conta.getIdAccount(), conta);
        return listaContas;
    }

    @RequestMapping(value = "/deposito/{id}", method = RequestMethod.POST)
    public Account create(@PathVariable("id") int idAccount, @RequestBody Deposit request) throws Exception {
        Account contaDeposito = listaContas.get(idAccount);
        contaDeposito.deposit(request.getValue());
        return contaDeposito;
    }
    
//
//    @RequestMapping("/{id}")
//    public Client getById(@PathVariable("id") int idClient){
//
//        return listaCliente.get(idClient);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Client edit(@PathVariable("id") int idClient,
//                       @RequestBody Client request) {
//        Client clientEdited = listaCliente.get(idClient);
//        clientEdited.setPhoneNumber(request.getPhoneNumber());
//        clientEdited.setEmail(request.getEmail());
//        clientEdited.setAddress(request.getAddress());
//
//        return clientEdited;
//    }
}
