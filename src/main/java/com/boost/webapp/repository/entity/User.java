package com.boost.webapp.repository.entity;

import com.boost.webapp.repository.entity.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "tbluser")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class User extends Default {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String password;
    @Column(nullable = false, unique = true)
    String email;
    @Enumerated(EnumType.STRING)
    EGender gender;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_detail_id")
    UserDetail userDetail;
}
