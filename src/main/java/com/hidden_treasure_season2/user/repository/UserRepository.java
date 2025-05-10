package com.hidden_treasure_season2.user.repository;

import com.hidden_treasure_season2.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
