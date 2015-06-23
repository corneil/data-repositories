package com.github.jozijug.service.springdata;

import com.github.jozijug.jpadomain.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Corneil du Plessis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configurable
@ContextConfiguration(classes = {DataSourceConfig.class})
public class SpringDataTest {
    @Inject
    ContactRepository contactRepository;

    @Test
    public void testCountCompanyContacts() {
        long count = contactRepository.countByCompany_Name("BBD");
        assertEquals(46, count);
    }

    @Test
    public void testListCompanyContacts() {
        List<Contact> results = contactRepository.findByCompany_Name("BBD");
        assertEquals(46, results.size());
        for (Contact contact : results) {
            System.out.println(contact.toString());
        }
    }
}
