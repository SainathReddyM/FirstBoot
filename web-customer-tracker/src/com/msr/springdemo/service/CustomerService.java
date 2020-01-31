package com.msr.springdemo.service;

import java.util.List;

import com.msr.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerById(int id);

	public void deleteCustomerById(int id);
}
