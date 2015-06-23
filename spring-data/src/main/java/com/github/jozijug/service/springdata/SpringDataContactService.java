package com.github.jozijug.service.springdata;

import com.github.jozijug.jpadomain.Company;
import com.github.jozijug.jpadomain.Contact;
import com.github.jozijug.service.ContactService;

import org.springframework.data.domain.PageRequest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Corneil du Plessis
 */
@Stateless
public class SpringDataContactService implements ContactService {

    @Inject
    ContactRepository repository;

    @Inject
    CompanyRepository companyRepository;

    public SpringDataContactService() {
    }

    public void save(Contact entry) {
        repository.save(entry);
    }

    public void delete(Contact value) {
        repository.delete(value);
    }

    public List<Contact> findByCompanyAndName(Company company, String filter) {
        return repository.findByCompanyAndNameLikeIgnoreCase(company, filter + "%");
    }

    public List<Contact> findPageByCompanyAndName(Company company, String filter,
            int firstrow, int maxrows) {
        return repository.findByCompanyAndNameLikeIgnoreCase(company,
                filter + "%",
                new PageRequest(firstrow / maxrows, maxrows))
                .getContent();
    }

    public Long countByCompanyAndName(Company company, String filter) {
        return repository.countByCompanyAndNameLikeIgnoreCase(company,
                filter + "%");
    }

    public List<Company> findCompanies() {
        return companyRepository.findAll();
    }

    public Contact refreshEntry(Contact entry) {
        return repository.findOne(entry.getId());
    }

}
