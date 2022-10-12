package com.boost.webapp.repository;

import com.boost.webapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findOptionalByUsernameAndPassword(String username, String password);

    Optional<User> findOptionalByUsernameOrEmail(String username, String email);
}
