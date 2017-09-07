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


    }


}