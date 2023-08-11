package com.sairaj.Fullstackbackend.repository;

import com.sairaj.Fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
