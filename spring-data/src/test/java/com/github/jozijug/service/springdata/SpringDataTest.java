package com.github.jozijug.service.springdata;

/**
 * Created by corneil on 2015/06/14.
 */
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

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
}
