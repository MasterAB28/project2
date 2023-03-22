package com.example.project2.repositories;

import com.example.project2.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    boolean existsByEmailOrName(String email,String name);
}
