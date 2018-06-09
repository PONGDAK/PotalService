package com.study.spring.hello;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "userinfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    @JoinColumn(name = "userinfo_id")
    @OneToMany
    @JsonIgnore   //무한참조하는것을방지  user의 comment의 user아이디 루프
    private List<Comment> comments;
}

