package com.example.project2.Facade;

import com.example.project2.bean.Customer;
import com.example.project2.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFacade {
    private CustomerRepository repository;

    public CustomerFacade(CustomerRepository repository) {
        this.repository = repository;
    }
    public void addCustomer(Customer customer){
        repository.save(customer);
    }
    public void updateCustomer(Customer customer){
        repository.save(customer);
    }
    public void deleteCustomer(Customer customer){
        repository.delete(customer);
    }
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }
    public Customer getOneCustomer(int id){
        return repository.findById(id).orElseThrow();
    }
}
