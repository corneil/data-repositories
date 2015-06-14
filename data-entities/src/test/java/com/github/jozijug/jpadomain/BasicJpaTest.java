package com.github.jozijug.jpadomain;

import com.github.jozijug.CdiConfig;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by corneil on 2015/06/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configurable
@ContextConfiguration(classes = {DataSourceConfig.class, CdiConfig.class})
public class BasicJpaTest {
    @Inject
    EntityManager entityManager;

    @Test
    public void testCountCompany() {
        Query query = entityManager.createQuery("select count(c) from Contact c where c.company.name = 'BBD'");
        Object result = query.getSingleResult();
        long count =  0;
        if(result instanceof Number) {
            count = ((Number)result).longValue();
        } else if(result.getClass().isArray()) {
            Object value = ((Object[])result)[0];
            count = ((Number)value).longValue();
        }
        assertEquals(46, count);
    }
}
