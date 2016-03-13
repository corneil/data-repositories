package com.github.jozijug.service.deltaspike;

import com.github.jozijug.jpadomain.Contact;
import com.github.jozijug.service.ContactService;
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
    ContactService contactService;
    // ContactRepository contactRepository;
    @Test
    public void testCountCompanyContacts() {
        long count = contactService.countByCompanyName("BBD");
        assertEquals(46, count);
    }
    @Test
    public void testListCompanyContacts() {
        List<Contact> results = contactService.findByCompanyName("BBD");
        assertEquals(46, results.size());
        for(Contact contact : results) {
            System.out.println(contact.toString());
        }
    }
}
