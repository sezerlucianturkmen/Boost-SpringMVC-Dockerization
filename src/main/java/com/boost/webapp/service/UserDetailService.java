package com.boost.webapp.service;

import com.boost.webapp.repository.IUserDetailRepository;
import com.boost.webapp.repository.entity.UserDetail;
import com.boost.webapp.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService {
    private final IUserDetailRepository userDetailRepository;

    public UserDetail save(UserDetail userDetail){        
        return userDetailRepository.save(userDetail);
    }
    public UserDetail update(UserDetail userDetail){
        return userDetailRepository.save(userDetail);
    }
    public void delete(UserDetail userDetail){
        userDetailRepository.delete(userDetail);
    }
    public List<UserDetail> findAll(){
        return userDetailRepository.findAll();
    }
    public Iterable<UserDetail> saveAll(List<UserDetail> userDetailler){
        return userDetailRepository.saveAll(userDetailler);
    }
    
}
