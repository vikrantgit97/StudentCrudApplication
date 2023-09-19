package com.crudapp.repo;

import com.crudapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);

    @Modifying
    @Query("UPDATE User SET password=:encPwd WHERE id=:userId")
    void updateUserPwd(String encPwd, Integer userId);
}
