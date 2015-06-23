package com.github.jozijug.service.querydsl;

import com.github.jozijug.jpadomain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CompanyRepository extends JpaRepository<Company, Long>, QueryDslPredicateExecutor<Company> {
}
