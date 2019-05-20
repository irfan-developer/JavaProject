package com.sapiens.service;

import com.sapiens.customer.customer;

public interface Service {
	void acceptRecord();
	customer searchByName() throws Exception;
	customer searchById() throws Exception;
	void createPolicy();
}
