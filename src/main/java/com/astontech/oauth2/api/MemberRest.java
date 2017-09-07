package com.astontech.oauth2.api;

import com.astontech.oauth2.domain.Member;
import com.astontech.oauth2.repositories.MemberRepository;
import com.astontech.oauth2.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberRest {

    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    public Iterable<Member> getMember() {
        Iterable<Member> memberIterable = memberService.getAllMembers();
        return memberIterable;
    }
}
