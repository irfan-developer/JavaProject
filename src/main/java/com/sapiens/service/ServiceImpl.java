package com.sapiens.service;

import java.io.IOException;
import java.util.Scanner;
import com.sapiens.customer.customer;
import com.sapiens.dao.InsDao;

public class ServiceImpl implements Service {
	static customer customer = new customer();
	static Scanner sc = new Scanner(System.in);
	
	public void acceptRecord() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name: ");
		customer.setName(sc.next());
		System.out.println("Enter City: ");
		customer.setName(sc.next());
		System.out.println("Enter Role : ");
		customer.setName(sc.next());
		
		try(InsDao dao = new InsDao() )
		{
			dao.insert(customer);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public customer searchByName() throws Exception {
		// TODO Auto-generated method stub
		    try(InsDao dao = new InsDao()) {
			System.out.println("Enter Name:");
			String name = sc.next();
		    return dao.searchByName(name);
		    }
	    }
	@Override
	public customer searchById() throws Exception {
		// TODO Auto-generated method stub
		    try(InsDao dao = new InsDao()) {
			System.out.println("Enter Id:");
			int id = sc.nextInt();
		    return dao.searchById(id);
		    }
	    }
	
}
