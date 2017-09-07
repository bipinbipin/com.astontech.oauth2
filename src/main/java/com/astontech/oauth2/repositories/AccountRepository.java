package com.astontech.oauth2.repositories;

import com.astontech.oauth2.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
