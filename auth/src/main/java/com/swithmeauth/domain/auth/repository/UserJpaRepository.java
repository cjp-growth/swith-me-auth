package com.swithmeauth.domain.auth.repository;

import com.swithmeauth.domain.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
