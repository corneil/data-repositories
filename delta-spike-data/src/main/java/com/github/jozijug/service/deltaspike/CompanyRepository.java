package com.github.jozijug.service.deltaspike;

import com.github.jozijug.jpadomain.Company;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Company.class)
public interface CompanyRepository extends EntityRepository<Company, Long> {
}
