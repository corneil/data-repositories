package com.github.jozijug.service.deltaspike;

import com.github.jozijug.jpadomain.Company;
import com.github.jozijug.jpadomain.Contact;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository(forEntity = Contact.class)
public interface ContactRepository extends EntityRepository<Contact, Long> {

    public List<Contact> findByCompany(Company company);

    public QueryResult findByCompanyAndNameLikeIgnoreCase(Company company, String string);
}
