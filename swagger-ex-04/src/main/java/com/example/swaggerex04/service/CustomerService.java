package com.example.swaggerex04.service;

import com.example.swaggerex04.dto.CustomerDTO;
import com.example.swaggerex04.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO createCustomer(CustomerDTO customer) {
        return repository.save(customer);
    }

    public Optional<CustomerDTO> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        return repository.findAll();
    }

    public Optional<CustomerDTO> updateCustomer(Long id, CustomerDTO customer) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        customer.setId(id);
        return Optional.of(repository.save(customer));
    }

    public boolean deleteCustomer(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
