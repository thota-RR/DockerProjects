package com.example.docker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getCustomer() {
		return List.of(new Customer(1L, "bob", "bo@gmail.com", "US"));
	}

	public void createCutomer(CreateCustomerRequest createCutomerRequest) {
		Customer customer = new Customer(createCutomerRequest.name(), createCutomerRequest.email(),
				createCutomerRequest.address());
		customerRepository.save(customer);

	}

	public List<Customer> getAllCutomer() {

		return customerRepository.findAll();

	}
	
	public void updateCustomer(Long id,String name,String email,String address) {
		
		Optional<Customer> customer= customerRepository.findById(id);
		customer.get().setName(name);
		customer.get().setEmail(email);
		customer.get().setAddress(address);
		
		customerRepository.save(customer.get());
		
	}
}
