package com.kretxns.api.controller;

import com.kretxns.api.dto.CreateAccountRequest;
import com.kretxns.api.model.Account;
import com.kretxns.api.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;


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

    @GetMapping("/health")
    public String health() {
        return "API rodando";
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request.titular);
    }
}
