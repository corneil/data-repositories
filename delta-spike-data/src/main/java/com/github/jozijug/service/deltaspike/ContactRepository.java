package com.github.jozijug.service.deltaspike;

import com.github.jozijug.jpadomain.Company;
import com.github.jozijug.jpadomain.Contact;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository(forEntity = Contact.class)
public interface ContactRepository extends EntityRepository<Contact, Long> {
    List<Contact> findByCompany(Company company);
    QueryResult<Contact> findByCompany_name(String companyName);
    QueryResult<Contact> findByCompanyAndNameLikeIgnoreCase(Company company, String string);
}
