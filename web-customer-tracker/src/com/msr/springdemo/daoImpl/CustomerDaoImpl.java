package com.msr.springdemo.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.msr.springdemo.dao.CustomerDao;
import com.msr.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(){
		Session currentSession= sessionFactory.getCurrentSession();
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> customer = theQuery.getResultList();
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession= sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomerById(int id) {
		Session currentSession= sessionFactory.getCurrentSession();
		Customer customer=currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomerById(int id) {
		Session currentSession= sessionFactory.getCurrentSession();
		Query query=currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
