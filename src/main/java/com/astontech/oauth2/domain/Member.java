package com.astontech.oauth2.domain;

import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    String firstName;
    String lastName;
    String message;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;

}
