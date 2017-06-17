package com.danlu.user.repository;

import com.danlu.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneWithAuthoritiesByUsername(String login);

    Optional<User> findOneByUsername(String login);
}
