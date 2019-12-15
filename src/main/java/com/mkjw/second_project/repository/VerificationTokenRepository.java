package com.mkjw.second_project.repository;

import com.mkjw.second_project.entity.User;
import com.mkjw.second_project.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
