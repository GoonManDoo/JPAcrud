package com.example.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "board_user")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //오토 인크리먼트
    private Long id;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;
}
