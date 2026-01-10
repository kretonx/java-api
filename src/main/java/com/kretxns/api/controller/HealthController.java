package com.kretxns.api.controller;

import com.kretxns.api.dto.CreateAccountRequest;
import com.kretxns.api.model.Account;
import com.kretxns.api.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final AccountService accountService;

    public HealthController(AccountService accountService) {
        this.accountService = accountService;
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
