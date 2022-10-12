package com.boost.webapp.service;

import com.boost.webapp.repository.IUserRepository;
import com.boost.webapp.repository.entity.User;
import com.boost.webapp.repository.entity.enums.EGender;
import com.boost.webapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        super(userRepository);
        this.userRepository=userRepository;
    }

    public Optional<User> login (String username, String password){
        Optional<User> user=userRepository.findOptionalByUsernameAndPassword(username,password);

        if (user.isEmpty()){

            System.out.println("User is not found");
            return Optional.ofNullable(null);
        }
        return user;
    }

    public Optional<User> register(String username, String email) {
        Optional<User> user=userRepository.findOptionalByUsernameOrEmail(username,email);

        if (user.isEmpty()){

            System.out.println("User is not exist");
            return Optional.ofNullable(null);
        }
        return user;
    }
}
