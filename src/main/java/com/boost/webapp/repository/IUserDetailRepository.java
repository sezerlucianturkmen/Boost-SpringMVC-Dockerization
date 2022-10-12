package com.boost.webapp.repository;

import com.boost.webapp.repository.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDetailRepository extends JpaRepository<UserDetail,Long> {
}
