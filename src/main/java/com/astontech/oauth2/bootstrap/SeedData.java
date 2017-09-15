package com.astontech.oauth2.bootstrap;

import com.astontech.oauth2.domain.Account;
import com.astontech.oauth2.domain.Member;
import com.astontech.oauth2.domain.User;
import com.astontech.oauth2.repositories.MemberRepository;
import com.astontech.oauth2.services.UserService;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Log4j
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {


	private MemberRepository memberRepository;

    @Autowired
    public SeedData(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateMembers();

    }

    public void generateMembers() {
        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account();
        account1.setAccountId(11111);
        Account account2 = new Account();
        account2.setAccountId(22222);
        Account account3 = new Account();
        account3.setAccountId(33333);


        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        Member member = new Member();
        member.setFirstName("Bipin");
        member.setLastName("Butala");
        member.setMessage("sEcrEt!!");

        member.setAccounts(accountList);
        memberRepository.save(member);

        List<Account> accountList2 = new ArrayList<>();
        Account account4 = new Account();
        account1.setAccountId(11111);
        Account account5 = new Account();
        account2.setAccountId(22222);
        Account account6 = new Account();
        account3.setAccountId(33333);


        accountList2.add(account4);
        accountList2.add(account5);
        accountList2.add(account6);

        Member member2 = new Member();
        member2.setFirstName("Nikola");
        member2.setLastName("Tesla");
        member2.setMessage("The scientists of today think deeply instead of clearly. One must be sane to think clearly, but one can think deeply and be quite insane");

        member2.setAccounts(accountList2);
        memberRepository.save(member2);

    }


}