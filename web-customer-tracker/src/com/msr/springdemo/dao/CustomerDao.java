package com.msr.springdemo.dao;

import java.util.List;

import com.msr.springdemo.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerById(int id);

	public void deleteCustomerById(int id);

}
