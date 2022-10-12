package com.boost.webapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tbluserdetail")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String address;
    String telephone;
    LocalDate dob;
}
