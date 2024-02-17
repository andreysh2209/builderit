package com.example.builderit.repositories;


import com.example.builderit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin (String login);
}
