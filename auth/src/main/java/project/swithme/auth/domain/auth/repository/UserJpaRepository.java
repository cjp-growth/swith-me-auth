package project.swithme.auth.domain.auth.repository;

import project.swithme.auth.domain.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
