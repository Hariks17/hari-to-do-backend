package com.hari.repository;

import com.hari.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUseremail(String useremail);
}
