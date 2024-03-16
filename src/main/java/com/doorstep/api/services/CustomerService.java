package com.doorstep.api.services;

import com.doorstep.api.exceptions.EntityAlreadyExistsException;
import com.doorstep.api.exceptions.EntityNotFoundException;
import com.doorstep.api.models.Customer;
import com.doorstep.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(@PathVariable int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new EntityNotFoundException("Customer With given ID is not present");
    }

    public Customer create(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmailId()).isEmpty()) {
            return customerRepository.save(customer);
        }
        throw new EntityAlreadyExistsException("Customer with this Email already exists");
    }


    public String deleteCustomer(int id) {
        customerRepository.deleteById(id);
        return "Customer deleted";
    }


}
