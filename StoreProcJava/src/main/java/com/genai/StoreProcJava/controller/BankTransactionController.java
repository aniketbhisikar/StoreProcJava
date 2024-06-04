package com.genai.StoreProcJava.controller;

import com.genai.StoreProcJava.service.BankTransactionStoreProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankTransactionController {

    @Autowired
    BankTransactionStoreProcService bankTransactionStoreProcService;

    @GetMapping("/bankTransaction/accountId/{account_id}/amount/{amount}/type/{tran_type}")
    public String bankTransaction(@PathVariable("account_id") String acct_id,
                       @PathVariable("amount") float tran_amt, @PathVariable("tran_type") String tran_type) throws Exception {
        return bankTransactionStoreProcService.BankAccountTransactionStoreProc(acct_id,tran_amt,tran_type);
    }
}
