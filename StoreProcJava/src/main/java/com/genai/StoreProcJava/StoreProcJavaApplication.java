package com.genai.StoreProcJava;

import com.genai.StoreProcJava.service.DepartmentStroProcServiceImpl;
import com.genai.StoreProcJava.service.StroreProcReaderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreProcJavaApplication {

	public static void main(String[] args) throws Exception {

		StroreProcReaderService spService = new StroreProcReaderService();
		spService.readStoreProcedure();
		DepartmentStroProcServiceImpl departmentStroProcService = new DepartmentStroProcServiceImpl();
		departmentStroProcService.readDepartmentStoreProc();
		departmentStroProcService.readDepartmentBudgetStoreProc();

		System.out.println("Hurray ran successfully");
	}

}
