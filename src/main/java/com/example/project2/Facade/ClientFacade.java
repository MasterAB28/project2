package com.example.project2.Facade;

import com.example.project2.repositories.CompanyRepository;
import com.example.project2.repositories.CouponRepository;
import com.example.project2.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientFacade {
    protected CustomerRepository customerRepo;
    protected CompanyRepository companyRepo;
    protected CouponRepository couponRepo;

    public ClientFacade(CustomerRepository customerRepo, CompanyRepository companyRepo, CouponRepository couponRepo) {
        this.customerRepo = customerRepo;
        this.companyRepo = companyRepo;
        this.couponRepo = couponRepo;
    }

    public abstract boolean login (String email, String password);
}
