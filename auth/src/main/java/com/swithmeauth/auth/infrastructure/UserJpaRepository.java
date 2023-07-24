package com.swithmeauth.auth.infrastructure;

import com.swithmeauth.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
