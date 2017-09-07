package com.astontech.oauth2.services;

import com.astontech.oauth2.domain.Member;
import com.astontech.oauth2.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Transactional
    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
