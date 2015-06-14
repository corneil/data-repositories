package com.github.jozijug.service.springdata;

/**
 * Created by corneil on 2015/06/14.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.jozijug.service.springdata")
public class ModuleConfig {
}
