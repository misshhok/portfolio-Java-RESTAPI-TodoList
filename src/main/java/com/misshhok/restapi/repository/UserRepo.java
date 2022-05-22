package com.misshhok.restapi.repository;

import com.misshhok.restapi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername (String username);
}
