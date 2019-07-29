package com.testestockinfo.teste.Controller;

import com.testestockinfo.teste.Model.Account;
import com.testestockinfo.teste.Model.Deposit;
import com.testestockinfo.teste.Model.Operation;
import com.testestockinfo.teste.Repository.AccountRepository;
import com.testestockinfo.teste.Model.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operacao")
public class OperationController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Account> get(@PathVariable("id") int idClient) {
        return accountRepository.findByIdClient(idClient);
    }

    @RequestMapping(value = "/extrato/{id}", method = RequestMethod.GET)
    public List<Operation> accountStatement(@PathVariable("id") int idAccount) throws Exception {
        Account account = accountRepository.findById(idAccount).orElseThrow(() -> new Exception("Conta não encontrada"));
        List<Operation> statements = new ArrayList<>();

        statements.addAll(account.getDepositList());
        statements.addAll(account.getWithdrawList());
        //TODO ordernar por DATA e ID
        return statements;
    }

    @RequestMapping(value = "/deposito/{id}", method = RequestMethod.POST)
    public Account deposit(@PathVariable("id") int idAccount, @RequestBody Deposit request) throws Exception {
        Account account = accountRepository.findById(idAccount).orElseThrow(() -> new Exception("Conta não encontrada"));

        Deposit deposit = new Deposit();
        deposit.setValue(request.getValue());
        account.deposit(deposit);

        return accountRepository.save(account);
    }

    @RequestMapping(value = "/saque/{id}", method = RequestMethod.POST)
    public Account withdraw(@PathVariable("id") int idAccount, @RequestBody Withdraw request) throws Exception {
        Account account = accountRepository.findById(idAccount).orElseThrow(() -> new Exception("Conta não encontrada"));

        Withdraw withdraw = new Withdraw();
        withdraw.setValue(request.getValue());
        account.withdraw(withdraw);

        return accountRepository.save(account);
    }
}