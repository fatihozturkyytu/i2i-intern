package com.example.swaggerex04.repository;

import com.example.swaggerex04.dto.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepository {

    private final Map<Long, CustomerDTO> customerMap = new HashMap<>();
    private long currentId = 1;

    public CustomerDTO save(CustomerDTO customer) {
        if (customer.getId() == null) {
            customer.setId(currentId++);
        }
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Optional<CustomerDTO> findById(Long id) {
        return Optional.ofNullable(customerMap.get(id));
    }

    public List<CustomerDTO> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    public void deleteById(Long id) {
        customerMap.remove(id);
    }

    public boolean existsById(Long id) {
        return customerMap.containsKey(id);
    }
}
