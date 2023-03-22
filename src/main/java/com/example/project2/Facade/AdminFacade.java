package com.example.project2.Facade;


import com.example.project2.bean.Company;
import com.example.project2.exeptionsCoupns.CouponException;
import com.example.project2.repositories.CompanyRepository;
import com.example.project2.repositories.CouponRepository;
import com.example.project2.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminFacade extends ClientFacade {

    public AdminFacade(CustomerRepository customerRepo, CompanyRepository companyRepo, CouponRepository couponRepo) {
        super(customerRepo, companyRepo, couponRepo);
    }

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    public void addCompany(Company company) throws CouponException {
        if (companyRepo.existsByEmailOrName(company.getEmail(), company.getName()))
            throw new CouponException("Company email or name exists");
        companyRepo.save(company);
    }

    public void updateCompany(Company company) throws CouponException {
        Company companyToCheck = companyRepo.findById(company.getId()).orElseThrow();
        if (companyToCheck.getName().equals(company.getName())) {
            companyRepo.save(company);
            return;
        }
        throw new CouponException("You can't change the company name!");
    }
    public void deleteCompany(int companyId) throws CouponException {
        if (companyRepo.existsById(companyId)) {
            companyRepo.deleteById(companyId);
            return;
        }
        throw new CouponException("The company delete is failed");
    }
}
