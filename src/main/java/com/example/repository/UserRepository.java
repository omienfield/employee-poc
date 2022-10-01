package com.example.repository;

import com.example.entities.UserCred;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserCred, Integer> {

    @Query(value = "from UserCred u where u.userName = :userName or u.password = :password")
    public UserCred getUser(String userName, String password);
}
