package com.github.jozijug.service.deltaspike;

import com.github.jozijug.jpadomain.Contact;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


import javax.inject.Inject;
import java.util.List;

/**
 * @author Corneil du Plessis
 */
@RunWith(CdiTestRunner.class)
public class DeltaSpikeDataTest {
    @Inject
    ContactRepository contactRepository;
    @Test
    public void testCountCompanyContacts() {
        long count = contactRepository.findByCompany_name("BBD").count();
        assertEquals(46, count);
    }
    @Test
    public void testListCompanyContacts() {
        List<Contact> results = contactRepository.findByCompany_name("BBD").getResultList();
        assertEquals(46, results.size());
        for(Contact contact : results) {
            System.out.println(contact.toString());
        }
    }
}
