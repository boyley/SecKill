package com.danlu.user.repository;

import com.danlu.user.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by lenovo on 2017/6/18.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @EntityGraph(attributePaths = "authorities")
    Optional<User> getByUsername(String lowercaseLogin);
}
