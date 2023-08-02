package com.swithmeauth.domain.district.repository;

import com.swithmeauth.domain.auth.entity.User;
import com.swithmeauth.domain.district.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictJpaRepository extends JpaRepository<District, Long> {
}
