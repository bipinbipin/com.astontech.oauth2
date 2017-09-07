package com.astontech.oauth2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  Contributors:   Bipin Butala
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.astontech.oauth2.domain"})
@EnableJpaRepositories(basePackages = {"com.astontech.oauth2.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
