package com.github.jozijug.service.querydsl;

/**
 * Created by corneil on 2015/06/14.
 */

import com.github.jozijug.jpadomain.Contact;
import com.mysema.query.types.Predicate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.github.jozijug.jpadomain.QContact.*;
import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@Configurable
@ContextConfiguration(classes = {DataSourceConfig.class})
public class QueryDslDataTest {
    @Inject
    ContactRepository contactRepository;

    @Test
    public void testCountCompanyContacts() {
        Predicate p = contact.company.name.eq("BBD");
        long count = contactRepository.count(p);
        assertEquals(46, count);
    }
    @Test
    public void testListCompanyContacts() {
        Predicate p = contact.company.name.eq("BBD");
        Iterable<Contact> results = contactRepository.findAll(p);
        int count = 0;
        for(Contact contact : results) {
            count += 1;
            System.out.println(contact.toString());
        }
        assertEquals(46, count);
    }
}
