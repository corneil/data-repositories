package com.github.jozijug.service.deltaspike;

import com.github.jozijug.jpadomain.Company;
import com.github.jozijug.jpadomain.Contact;
import com.github.jozijug.service.ContactService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * EJB to hide JPA related stuff from the UI layer.
 */
@Stateless
public class DeltaSpikeContactService implements ContactService {

    @Inject
    ContactRepository repository;

    @Inject
    CompanyRepository companyRepository;

    public DeltaSpikeContactService() {
    }

    @Override
    public void save(Contact entry) {
        repository.save(entry);
    }

    @Override
    public void delete(Contact value) {
        repository.remove(value);
    }

    @Override
    public List<Contact> findByCompanyAndName(Company company, String filter) {
        return repository.findByCompanyAndNameLikeIgnoreCase(company,
                "%" + filter + "%").getResultList();
    }

    @Override
    public List<Contact> findPageByCompanyAndName(Company company, String filter,
                                                  int firstrow, int maxrows) {
        return repository.findByCompanyAndNameLikeIgnoreCase(company,
                "%" + filter + "%").firstResult(firstrow).maxResults(maxrows).
                getResultList();
    }

    @Override
    public Long countByCompanyAndName(Company company, String filter) {
        return repository.findByCompanyAndNameLikeIgnoreCase(company,
                "%" + filter + "%").count();
    }

    @Override
    public List<Company> findCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Contact refreshEntry(Contact entry) {
        return repository.findBy(entry.getId());
    }

}
