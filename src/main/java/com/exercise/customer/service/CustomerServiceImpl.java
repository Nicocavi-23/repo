package com.exercise.customer.service;

import com.exercise.customer.entity.Customer;
import com.exercise.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>)repository.findAll();
    }

    @Override
    public Customer insert(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public String findByIdString(Long id) {
        Optional<Customer> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get().toString();
        } else {
            return null;
        }
    }

    @Override
    public Long findIdByCode(String code) {
        Iterable<Customer> result = repository.findAll();
        for(Customer c : result){
            if (c.getCode()!= null) {
                if (c.getCode().equals(code)) {
                    return c.getId();
                }
            }
        }
        return null;
    }


    @Override
    public Customer update(Customer customer, Long orderId) {

        Customer cusDB = repository.findById(orderId).get();

        if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())){
            cusDB.setName(customer.getName());
        }

        if (Objects.nonNull(customer.getSurname()) && !"".equalsIgnoreCase(customer.getSurname())){
            cusDB.setSurname(customer.getSurname());
        }

        if (Objects.nonNull(customer.getPhone()) && !"".equalsIgnoreCase(customer.getPhone())){
            cusDB.setPhone(customer.getPhone());
        }

        if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())){
            cusDB.setEmail(customer.getEmail());
        }

        if (Objects.nonNull(customer.getCode()) && !"".equalsIgnoreCase(customer.getCode())){
            cusDB.setCode(customer.getCode());
        }
        return repository.save(cusDB);
    }
}
