package com.genai.StoreProcJava.service;

import org.springframework.stereotype.Repository;

@Repository
public interface BankTransactionStoreProcService {
    String BankAccountTransactionStoreProc (String acct_id, float tran_amt, String tran_type) throws Exception;
}
