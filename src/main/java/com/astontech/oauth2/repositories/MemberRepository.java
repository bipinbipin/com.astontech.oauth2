package com.astontech.oauth2.repositories;

import com.astontech.oauth2.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
