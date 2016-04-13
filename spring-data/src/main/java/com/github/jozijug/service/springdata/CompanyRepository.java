package com.github.jozijug.service.springdata;


import com.github.jozijug.jpadomain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findOneByName(String name);
    Long countByName(String name);
}
