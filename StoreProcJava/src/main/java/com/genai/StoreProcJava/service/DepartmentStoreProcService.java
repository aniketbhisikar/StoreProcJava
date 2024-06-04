package com.genai.StoreProcJava.service;

import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentStoreProcService {
    void readDepartmentStoreProc() throws Exception;
    void readDepartmentBudgetStoreProc() throws Exception;
    void readDepartmentTable() throws Exception;
}
