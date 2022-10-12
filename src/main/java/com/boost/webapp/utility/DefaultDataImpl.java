package com.boost.webapp.utility;

import com.boost.webapp.repository.entity.User;
import com.boost.webapp.repository.entity.UserDetail;
import com.boost.webapp.repository.entity.enums.EGender;
import com.boost.webapp.service.UserDetailService;
import com.boost.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DefaultDataImpl {
    private final UserService userService;
    private final UserDetailService userDetailService;
    @PostConstruct
    private void create(){
        saveUser();
    }

    private void saveUser() {

        UserDetail userDetail1=UserDetail.builder()
                .name("john")
                .surname("Black")
                .address("London")
                .dob(LocalDate.parse("1990-10-06"))
                .telephone("05056077080")
                .build();

        UserDetail userDetail2=UserDetail.builder()
                .name("Sezer")
                .surname("Turkmen")
                .address("Istanbul")
                .dob(LocalDate.parse("1992-10-31"))
                .telephone("05056789545")
                .build();

        UserDetail userDetail3=UserDetail.builder()
                .name("Cem")
                .surname("Kaya")
                .address("Izmir")
                .dob(LocalDate.parse("1996-06-06"))
                .telephone("05456780022")
                .build();

        UserDetail userDetail4=UserDetail.builder()
                .name("Roberta")
                .surname("Ferrari")
                .address("Milano")
                .dob(LocalDate.parse("1980-05-20"))
                .telephone("03888455655")
                .build();

        UserDetail userDetail5=UserDetail.builder()
                .name("Ela")
                .surname("Yilmaz")
                .address("Adana")
                .dob(LocalDate.parse("2000-10-06"))
                .telephone("05334449868")
                .build();

        User user1= User.builder()
                .username("blackjohn")
                .password("123456")
                .email("john@gmail.com")
                .gender(EGender.MALE)
                .userDetail(userDetail1)
                .build();

        User user2= User.builder()
                .username("sezer")
                .password("123456")
                .email("sezer@gmail.com")
                .gender(EGender.MALE)
                .userDetail(userDetail2)
                .build();

        User user3= User.builder()
                .username("cemcem")
                .password("123456")
                .email("cem@gmail.com")
                .gender(EGender.MALE)
                .userDetail(userDetail3)
                .build();

        User user4= User.builder()
                .username("roberta")
                .password("123456")
                .email("roberta@gmail.com")
                .gender(EGender.FEMALE)
                .userDetail(userDetail4)
                .build();

        User user5= User.builder()
                .username("elayilmaz")
                .password("123456")
                .email("ela@gmail.com")
                .gender(EGender.FEMALE)
                .userDetail(userDetail5)
                .build();

        userService.saveAll(Arrays.asList(user1,user2,user3,user4,user5));

    }


}
