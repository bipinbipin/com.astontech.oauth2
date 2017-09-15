package com.astontech.oauth2.api;

import com.astontech.oauth2.domain.Member;
import com.astontech.oauth2.repositories.MemberRepository;
import com.astontech.oauth2.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
public class MemberRest {

    @Autowired
    MemberService memberService;

    // region SECURED

    @GetMapping("/member")
    public Iterable<Member> getAllMember() {
        return memberService.getAllMembers();
    }

    @GetMapping("/member/{id}")
    public Member getByIdMember(@PathVariable Integer id) {
        return memberService.getOneMemberById(id);
    }

    //endregion

    //region UNSECURED

    @GetMapping("/test")
    public Iterable<Member> getAllTest(HttpServletResponse response) {
        addHeaders(response);
        return memberService.getAllMembers();
    }

    @GetMapping("/test/{id}")
    public Member getByIdTest(@PathVariable Integer id, HttpServletResponse response) {
        addHeaders(response);
        return memberService.getOneMemberById(id);
    }

    // endregion

    public void addHeaders(HttpServletResponse response) {
        response.setHeader("Company", "Aston");
    }
}

