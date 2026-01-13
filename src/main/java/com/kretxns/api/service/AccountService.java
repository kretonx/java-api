package com.kretxns.api.service;

import com.kretxns.api.model.Account;
import org.springframework.stereotype.Service;
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
}
