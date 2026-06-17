package com.example.docker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Rest controller has Response body which will auto convert our object to response body
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping()
	public List<Customer> getCustomer() {
		return customerService.getCustomer();

	}

	@PostMapping
	public String createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
		customerService.createCutomer(createCustomerRequest);
		return "Success";
	}

	@GetMapping(path = "/all")
	public List<Customer> getAllCutomers() {
		return customerService.getAllCutomer();
	}

	@PutMapping(path = "{id}")
	public String updateCustomer(@PathVariable("id") Long id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) String address) {
		customerService.updateCustomer(id, name, email, address);

		return "customer updated successfully";
	}
}
