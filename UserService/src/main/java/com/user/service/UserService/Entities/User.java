package com.user.service.UserService.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{
@Id
@Column(name="ID")
private String userId;

@Column(name="NAME",length = 20)
private String userName;

@Column(name="EMAIL")
private String email;

@Column(name="ABOUT")
private String about;

//@Transient Gpa ignores this and doesnt strore it in db
@Transient
private List<Rating> ratings = new ArrayList<Rating>();
}