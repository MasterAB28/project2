package com.example.project2.Facade;

import com.example.project2.bean.Company;
import com.example.project2.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    private CompanyRepository repository;

    public CompanyFacade(CompanyRepository repository) {
        this.repository = repository;
    }
    public void addCompany(Company company){
        repository.save(company);
    }
    public void updateCompany(Company company){
        repository.save(company);
    }
    public void deleteCompany(Company company){
        repository.delete(company);
    }
    public List<Company> getAllCompanies(){
        return repository.findAll();
    }
    public Company getOneCompany(int id){
        return repository.findById(id).orElseThrow();
    }
}
