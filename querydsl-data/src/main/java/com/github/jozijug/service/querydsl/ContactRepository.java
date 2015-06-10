package com.github.jozijug.service.querydsl;

import com.github.jozijug.jpadomain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ContactRepository extends JpaRepository<Contact, Long>, QueryDslPredicateExecutor<Contact> {
}
