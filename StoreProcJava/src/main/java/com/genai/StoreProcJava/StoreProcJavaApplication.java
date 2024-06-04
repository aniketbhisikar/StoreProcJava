package com.genai.StoreProcJava;

import com.genai.StoreProcJava.service.BankTransactionStoreProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class StoreProcJavaApplication {

	@Autowired
	BankTransactionStoreProcService bankTransactionStoreProcService;

	public static void main(String[] args) throws Exception {

		SpringApplication.run(StoreProcJavaApplication.class, args);

		/*StoreProcReaderServiceImpl spService = new StoreProcReaderServiceImpl();
		spService.readStoreProcedure();
		DepartmentStoreProcServiceImpl departmentStroProcService = new DepartmentStoreProcServiceImpl();
		departmentStroProcService.readDepartmentStoreProc();
		departmentStroProcService.readDepartmentBudgetStoreProc();

		BankTransactionStoreProcServiceImpl bankTransactionStoreProcService = new BankTransactionStoreProcServiceImpl();
		bankTransactionStoreProcService.BankAccountTransactionStoreProc("0011", 1000, "credit");
		System.out.println("Hurray ran successfully");*/
	}

}
