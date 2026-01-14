package com.kretxns.api.service;

import com.kretxns.api.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.kretxns.api.dto.WithdrawRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;


@Service


public class AccountService {
    public Account getAccountById(long id){
        return accounts.get(id);
    }
    public Collection<Account> getAllAccounts(){
        return accounts.values();
    }
    private final Map<Long, Account> accounts = new HashMap<>();
    private long nextId =1;

    public Account createAccount(String titular) {

        Account account = new Account();
        account.titular = titular;
        account.saldo = 0;
        account.id = nextId;
        nextId++;

        accounts.put(account.id, account);

        return account;
    }
    public Account deposit(long id, double valor) {
        Account account = accounts.get(id);

        if(account == null){
            return null;
        }
        if(valor <= 0){
            throw new IllegalArgumentException("Valor do depósito deve ser maior que zero");
        }
        account.saldo += valor;
        return account;
    }
    @PostMapping("/accounts/{id}/withdraw")
    public Account withdraw(long id, double valor){
        Account account = accounts.get(id);

        if(account == null){
            return null;
        }

        if (valor <+ 0){
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero");
        }

        if (account.saldo < valor){
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        account.saldo -= valor;
        return account;
    }
}
