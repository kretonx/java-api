package com.kretxns.api.controller;

import com.kretxns.api.dto.CreateAccountRequest;
import com.kretxns.api.model.Account;
import com.kretxns.api.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import java.util.Collection;

@RestController
public class HealthController {

    private final AccountService accountService;

    public HealthController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id){
        Account account = accountService.getAccountById(id);

        if (account == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(account);
    }
    @GetMapping("/accounts")
    public Collection<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/health")
    public String health() {
        return "API rodando";
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request.titular);
    }
}
