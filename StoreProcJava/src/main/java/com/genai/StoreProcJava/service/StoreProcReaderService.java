package com.genai.StoreProcJava.service;

import org.springframework.stereotype.Repository;

@Repository
public interface StoreProcReaderService {
    void readStoreProcedure() throws Exception;
}
