package com.github.jozijug.service;



import com.github.jozijug.jpadomain.Company;
import com.github.jozijug.jpadomain.Contact;

import java.util.List;

/**
 * @author Corneil du Plessis
 */
public interface ContactService {
    void save(Contact entry);

    void delete(Contact value);

    List<Contact> findByCompanyName(String name);

    List<Contact> findByCompanyAndName(Company company, String filter);

    List<Contact> findPageByCompanyAndName(Company company, String filter,
                                           int firstrow, int maxrows);

    Long countByCompanyName(String name);
    Long countByCompanyAndName(Company company, String filter);

    List<Company> findCompanies();

    Contact refreshEntry(Contact entry);
}
