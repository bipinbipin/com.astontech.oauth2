package com.astontech.oauth2.repositories;

import com.astontech.oauth2.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

    User findOneByUsername(String username);
}
