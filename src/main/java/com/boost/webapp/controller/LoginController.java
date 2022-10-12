package com.boost.webapp.controller;

import com.boost.webapp.dto.request.LoginRequestDto;
import com.boost.webapp.dto.request.UserDetailSaveRequestDto;
import com.boost.webapp.dto.request.UserSaveRequestDto;
import com.boost.webapp.exception.ErrorType;
import com.boost.webapp.exception.MonolithicManagerException;
import com.boost.webapp.repository.entity.User;
import com.boost.webapp.repository.entity.UserDetail;
import com.boost.webapp.repository.entity.enums.EGender;
import com.boost.webapp.service.UserDetailService;
import com.boost.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

import static com.boost.webapp.constant.EndPoint.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {
    private  final UserService userService;
    private  final UserDetailService userDetailService;

    @GetMapping(LOGIN)
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(DOLOGIN)
    public ModelAndView dologin(LoginRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        Optional<User> user=userService.login(dto.getUsername(),dto.getPassword());

        if(user.isPresent()){
                modelAndView.addObject("user",user.get());
            modelAndView.addObject("detail",user.get().getUserDetail());
                modelAndView.setViewName("home");

        }else{
            modelAndView.setViewName("redirect:login");
            throw new MonolithicManagerException(ErrorType.USERNAME_OR_PASSWORD_MISMATCH);
        }
        return modelAndView;
    }

    @GetMapping(REGISTER)
    public ModelAndView register(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping(DOREGISTER)
    public ModelAndView doregister(UserSaveRequestDto dto1, UserDetailSaveRequestDto dto2){
        ModelAndView modelAndView=new ModelAndView();
        Optional<User> user=userService.register(dto1.getUsername(),dto1.getEmail());
        if(user.isPresent()){
            modelAndView.setViewName("redirect:login"); // nasıl uyarı verebilirim kullanıcı veri tabanınca mevcut
            throw new MonolithicManagerException(ErrorType.USER_EXIST);
        }else{
            UserDetail newUserDetail=UserDetail.builder()
                    .name(dto2.getName())
                    .surname(dto2.getSurname())
                    .address(dto2.getAddress())
                    .telephone(dto2.getTelephone())
                    .dob(LocalDate.parse(dto2.getDob()))
                    .build();

            User newUser=User.builder()
                    .username(dto1.getUsername())
                    .password(dto1.getPassword())
                    .email(dto1.getEmail())
                    .gender(EGender.valueOf(dto1.getGender()))
                    .userDetail(newUserDetail)
                    .build();

            userService.save(newUser);
            modelAndView.setViewName("redirect:login");
        }
        return modelAndView;
    }



}
