package kr.ac.jejunu.project;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "userinfo")
public class User {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String password;
}
