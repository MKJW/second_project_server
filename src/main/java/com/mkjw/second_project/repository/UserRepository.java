package com.mkjw.second_project.repository;

import com.mkjw.second_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    @Override
    void delete(User user);
}
